package application;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer extends RecursiveTreeObject<Customer>{
	StringProperty id;
	StringProperty customer;

	StringProperty phone;

	StringProperty addressText;

	StringProperty email;

	StringProperty duration;

	StringProperty noOfPeople;

	StringProperty payment;

	StringProperty roomType;
	StringProperty roomNum;

	StringProperty price;

	StringProperty services;

	StringProperty total;

	StringProperty startDate;

	StringProperty endDate;

	

	
	public Customer(String id,String customer, String phone, String addressText, String email,
			String duration, String noOfPeople, String payment, String roomType,
			String roomNum, String price, String services, String total,
			String startDate, String endDate) {
		super();
		this.id = new SimpleStringProperty(id);
		this.customer =new SimpleStringProperty(customer);
		this.phone = new SimpleStringProperty(phone);
		this.addressText = new SimpleStringProperty(addressText);
		this.email = new SimpleStringProperty(email);
		this.duration = new SimpleStringProperty(duration);
		this.noOfPeople = new SimpleStringProperty(noOfPeople);
		this.payment = new SimpleStringProperty( payment);
		this.roomType =new SimpleStringProperty( roomType);
		this.roomNum = new SimpleStringProperty(roomNum);
		this.price = new SimpleStringProperty(price);
		this.services = new SimpleStringProperty(services);
		this.total = new SimpleStringProperty(total);
		this.startDate = new SimpleStringProperty(startDate);
		this.endDate =new SimpleStringProperty( endDate);
	}



	



	public Customer() {
		super();
	}
}


