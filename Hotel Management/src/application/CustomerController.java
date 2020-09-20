package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mysql.jdbc.PreparedStatement;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CustomerController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("customer is working");
		loadAllRoom("SELECT * FROM customers");
	}
	

    @FXML
    private JFXTreeTableView<Customer> treeView;

    @FXML
    private JFXTextField searchText;

    
    @SuppressWarnings("unchecked")
	public void loadAllRoom(String sql) 
    {
    	
    	
    	 System.out.println("mera 1st call");
		 JFXTreeTableColumn<Customer,String> id = new JFXTreeTableColumn<Customer, String>("Customer Id");
		 id.setPrefWidth(100);
		 id.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().id;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> name = new JFXTreeTableColumn<Customer, String>("Customer Name");
		 name.setPrefWidth(100);
		 name.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().customer;
			}
		});
		 JFXTreeTableColumn<Customer,String> phone = new JFXTreeTableColumn<Customer, String>("Phone");
		 phone.setPrefWidth(100);
		 phone.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().phone;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> adress = new JFXTreeTableColumn<Customer, String>("Address");
		 adress.setPrefWidth(100);
		 adress.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().addressText;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> email = new JFXTreeTableColumn<Customer, String>("Email");
		 email.setPrefWidth(100);
		 email.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().email;
			}
		});
    	
		 JFXTreeTableColumn<Customer,String> duration = new JFXTreeTableColumn<Customer, String>("Duration");
		 duration.setPrefWidth(100);
		 duration.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().duration;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> noOfPeople = new JFXTreeTableColumn<Customer, String>("NO.of People");
		 noOfPeople.setPrefWidth(100);
		 noOfPeople.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().noOfPeople
						  ;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> payment = new JFXTreeTableColumn<Customer, String>("Payment");
		 payment.setPrefWidth(100);
		 payment.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().payment;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> roomType = new JFXTreeTableColumn<Customer, String>("RoomType");
		 roomType.setPrefWidth(100);
		 roomType.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().roomType;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> roomNum = new JFXTreeTableColumn<Customer, String>("Room Number");
		 roomNum.setPrefWidth(100);
		 roomNum.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().roomNum;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> startDate = new JFXTreeTableColumn<Customer, String>("Start Date");
		 startDate.setPrefWidth(100);
		 startDate.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().startDate;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> endDate = new JFXTreeTableColumn<Customer, String>("End Date");
		 endDate.setPrefWidth(100);
		 endDate.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().endDate;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> price = new JFXTreeTableColumn<Customer, String>("Price");
		 price.setPrefWidth(100);
		 price.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().price;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> services = new JFXTreeTableColumn<Customer, String>("services");
		 services.setPrefWidth(100);
		 services.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().services;
			}
		});
		 
		 JFXTreeTableColumn<Customer,String> total = new JFXTreeTableColumn<Customer, String>("Total");
		 total.setPrefWidth(100);
		 total.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Customer,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Customer, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().total;
			}
		});
    	
		 

		 
		 ObservableList<Customer> customer = FXCollections.observableArrayList();
		 Connection connection = DBConnection.getConnect();
		 System.out.println("yeh db bhi connect hua");
		 
		 try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customer.add(new Customer(rs.getInt(1)+"", rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15)));
			}

			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 final TreeItem<Customer> root = new RecursiveTreeItem<Customer>(customer,RecursiveTreeObject::getChildren);
		 treeView.getColumns().setAll(id,name,phone,adress,email,duration,noOfPeople,payment,roomType,roomNum,startDate,endDate,price,services,total);
		 treeView.setRoot(root);
		 treeView.setShowRoot(false);
		 
    }
    

    @FXML
    void back(MouseEvent event) {
    	
    	 
		Stage homeScreen = new Stage();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		Stage current = (Stage) searchText.getScene().getWindow(); 
		Scene scene = new Scene(root);  
		homeScreen.setScene(scene); 
		
		
		current.hide();  
		homeScreen.show(); 
    }

    @FXML
    void serach(MouseEvent event) {
    	
    	loadAllRoom("SELECT * FROM customers WHERE roomNumber='"+searchText.getText().toString().trim()+"'");
    	
    }
    
    
}
