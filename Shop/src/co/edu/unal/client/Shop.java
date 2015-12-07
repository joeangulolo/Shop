package co.edu.unal.client;





import java.util.Random;

import co.edu.unal.client.service.ClientService;
import co.edu.unal.client.service.ClientServiceAsync;
import co.edu.unal.client.service.ClientServiceImpl;
import co.edu.unal.client.view.ProductsView;
import co.edu.unal.shared.LoginInfo;
import co.edu.unal.shared.User;

import com.google.api.gwt.oauth2.client.Auth;
import com.google.api.gwt.oauth2.client.AuthRequest;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Shop implements EntryPoint {
	
	private ClientServiceAsync rpcService = com.google.gwt.core.shared.GWT.create(ClientService.class);
	private User u;
	/**
	 * This is the entry point method.
	 */
	VerticalPanel vPanel = new VerticalPanel();
	Anchor loginLink;
	
//	 TODO #05: add constants for OAuth2 (don't forget to update GOOGLE_CLIENT_ID)
			private static final Auth AUTH = Auth.get();
			private static final String GOOGLE_AUTH_URL = "https://accounts.google.com/o/oauth2/auth";
			private static final String GOOGLE_CLIENT_ID = "133230330852-v34pmbjjlv036np585laj4lcuta34aa4.apps.googleusercontent.com";
			private static final String PLUS_ME_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
//			
//			private final Anchor signInLink = new Anchor("");
//			private final Image loginImage = new Image();
//			private final TextBox nameField = new TextBox();
//			
//			private final ClientServiceImpl greetingService = GWT.create(ClientServiceImpl.class);
//			
			private void loadLogin(final LoginInfo loginInfo) {
				loginLink.setHref(loginInfo.getLoginUrl());
				loginLink.setText("*ENTRAR*");
				loginLink.setTitle("Sign in");
			}

			private void loadLogout(final LoginInfo loginInfo) {
				loginLink.setHref(loginInfo.getLogoutUrl());
				loginLink.setText(loginInfo.getName());
				loginLink.setTitle("Sign out");
			}

			private void addGoogleAuthHelper() {
				final AuthRequest req = new AuthRequest(GOOGLE_AUTH_URL, GOOGLE_CLIENT_ID)
						.withScopes(PLUS_ME_SCOPE);
				AUTH.login(req, new Callback<String, Throwable>() {
					@Override
					public void onSuccess(final String token) {
						
						if (!token.isEmpty()) {
							rpcService.loginDetails(token, new AsyncCallback<LoginInfo>() {
								@Override
								public void onFailure(final Throwable caught) {
									GWT.log("loginDetails -> onFailure");
								}

								@Override
								public void onSuccess(final LoginInfo loginInfo) {
									Window.alert("Bienvenido");
									loginLink.setText(loginInfo.getName());
									
								}
							});
						}
					}

					@Override
					public void onFailure(final Throwable caught) {
						Window.alert("Error while logging in: " + caught);
						GWT.log("Error -> loginDetails\n" + caught.getMessage());
					}
				});
				}
	
	public void onModuleLoad() {
		
		HorizontalPanel hPanel = new HorizontalPanel();
		Label mlb = new Label("Welcome to the international Shop Traditional Costume");
		mlb.getElement().getStyle().setColor("blue");
		PushButton img = new PushButton(new Image("/images/portal1.jpg"));
		PushButton img2 = new PushButton(new Image("/images/portal2.jpg"));
		PushButton img3 = new PushButton(new Image("/images/portal3.jpg"));
		
		hPanel.add(img);
		hPanel.add(img2);
		hPanel.add(img3);
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.add(hPanel);
		vPanel.add(mlb);
		//vPanel.getElement().addClassName("cual");
		
		
		loginLink = new Anchor("Entrar");
//		loginLink.addClickHandler(new SendClickHandler());
		vPanel.add(loginLink);
		
		//RegisterView register = new RegisterView();
		//ProductsView pv = new ProductsView();
		//ClientServiceImpl clientimpl = new ClientServiceImpl(GWT.getModuleBaseURL() +"service");
		//RegisterView register = new RegisterView(null);
		//RootPanel.get().add(clientimpl.getRegister());
		RootPanel.get().add(vPanel);
		//RootPanel.get().add(pv);
		
		rpcService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
			@Override
			public void onFailure(final Throwable caught) {
				GWT.log("login -> onFailure");
			}

			@Override
			public void onSuccess(final LoginInfo result) {
				if (result.getName() != null && !result.getName().isEmpty()) {
					addGoogleAuthHelper();
					loadLogout(result);
				} else {
					loadLogin(result);
					String name = result.getName();
					String mail = result.getEmailAddress();
					String id = GenId();
					u = new User(id, name, mail);
					ProductsView pv = new ProductsView();
					vPanel.setVisible(false);
					Window.alert("Bien2");
					RootPanel.get().add(pv);
					
					//addUser();
//					rpcService.addUser(u,new AsyncCallback<User>() {
//
//						@Override
//						public void onFailure(Throwable caught) {
//							Window.alert("Fallo agregar usuario");
//							
//						}
//
//						@Override
//						public void onSuccess(User result) {
//							vPanel.setVisible(false);
//							ProductsView pv = new ProductsView();
//							Window.alert("Bien2");
//							RootPanel.get().add(pv);
//							
//						}
//					});
				}
			}

			private void addUser() {
				rpcService.addUser(u,new AsyncCallback<User>() {
					//
											@Override
											public void onFailure(Throwable caught) {
												Window.alert("Fallo agregar usuario");
												
											}
					
											@Override
											public void onSuccess(User result) {
												vPanel.setVisible(false);
												ProductsView pv = new ProductsView();
												Window.alert("Bien2");
												RootPanel.get().add(pv);
												
											}
										});
				
			}
		});
}
	
	private String GenId(){
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		return output;
	}
	
//	private class SendClickHandler implements ClickHandler{
//
//		@Override
//		public void onClick(ClickEvent event) {
//			vPanel.setVisible(false);
//			Window.alert("Bien");
//			ClientServiceImpl clientimpl = new ClientServiceImpl(GWT.getModuleBaseURL()+"clientService");
//			Window.alert("Bien2");
//			//RegisterView register = new RegisterView(null);
//			//RootPanel.get().add(clientimpl.getRegister());
//		}
//		
//	}
}
