package application;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.security.auth.callback.Callback;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mysql.jdbc.PreparedStatement;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RoomScreenController implements Initializable {


    @FXML
    private  JFXTreeTableView<Room> treeView;
    
    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField search_by_text;

    @FXML
    private JFXCheckBox bsy;

    @FXML
    private JFXCheckBox available;
    
    private String status=null;

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		loadAllRoom("SELECT * FROM room");
	 }
	

    @FXML
    void available_room(ActionEvent event) {

    	
    	String text = search_by_text.getText().toString().trim();
    	int res=0;
    	String sql = "UPDATE room SET roomStatus=? WHERE roomNumber=?";
    	
    	Connection connect = DBConnection.getConnect();
    	
    	try {
			PreparedStatement prep = (PreparedStatement) connect.prepareStatement(sql);
			prep.setString(1,"available");
			prep.setString(2,text);
		    res = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(res>0) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("DATA UPDATE");
    		alert.setHeaderText("INFORMATION DIALOG ");
    		alert.setContentText("RECORD UPDATED SUCESSFULLY");
    		alert.showAndWait();
    		loadAllRoom("SELECT * FROM room WHERE 1");
    	}
    	else {
    		
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("DATA UPDATE");
    		alert.setHeaderText("INFORMATION DIALOG ");
    		alert.setContentText("Error not updated");
    		alert.showAndWait();
    		
    	}
    	
    	
    }

    @FXML
    void back(ActionEvent event) {
    	
    	JFXDialogLayout dialogLayout = new JFXDialogLayout();
    	dialogLayout.setHeading(new Text("close"));
    	dialogLayout.setBody(new Text("Do you want to go back"));
    	
    	JFXButton ok = new JFXButton("Ok");
    	JFXButton cancel = new JFXButton("Cancel");
    	
    	JFXDialog dialog = new JFXDialog(stackPane, dialogLayout,JFXDialog.DialogTransition.CENTER);
    	
    	ok.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 
				 
				Stage homeScreen = new Stage();
				Parent root = null;

				try {
					root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

				Stage current = (Stage) search_by_text.getScene().getWindow(); 
				Scene scene = new Scene(root);  
				homeScreen.setScene(scene); 
				
				
				current.hide();  
				homeScreen.show(); 
			}
		});
    	
    	cancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dialog.close();				}
		});
    	dialogLayout.setActions(ok,cancel);
    	dialog.show();

    }

    @FXML
    void closed(ActionEvent event) {
    	

    	JFXDialogLayout dialogLayout = new JFXDialogLayout();
    	dialogLayout.setHeading(new Text("close"));
    	dialogLayout.setBody(new Text("Do you want to exist"));
    	
    	JFXButton ok = new JFXButton("Ok");
    	JFXButton cancel = new JFXButton("Cancel");
    	
    	JFXDialog dialog = new JFXDialog(stackPane, dialogLayout,JFXDialog.DialogTransition.CENTER);
    	
    	ok.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 System.exit(0);
			}
		});
    	
    	cancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dialog.close();				}
		});
    	dialogLayout.setActions(ok,cancel);
    	dialog.show();
    	

    }

    @FXML
    void searchAvailable(ActionEvent event) {
    	
    	bsy.setSelected(false);
    	status= "SELECT * FROM room WHERE roomStatus ='available'";
    	
    }

    @FXML
    void searchBusy(ActionEvent event) {

    	available.setSelected(false);
    	status= "SELECT * FROM room WHERE roomStatus ='busy'";
    	
    }

    @FXML
    void search_room(ActionEvent event) {
    	loadAllRoom("SELECT * FROM room WHERE roomNumber='"+search_by_text.getText().toString().trim()+"'");
    	
    	
    }

    @FXML
    void searchbyStatus(ActionEvent event) {
    	
    	loadAllRoom(status);
    }

		
	
	 public void loadAllRoom(String sql) {
		 System.out.println("mera 1st call");
		 JFXTreeTableColumn<Room,String> room_id = new JFXTreeTableColumn<Room, String>("Room Id");
		 room_id.setPrefWidth(100);
		 room_id.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Room, String> param) {
				// TODO Auto-generated method stub
				  return param.getValue().getValue().id;
			}
		});
		 
		 
		 
		 JFXTreeTableColumn<Room,String> room_type = new JFXTreeTableColumn<Room, String>("Room Type");
		 room_type.setPrefWidth(100);
		 room_type.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<Room, String> param) {
					// TODO Auto-generated method stub
					  return param.getValue().getValue().roomType;
				}
			});
			 
		 
		 
		 JFXTreeTableColumn<Room,String> room_number = new JFXTreeTableColumn<Room, String>("Room Number");
		 room_number.setPrefWidth(100);
		 room_number.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<Room, String> param) {
					// TODO Auto-generated method stub
					  return param.getValue().getValue().roomNumber;
				}
			});
			 
		 
		 
		 JFXTreeTableColumn<Room,String> num_of_people = new JFXTreeTableColumn<Room, String>("Number of People");
		 num_of_people.setPrefWidth(100);
		 num_of_people.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<Room, String> param) {
					// TODO Auto-generated method stub
					  return param.getValue().getValue().numberOfPeople;
				}
			});
			 
		 
		 JFXTreeTableColumn<Room,String> floor_number = new JFXTreeTableColumn<Room, String>("Floor Number");
		 floor_number.setPrefWidth(100);
		 floor_number.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<Room, String> param) {
					// TODO Auto-generated method stub
					  return param.getValue().getValue().floorNumber;
				}
			});
			 
		 
		 JFXTreeTableColumn<Room,String> room_phone = new JFXTreeTableColumn<Room, String>("Room Phone");
		 room_phone.setPrefWidth(100);
		 room_phone.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<Room, String> param) {
					// TODO Auto-generated method stub
					  return param.getValue().getValue().roomPhone;
				}
			});
			 
		 
		 
		 JFXTreeTableColumn<Room,String> room_price = new JFXTreeTableColumn<Room, String>("Room Price");
		 room_price.setPrefWidth(100);
		 room_price.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<Room, String> param) {
					// TODO Auto-generated method stub
					  return param.getValue().getValue().roomPrice;
				}
			});
			 
		 
		 JFXTreeTableColumn<Room,String> room_status = new JFXTreeTableColumn<Room, String>("Room Status");
		 room_status.setPrefWidth(100);
		 room_status.setCellValueFactory(new javafx.util.Callback<TreeTableColumn.CellDataFeatures<Room,String>, ObservableValue<String>>() {
				
				@Override
				public ObservableValue<String> call(CellDataFeatures<Room, String> param) {
					// TODO Auto-generated method stub
					  return param.getValue().getValue().roomStatus;
				}
			});
			 
		 
		 
		 ObservableList<Room> rooms = FXCollections.observableArrayList();
		 Connection connection = DBConnection.getConnect();
		 System.out.println("yeh db bhi connect hua");
		 
		 try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				rooms.add(new Room(rs.getInt(1)+"", rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}

			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 final TreeItem<Room> root = new RecursiveTreeItem<Room>(rooms,RecursiveTreeObject::getChildren);
		 treeView.getColumns().setAll(room_id,room_type,room_number,num_of_people,floor_number,room_phone,room_price,room_status);
		 treeView.setRoot(root);
		 treeView.setShowRoot(false);
		 
		 
	 }
	
	

}
