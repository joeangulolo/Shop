package co.edu.unal.client.service;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

//import co.edu.unal.client.RegisterView;
import co.edu.unal.shared.Product;
import co.edu.unal.shared.User;

public class ClientServiceImpl implements ClientServiceInt {

	private ClientServiceAsync service;
	//private RegisterView register;
	
	public ClientServiceImpl(String url){
		System.out.println(url);
		this.service = GWT.create(ClientService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
		endpoint.setServiceEntryPoint(url);
		
		//this.register = new RegisterView(this);
	}
	
//	@Override
//	public void addProduct(Product product) {
//		this.service.addProduct(product, new DefaultCallback());
//		
//	}
//
//	@Override
//	public void getProduct(String id) {
//		this.service.getProduct(id, new DefaultCallback());
//		
//	}

	@Override
	public void addUser(User user) {
		this.service.addUser(user, new DefaultCallback());
		
	}
	
//	public RegisterView getRegister(){
//		return this.register;
//	}
	
	public class DefaultCallback implements AsyncCallback{

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error ocured");
			
		}

		@Override
		public void onSuccess(Object result) {
			System.out.println("Response");
			if (result instanceof Product){
				Product product = (Product)result;
			}
			else if (result instanceof User){
				User user = (User) result;
				//register.updateLabel(user);
			}

			
		}
		
	}

}
