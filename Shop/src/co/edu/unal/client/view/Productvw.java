package co.edu.unal.client.view;

import java.util.LinkedList;
import java.util.List;

import co.edu.unal.client.service.ClientService;
import co.edu.unal.client.service.ClientServiceAsync;
import co.edu.unal.shared.Product;
import co.edu.unal.shared.User;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class Productvw extends Composite {

	private ClientServiceAsync service = com.google.gwt.core.shared.GWT.create(ClientService.class);
	Label title = new Label("Welcome to the Internalitional Costume Shop! You can see the product detail if you click in each product");
//	Button buy = new Button("Add to Cart");
//	Button buy2 = new Button("Add to Cart");
//	Button buy3 = new Button("Add to Cart");
//	Button buy4 = new Button("Add to Cart");
//	Button buy5 = new Button("Add to Cart");
//	Button buy6 = new Button("Add to Cart");
	TextBox nameBox = new TextBox();
	Grid panel = new Grid(4, 3);
	
	//LinkedList<Product> list = new LinkedList<Product>();
	List<Product> list;
	private int price;
	
	Label creditresp = new Label(String.valueOf(price));
	
	private DecoratedStackPanel pc = new DecoratedStackPanel();
	
	
	@SuppressWarnings("deprecation")
	public Productvw(){
		
		final CellTable<Product> table = new CellTable<Product>(); 
		
		 final ListDataProvider<Product> model = new ListDataProvider<Product>(getUserList());
		
		 Button buy = new Button("Add to Cart", new ClickHandler() {
	 
			@Override
			public void onClick(ClickEvent event) {
				Product p = new Product("4374", "Serbia custome",26,3);
				list = model.getList();
				if (price >= 26 && st1 > 0){
				list.add(p);
				price = price-26;
				creditresp.setText(String.valueOf(price));
				st1 = st1-1;
				//Window.alert("stock"+st1);
				p.setStock(st1);
				}
				else{
					Window.alert("Se agoto su cupo de credito o el stock del producto");
				}
			}
		});
		Button buy2 = new Button("Add to Cart", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Product p = new Product("4374", "Serbia custome",37,4);
				list = model.getList();
				if (price >= 37 && st2 > 0){
					list.add(p);
					price = price-37;
					creditresp.setText(String.valueOf(price));
					st2 = st2-1;
					//Window.alert("stock"+st1);
					p.setStock(st2);
					}
					else{
						Window.alert("Se agoto su cupo de credito o el stock del producto");
					}
				
			}
		});
		Button buy3 = new Button("Add to Cart", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Product p = new Product("12345", "ukraine custome",33,6);
				list = model.getList();
				if (price >= 37 && st3 > 0){
					list.add(p);
					price = price-37;
					creditresp.setText(String.valueOf(price));
					st3 = st3-1;
					//Window.alert("stock"+st1);
					p.setStock(st3);
					}
					else{
						Window.alert("Se agoto su cupo de credito o el stock del producto");
					}
				
			}
		});
		Button buy4 = new Button("Add to Cart", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Product p = new Product("8645", "Poland custome",40,6);
				list = model.getList();
				if (price >= 40 && st4 > 0){
					list.add(p);
					price = price-40;
					creditresp.setText(String.valueOf(price));
					st4 = st4-1;
					//Window.alert("stock"+st1);
					p.setStock(st4);
					}
					else{
						Window.alert("Se agoto su cupo de credito o el stock del producto");
					}
				
			}
		});
		Button buy5 = new Button("Add to Cart", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Product p = new Product("6548", "Moldavian custome",28,2);
				list = model.getList();
				if (price >= 28 && st5 > 0){
					list.add(p);
					price = price-28;
					creditresp.setText(String.valueOf(price));
					st5 = st5-1;
					//Window.alert("stock"+st1);
					p.setStock(st5);
					}
					else{
						Window.alert("Se agoto su cupo de credito o el stock del producto");
					}
			}
		});
		Button buy6 = new Button("Add to Cart", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Product p = new Product("4374", "Macedonian custome",30,3);
				list = model.getList();
				if (price >= 30 && st6 > 0){
					list.add(p);
					price = price-30;
					creditresp.setText(String.valueOf(price));
					st6 = st6-1;
					//Window.alert("stock"+st1);
					p.setStock(st6);
					}
					else{
						Window.alert("Se agoto su cupo de credito o el stock del producto");
					}
				
			}
		});
		
		panel.setWidget(0, 0, new PushButton(new Image("/images/image1.jpg"), new ClickListener() {
			@Override
			public void onClick(Widget sender) {
				DialogBox dlg = new MyDialog();
		         dlg.center();
				
			}
		}));
		panel.setWidget(1, 0, buy);
		panel.setWidget(0, 1, new PushButton(new Image("/images/image2.jpg"), new ClickListener() {
			@Override
			public void onClick(Widget sender) {
				DialogBox dlg = new MyDialog2();
		         dlg.center();
				
			}
		}));
		panel.setWidget(1, 1, buy2);
		panel.setWidget(0, 2, new PushButton(new Image("/images/image3.jpg"), new ClickListener() {
			@Override
			public void onClick(Widget sender) {
				DialogBox dlg = new MyDialog3();
		         dlg.center();
				
			}
		}));
		panel.setWidget(1, 2, buy3);
		panel.setWidget(2, 0, new PushButton(new Image("/images/image4.jpg"), new ClickListener() {
			@Override
			public void onClick(Widget sender) {
				DialogBox dlg = new MyDialog4();
		         dlg.center();
				
			}
		}));
		panel.setWidget(3, 0, buy4);
		panel.setWidget(2, 1, new PushButton(new Image("/images/image5.jpg"), new ClickListener() {
			@Override
			public void onClick(Widget sender) {
				DialogBox dlg = new MyDialog5();
		         dlg.center();
				
			}
		}));
		panel.setWidget(3, 1, buy5);
		panel.setWidget(2, 2, new PushButton(new Image("/images/image6.jpg"), new ClickListener() {
			@Override
			public void onClick(Widget sender) {
				DialogBox dlg = new MyDialog6();
		         dlg.center();
				
			}
		}));
		panel.setWidget(3, 2, buy6);
		
