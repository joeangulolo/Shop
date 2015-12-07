package co.edu.unal.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import co.edu.unal.shared.LoginInfo;
import co.edu.unal.shared.Product;
import co.edu.unal.shared.User;

@RemoteServiceRelativePath("clientService")
public interface ClientService extends RemoteService {

	Product addProduct (Product product);
	// Product getProduct(String id);
	User addUser(User user);

	LoginInfo login(String requestUri);

	LoginInfo loginDetails(String token);

}
