package com.cts.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	    private static final String URL = "jdbc:mysql://localhost:3306/HomeInsuranceDB";
	    private static final String USER = "root";
	    private static final String PASSWORD = "mango123";  // MySQL password
	    
	    public static Connection getConnection() {
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				return con;
			}
			catch(Exception e) {
				System.err.println("Error occured while connecting to te database....");
				e.printStackTrace();
			}
			return null;
	        
	}
}