//		int numRows = grid.getRowCount();
//	      int numColumns = grid.getColumnCount();
//	      for (int row = 0; row < numRows; row++) {
//	         for (int col = 0; col < numColumns; col++) {
//	            grid.setWidget(row, col, buy);
//	         }
//	      }
		VerticalPanel tl = new VerticalPanel();
		tl.add(title);
		Label name = new Label("Nombre:");
		final Label nameresp = new Label("");
	
		Label mail = new Label("Email:");
		final Label mailresp = new Label("");
		Label credit = new Label("Credito:");
		User noUser = new User("0", "p", "q");
		service.getUser(noUser, new AsyncCallback<User>() {
			
			@Override
			public void onSuccess(User result) {
				//Window.alert("Bien Usuario");
				nameresp.setText(result.getName());
				mailresp.setText(result.getEmail());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Mal Usuario");
				
			}
		});
		
		Grid info = new Grid(3, 2);
		info.setWidget(0, 0, name);
		info.setWidget(0, 1, nameresp);
		info.setWidget(1, 0, mail);
		info.setWidget(1, 1, mailresp);
		info.setWidget(2, 0, credit);
		info.setWidget(2, 1, creditresp);
		
//		final CellTable<Product> table = new CellTable<Product>(); 
//		
//		 final ListDataProvider<Product> model = new ListDataProvider<Product>(
//				getUserList());
		 

		Column<Product, String> nameColumn = new Column<Product, String>(
				new TextCell()) {
			@Override
			public String getValue(Product aUser) {
				return aUser.getName();
			}
		};

		nameColumn.setSortable(true);
		table.addColumn(nameColumn, "Product Name");

		Column<Product, String> idColumn = new Column<Product, String>(
				new TextCell()) {
			@Override
			public String getValue(Product aUser) {
				String price= String.valueOf(aUser.getPrice());
				return price;
			}
		};

		table.addColumn(idColumn, "Price");
		
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

					public void update(int index, Product object, String value) {
						model.getList().remove(object);
						restPrice(object);
						model.refresh();
						table.redraw();

					}
				});

				table.setRowCount(getUserList().size());
				model.addDataDisplay(table);

				
				pc.add(table);
		
		//CarritoView cv = new CarritoView();
		
		VerticalPanel dp = new VerticalPanel();
		dp.add(info);
		dp.add(pc);
		
		DockPanel principal = new DockPanel();
		principal.setSpacing(6);
		principal.add(tl,DockPanel.NORTH);
		principal.add(dp, DockPanel.EAST);
		principal.add(panel, DockPanel.CENTER);
		
		RootLayoutPanel.get().add(principal);
	}
	
	void restPrice(Product pr){
		int pPrice = pr.getPrice().intValue();
		price = price + pPrice;
		creditresp.setText(String.valueOf(price));
	}
	
	private LinkedList<Product> getUserList() {
		LinkedList<Product> listtable = new LinkedList<Product>();
		
		//listtable.add(new Product("2", "ukraine custome",25,3));
		//listtable.add(new Product("3", "macedonia custome",30,2));
		return listtable;
	}
	
	private class BuyHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			Product p =new Product("2213", "serbia custome", 50,1);
			//list.add(p);
			//Window.alert("Entra producto");
			service.addProduct(p, new AsyncCallback<Product>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Fallo agregar producto");
					
				}

				@Override
				public void onSuccess(Product result) {
					if (result instanceof Product){
						Product product = (Product)result;
						Window.alert("Bien Producto"+product.getName());
					}
					
				}
			});
			
			
		}
		
	}
	
	public class DefaultCallback implements AsyncCallback{

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Fallo agregar producto");
			
		}

		@Override
		public void onSuccess(Object result) {
			if (result instanceof Product){
				Product product = (Product)result;
				Window.alert("Bien Producto"+product.getName());
			}
			
		}
		
	}
	
	private class BuyHandler2 implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			//list.add(new Product("4374", "ukraine custome",25,3));
			//send server
		}
		
	}
	
	private class BuyHandler3 implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			//list.add(new Product("3", "macedonia custome",30,2));;
			//send server
		}
		
	}
	
	private class BuyHandler4 implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			//list.add(new Product("1", "serbia custome", 50,1));
			//send server
		}
		
	}
	
	private class BuyHandler5 implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			//list.add(new Product("1", "serbia custome", 50,1));
			//send server
		}
		
	}
	
	private class BuyHandler6 implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			//list.add(new Product("1", "serbia custome", 50,1));
			//send server
		}
		
	}
	
	@SuppressWarnings("deprecation")
	private class MyDialog extends DialogBox implements ClickHandler {
		  public MyDialog() {
		    setText("Product Detail");

		    Button closeButton = new Button("Close", this);
		    HTML msg = new HTML("<center>Serbian women Traditional costume.</center>",true);
		   // Label nam = new Label("Serbian costume 1");
		    Label price = new Label("Price: 26$");
		    Label stock = new Label("Stock: 4");

		    DockPanel dock = new DockPanel();
		    dock.setSpacing(4);

		    dock.add(closeButton, DockPanel.SOUTH);
		    dock.add(msg, DockPanel.NORTH);
		    //dock.add(nam, DockPanel.EAST);
		    dock.add(price, DockPanel.EAST);
		    dock.add(stock, DockPanel.EAST);
		    dock.add(new Image("/images/image1.jpg"), DockPanel.CENTER);

		    dock.setCellHorizontalAlignment(closeButton, DockPanel.ALIGN_RIGHT);
		    dock.setWidth("100%");
		    setWidget(dock);
		  }

		@Override
		public void onClick(ClickEvent event) {
			hide();
			
		}
		}
	
	@SuppressWarnings("deprecation")
	private class MyDialog2 extends DialogBox implements ClickHandler {
		  public MyDialog2() {
		    setText("Product Detail");

		    Button closeButton = new Button("Close", this);
		    HTML msg = new HTML("<center>Serbian women Traditional costume</center>",true);
		    Label nam = new Label("Serbian costume 2");
		    Label price = new Label("Price: 37$");
		    Label stock = new Label("Stock: 6");
		    DockPanel dock = new DockPanel();
		    dock.setSpacing(4);

		    dock.add(closeButton, DockPanel.SOUTH);
		    dock.add(msg, DockPanel.NORTH);
		    dock.add(price, DockPanel.EAST);
		    dock.add(stock, DockPanel.EAST);
		    dock.add(new Image("/images/image2.jpg"), DockPanel.CENTER);

		    dock.setCellHorizontalAlignment(closeButton, DockPanel.ALIGN_RIGHT);
		    dock.setWidth("100%");
		    setWidget(dock);
		  }

		@Override
		public void onClick(ClickEvent event) {
			hide();
			
		}
		}
	
	@SuppressWarnings("deprecation")
	private class MyDialog3 extends DialogBox implements ClickHandler {
		  public MyDialog3() {
		    setText("Product Detail");

		    Button closeButton = new Button("Close", this);
		    HTML msg = new HTML("<center>Ukraine women Traditional costume</center>",true);
		    Label nam = new Label("Ukraine costume");
		    Label price = new Label("Price: 33$");
		    Label stock = new Label("Stock: 6");
		    DockPanel dock = new DockPanel();
		    dock.setSpacing(4);

		    dock.add(closeButton, DockPanel.SOUTH);
		    dock.add(msg, DockPanel.NORTH);
		    dock.add(price, DockPanel.EAST);
		    dock.add(stock, DockPanel.EAST);
		    dock.add(new Image("/images/image3.jpg"), DockPanel.CENTER);

		    dock.setCellHorizontalAlignment(closeButton, DockPanel.ALIGN_RIGHT);
		    dock.setWidth("100%");
		    setWidget(dock);
		  }

		@Override
		public void onClick(ClickEvent event) {
			hide();
			
		}
		}
	
	@SuppressWarnings("deprecation")
	private class MyDialog4 extends DialogBox implements ClickHandler {
		  public MyDialog4() {
		    setText("Product Detail");

		    Button closeButton = new Button("Close", this);
		    HTML msg = new HTML("<center>Poland women Traditional costume</center>",true);
		    Label nam = new Label("Poland costume");
		    Label price = new Label("Price: 40$");
		    Label stock = new Label("Stock: 3");
		    DockPanel dock = new DockPanel();
		    dock.setSpacing(4);

		    dock.add(closeButton, DockPanel.SOUTH);
		    dock.add(msg, DockPanel.NORTH);
		    dock.add(price, DockPanel.EAST);
		    dock.add(stock, DockPanel.EAST);
		    dock.add(new Image("/images/image4.jpg"), DockPanel.CENTER);

		    dock.setCellHorizontalAlignment(closeButton, DockPanel.ALIGN_RIGHT);
		    dock.setWidth("100%");
		    setWidget(dock);
		  }

		@Override
		public void onClick(ClickEvent event) {
			hide();
			
		}
		}
	
	@SuppressWarnings("deprecation")
	private class MyDialog5 extends DialogBox implements ClickHandler {
		  public MyDialog5() {
		    setText("Product Detail");

		    Button closeButton = new Button("Close", this);
		    HTML msg = new HTML("<center>Moldavian women Traditional costume</center>",true);
		    Label nam = new Label("Moldavian costume");
		    Label price = new Label("Price: 28$");
		    Label stock = new Label("Stock: 2");

		    DockPanel dock = new DockPanel();
		    dock.setSpacing(4);

		    dock.add(closeButton, DockPanel.SOUTH);
		    dock.add(msg, DockPanel.NORTH);
		    dock.add(price, DockPanel.EAST);
		    dock.add(stock, DockPanel.EAST);
		    dock.add(new Image("/images/image5.jpg"), DockPanel.CENTER);

		    dock.setCellHorizontalAlignment(closeButton, DockPanel.ALIGN_RIGHT);
		    dock.setWidth("100%");
		    setWidget(dock);
		  }

		@Override
		public void onClick(ClickEvent event) {
			hide();
			
		}
		}
	
	@SuppressWarnings("deprecation")
	private class MyDialog6 extends DialogBox implements ClickHandler {
		  public MyDialog6() {
		    setText("Product Detail");

		    Button closeButton = new Button("Close", this);
		    HTML msg = new HTML("<center>Macedonian women Traditional costume</center>",true);
		    Label nam = new Label("Macedonian costume");
		    Label price = new Label("Price: 30$");
		    Label stock = new Label("Stock: 3");
		    DockPanel dock = new DockPanel();
		    dock.setSpacing(4);

		    dock.add(closeButton, DockPanel.SOUTH);
		    dock.add(msg, DockPanel.NORTH);
		    dock.add(price, DockPanel.EAST);
		    dock.add(stock, DockPanel.EAST);
		    dock.add(new Image("/images/image6.jpg"), DockPanel.CENTER);

		    dock.setCellHorizontalAlignment(closeButton, DockPanel.ALIGN_RIGHT);
		    dock.setWidth("100%");
		    setWidget(dock);
		  }

		@Override
		public void onClick(ClickEvent event) {
			hide();
			
		}
		}

	

}
