package co.edu.unal.client.view;

import java.util.LinkedList;

import co.edu.unal.shared.Product;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.ListDataProvider;

public class CarritoView extends Composite {
	
	private DecoratedStackPanel pc = new DecoratedStackPanel();
	
	public CarritoView(){
		initWidget(this.pc);
		
		final CellTable<Product> table = new CellTable<Product>(); 
		
		 final ListDataProvider<Product> model = new ListDataProvider<Product>(
				getUserList());

		Column<Product, String> nameColumn = new Column<Product, String>(
				new EditTextCell()) {
			@Override
			public String getValue(Product aUser) {
				return aUser.getName();
			}
		};

		nameColumn.setSortable(true);
		table.addColumn(nameColumn, "Product Name");

		Column<Product, String> idColumn = new Column<Product, String>(
				new EditTextCell()) {
			@Override
			public String getValue(Product aUser) {
				return aUser.getId().toString();
			}
		};

		table.addColumn(idColumn, "ID No");
		
		Column<Product, String> deleteBtn = new Column<Product, String>(
				new ButtonCell()) {
			@Override
			public String getValue(Product c) {
				return "x";
			}
		};
		
		table.addColumn(deleteBtn, "");

		// when user clicks on x, update gets called and one record gets deleted.
				deleteBtn.setFieldUpdater(new FieldUpdater<Product, String>() {

					@Override
					public void update(int index, Product object, String value) {
						model.getList().remove(object);
						model.refresh();
						table.redraw();

					}
				});

				table.setRowCount(getUserList().size());
				model.addDataDisplay(table);

				
				pc.add(table);
		
//		TextColumn<Product> nameColumn = 
//			      new TextColumn<Product>() {
//			         @Override
//			         public String getValue(Product object) {
//			            return object.name;
//			         }
//			      };
//		
//		carrito.addColumn(nameColumn, "Name");
//		
//		NumberCell price = new NumberCell();
//		
//		Column<Product, Number> priceColumn 
//	      = new Column<Product, Number>(price) {
//	         @Override
//	         public Number getValue(Product object) {
//	            return object.price;
//	         }
//	      };
	      
	     
	      
//	      Column<Product, String> deleteBtn = new Column<Product, String>(
//					new ButtonCell()) {
//				@Override
//				public String getValue(Product c) {
//					return "x";
//				}
//			};

	      
		
	}
	
	private LinkedList<Product> getUserList() {
		LinkedList<Product> list = new LinkedList<Product>();
		list.add(new Product("12345", "serbia custome", 50,1));
		list.add(new Product("22454", "serbia2 custome",25,3));
		list.add(new Product("35764", "serbia3 custome",30,2));
		return list;
	}

}
