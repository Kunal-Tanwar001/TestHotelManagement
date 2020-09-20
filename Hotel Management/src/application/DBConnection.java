package application;

import java.sql.DriverManager;


public class DBConnection {

	
	private static java.sql.Connection conn;
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getConnect();

	}

	
	public static java.sql.Connection getConnect()  {
		
		String url	    = "jdbc:mysql://localhost:3306/fake_hotel_db";
		String username = "root";
		String password = "";
		
	
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, password);
			    System.out.println("It is connected now");
			    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		
		
		return conn;
		
	}
}
