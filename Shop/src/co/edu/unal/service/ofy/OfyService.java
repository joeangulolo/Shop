package co.edu.unal.service.ofy;

import static com.googlecode.objectify.ObjectifyService.factory;
import co.edu.unal.shared.Product;
import co.edu.unal.shared.User;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class OfyService {
	static {
		factory().register(User.class);
		factory().register(Product.class);
	}

	public static Objectify ofy() {
		return ObjectifyService.ofy();
	}
	
	public static ObjectifyFactory factory() {
	    return ObjectifyService.factory();
	}
}
