package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeScreenController implements Initializable{
	

    @FXML
    private StackPane stackPane;
    
	@FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

    @FXML
    private Pane pane5;

    @FXML
    void mouse_exit1(MouseEvent event) {
    	pane1.setStyle("-fx-background-color : white ; -fx-background-radius : 6px;");

    }

    @FXML
    void mouse_exit2(MouseEvent event) {
    	pane2.setStyle("-fx-background-color : white ; -fx-background-radius : 6px;");
    }

    @FXML
    void mouse_exit3(MouseEvent event) {
    	pane3.setStyle("-fx-background-color : white ; -fx-background-radius : 6px;");
    }

    @FXML
    void mouse_exit4(MouseEvent event) {
    	pane4.setStyle("-fx-background-color : white ; -fx-background-radius : 6px;");
    }

    @FXML
    void mouse_exit5(MouseEvent event) {
    	pane5.setStyle("-fx-background-color : white ; -fx-background-radius : 6px;");
    }

    @FXML
    void mouse_hover1(MouseEvent event) {
    	pane1.setStyle("-fx-background-color : #377ce8; -fx-background-radius : 6px;");
    }

    @FXML
    void mouse_hover2(MouseEvent event) {
    	pane2.setStyle("-fx-background-color : #377ce8; -fx-background-radius : 6px;");
    }

    @FXML
    void mouse_hover3(MouseEvent event) {
    	pane3.setStyle("-fx-background-color : #377ce8; -fx-background-radius : 6px;");
    }

    @FXML
    void mouse_hover4(MouseEvent event) {
    	pane4.setStyle("-fx-background-color : #377ce8; -fx-background-radius : 6px;");
    }

    @FXML
    void mouse_hover5(MouseEvent event) {
    	pane5.setStyle("-fx-background-color :#377ce8 ; -fx-background-radius : 6px;");
    }
    
    @FXML
    void availableroomScreen(MouseEvent event) {


    	Stage roomScreen = new Stage();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("roomScreen.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		Stage current = (Stage) pane2.getScene().getWindow(); 
		Scene scene = new Scene(root);  
	roomScreen.setScene(scene); 
		
		
		current.hide();  
		roomScreen.show(); 
    }

    @FXML
    void customersinfoScreen(MouseEvent event) {


    	Stage customerScreen = new Stage();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("customerScreen.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		Stage current = (Stage) pane3.getScene().getWindow(); 
		Scene scene = new Scene(root);  
		customerScreen.setScene(scene); 
		
		
		current.hide();  
		customerScreen.show();
    }

    @FXML
    void exit(MouseEvent event) {
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
    void logout(MouseEvent event) {


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
				 
				Stage homeScreen = new Stage();
				Parent root = null;

				try {
					root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

				Stage current = (Stage) pane4.getScene().getWindow(); 
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
    void reservationScreen(MouseEvent event) {
    	
    	Stage reservationScreen = new Stage();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("reservationScreen.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		Stage current = (Stage) pane1.getScene().getWindow(); 
		Scene scene = new Scene(root);  
		reservationScreen.setScene(scene); 
		
		
		current.hide();  
		reservationScreen.show();
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
