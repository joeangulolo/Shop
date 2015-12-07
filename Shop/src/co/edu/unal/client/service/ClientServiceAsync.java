package co.edu.unal.client.service;

import co.edu.unal.shared.LoginInfo;
import co.edu.unal.shared.Product;
import co.edu.unal.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ClientServiceAsync {
	
	void addProduct(Product product, AsyncCallback<Product> callback);
	//void getProduct(String id, AsyncCallback<Product> callback);
	void addUser(User user, AsyncCallback<User> callback);

	void login(String requestUri, AsyncCallback<LoginInfo> asyncCallback);

	void loginDetails(String token, AsyncCallback<LoginInfo> asyncCallback);

}
