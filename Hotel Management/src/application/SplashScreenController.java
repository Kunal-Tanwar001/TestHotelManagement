 package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javafx.util.Duration;

public class SplashScreenController implements Initializable {
	
	
	@FXML private ImageView img ;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
        FadeTransition fade = new FadeTransition(Duration.millis(1000),img);  
       
        fade.setFromValue(1.0); 
        fade.setToValue(0); 
          
        
        
        fade.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				Stage loginScreen = new Stage(); 
				
				Parent root = null ;
				
				
					try {
						root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				
				
				Stage current = (Stage) img.getScene().getWindow(); 
				Scene scene = new Scene(root,720,600);  
				loginScreen.setScene(scene); 
				
				
				current.hide();  
				loginScreen.show(); 
				
			}
        	
        });
        
        fade.play();
		
	}

}
