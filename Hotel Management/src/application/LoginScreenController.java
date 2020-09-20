package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;
import com.sun.javafx.geom.Rectangle;
import com.sun.nio.sctp.Notification;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginScreenController  implements Initializable{
	
	@FXML
    private JFXTextField username;

    @FXML
    private JFXTextField password;
    
    @FXML
    private StackPane stackPane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	 

	    @FXML
	    void loginButton(MouseEvent event) {
	    	
	    	
	    	if(username.getText().toString().equals("")) {
	    		
	    		
	    		 		
	    	}

	    	else if(password.getText().toString().equals("")) {
	    		
	    		Image image = new Image("Image/cross.jpg");
	    		Notifications notific = Notifications.create()
	    				.title("Error")
	    				.text(" Password is empty")
	    				.hideAfter(Duration.seconds(2))
	    				.position(Pos.BOTTOM_LEFT)
	    				.graphic(new ImageView(image));
	    		notific.darkStyle();
	    		notific.show();
	    	}
	    	
	    	else {
	    		

		    	boolean isExist = false;
		    	String userPass = "";
		    	String userType = "";
		    	
		    	String sql ="select * from users where username ='"+ username.getText().toString().trim()+"'";
		    	Connection connection = DBConnection.getConnect();
		    	
		    	try {
					PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						isExist= true;
						userPass = rs.getString(3);
						userType = rs.getString(9);
					}
					
					if(isExist) {
						
						if(password.getText().toString().trim().equals(userPass)) {
							
							if(userType.equals("admin")) {
								//go to admin part
								
								Stage adminScreen = new Stage();
								Parent root = null;

								try {
									root = FXMLLoader.load(getClass().getResource("adminScreen.fxml"));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 

								Stage current = (Stage) username.getScene().getWindow(); 
								Scene scene = new Scene(root);  
								adminScreen.setScene(scene); 
								
								
								current.hide();  
								adminScreen.show(); 
								
							
							}
							else {
								// got to the homescreen.
								Stage homeScreen = new Stage();
								Parent root = null;

								try {
									root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 

								Stage current = (Stage) username.getScene().getWindow(); 
								Scene scene = new Scene(root);  
								homeScreen.setScene(scene); 
								
								
								current.hide();  
								homeScreen.show(); 
							}
						}
					}
					else {
						
						Image image = new Image("Image/cross.jpg");
			    		 Notifications.create()
			    				.title("Error")
			    				.text("Username & Password is wrong. Check again")
			    				.hideAfter(Duration.seconds(2))
			    				.position(Pos.BOTTOM_LEFT)
			    				.graphic(new ImageView(image))
			    		        .darkStyle()
			    		        .show();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
	    	
	    }

	    @FXML
	    void cancelButton(MouseEvent event) {

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
}

