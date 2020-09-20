package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;

public class ReservationController implements Initializable {

static int id = (int) (Math.random()*(100-10+1) +10);
    @FXML
    private JFXTextField customer;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField email;

    @FXML
    private  JFXTextField duration;

    @FXML
    private JFXTextField noOfPeople;

    @FXML
    private JFXTextField payment;

    @FXML
    private JFXTextField roomType;

    @FXML
    private JFXTextField roomNum;

    @FXML
    private  JFXTextField startDate;

    @FXML
    private JFXTextField endDate;


    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField services;

    @FXML
    private JFXTextField total;
    
   String customerText= null;

   String phoneText=null;

    String addressText=null;

    String emailText=null;

    String durationText=null;

    String noOfPeopleText =null;

    String paymentText=null;

    String roomTypeText=null;
   String roomNumText=null;

    String priceText=null;

    String servicesText=null;

    String totalText=null;

    String startDateText=null;

    String endDateText=null;

    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void book(ActionEvent event) {
    	
    	customerText= customer.getText().toString().trim();
    	phoneText= phone.getText().toString().trim();
    	addressText= address.getText().toString().trim();
    	emailText=email.getText().toString().trim();
    	durationText=duration.getText().toString().trim();
    	noOfPeopleText=noOfPeople.getAccessibleText().toString().trim();
    	paymentText=payment.getText().toString().trim();
    	roomTypeText=roomType.getText().toString().trim();
    	roomNumText=roomNum.getText().toString().trim();
    	priceText=price.getText().toString().trim();
    	servicesText=services.getText().toString().trim();
    	totalText=total.getText().toString().trim();
    	startDateText=startDate.getText().toString().trim();
    	endDateText=endDate.getText().toString().trim();
    	
    	int res=0;
    String sql="INSERT INTO customers (id, name, email, address, phone, numOfPeople, paymentType, duration, roomType, roomNumber, startDate, endDate, price, services, total) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	

	Connection connect = DBConnection.getConnect();
	
	try {
		PreparedStatement prep = (PreparedStatement) connect.prepareStatement(sql);
		prep.setInt(1,id);
		prep.setString(2,customerText);
		prep.setString(3,phoneText);
		prep.setString(4,addressText);
		prep.setString(5,emailText);
		prep.setString(6,durationText);
		prep.setString(7,noOfPeopleText);
		prep.setString(8,paymentText);
		prep.setString(9,roomTypeText);
		prep.setString(10,roomNumText);
		prep.setString(11,startDateText);
		prep.setString(12,endDateText);
		prep.setString(13,priceText);
		prep.setString(14,servicesText);
		prep.setString(15,totalText);
		
	    res = prep.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(res>0) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("DATA Adding");
		alert.setHeaderText("INFORMATION DIALOG ");
		alert.setContentText("RECORD AdedaSSFULLY");
		alert.showAndWait();
		
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
    void print(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
