package co.edu.unal.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Product implements Serializable{
	
	@Id public String id;
	public String name;
	public Number price;
	public Integer stock;
	
	public Product(){
		
	}
	
	public Product(String id, String name, Number price, Integer stock){
		this.id = id;
		this.name =name;
		this.price=price;
		this.stock=stock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number getPrice() {
		return price;
	}

	public void setPrice(Number price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	
	

}
