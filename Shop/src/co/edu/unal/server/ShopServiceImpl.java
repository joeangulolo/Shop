package co.edu.unal.server;

import static co.edu.unal.service.ofy.OfyService.ofy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import co.edu.unal.client.service.ClientService;
import co.edu.unal.shared.LoginInfo;
import co.edu.unal.shared.Product;
import co.edu.unal.shared.User;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.LoadResult;

public class ShopServiceImpl extends RemoteServiceServlet implements ClientService{
	
	



	@Override
	public Product addProduct(Product product) {
		Key<Product> key = storeProduct(product);
		String pid = product.getId().toString();
		Product pr =  loadProduct(pid);
		return pr;
	}
//
//	@Override
//	public Product getProduct(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	private Product loadProduct(String pid) {
		LoadResult<Product> rs = ofy().load().type( Product.class ).id( pid );
		
		return rs.now();
	}

	private Key<Product> storeProduct(Product product) {
		return ofy().save().entity( product ).now();
	}

	@Override
	public User addUser(User user) {
		//List<Key<User>> userlist = new ArrayList<Key<User>>();
		Key<User> key = storeUser(user);
		String id = user.getId();
		User u = loadUser(id);
		return user;
	}


	private User loadUser(String id) {
		LoadResult<User> r = ofy().load().type( User.class ).id( id );
		
		return r.now();
	}


	private Key<User> storeUser(User user) {
		
		return ofy().save().entity( user ).now();
	}


	@Override
	public LoginInfo login(String requestUri) {
		final UserService userService = UserServiceFactory.getUserService();
		final com.google.appengine.api.users.User user = userService.getCurrentUser();
		final LoginInfo loginInfo = new LoginInfo();
		if (user != null) {
			loginInfo.setLoggedIn(true);
			loginInfo.setName(user.getEmail());
			loginInfo.setLogoutUrl(userService.createLogoutURL(requestUri));
		} else {
			loginInfo.setLoggedIn(false);
			loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
		}
		return loginInfo;
	}

	@Override
	public LoginInfo loginDetails(String token) {
		String url = "https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token=" + token;

		final StringBuffer r = new StringBuffer();
		try {
			final URL u = new URL(url);
			final URLConnection uc = u.openConnection();
			final int end = 1000;
			InputStreamReader isr = null;
			BufferedReader br = null;
			try {
				isr = new InputStreamReader(uc.getInputStream());
				br = new BufferedReader(isr);
				final int chk = 0;
				while ((url = br.readLine()) != null) {
					if ((chk >= 0) && ((chk < end))) {
						r.append(url).append('\n');
					}
				}
			} catch (final java.net.ConnectException cex) {
				r.append(cex.getMessage());
			} catch (final Exception ex) {
			} finally {
				try {
					br.close();
				} catch (final Exception ex) {
				}
			}
		} catch (final Exception e) {
		}

		final LoginInfo loginInfo = new LoginInfo();
		try {
			final JsonFactory f = new JsonFactory();
			JsonParser jp;
			jp = f.createJsonParser(r.toString());
			jp.nextToken();
			while (jp.nextToken() != JsonToken.END_OBJECT) {
				final String fieldname = jp.getCurrentName();
				jp.nextToken();
				if ("picture".equals(fieldname)) {
					loginInfo.setPictureUrl(jp.getText());
				} else if ("name".equals(fieldname)) {
					loginInfo.setName(jp.getText());
				} else if ("email".equals(fieldname)) {
					loginInfo.setEmailAddress(jp.getText());
				}
			}
		} catch (final JsonParseException e) {
		} catch (final IOException e) {
		}
		return loginInfo;
	}




}
