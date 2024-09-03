package com.gymmanagement.dao;

import java.sql.*;

/**
 * The DatabaseConnection class provides a method to establish a connection
 * to the MySQL database used by the gym management system.
 * 
 * It encapsulates the database URL, username, and password, and returns 
 * a Connection object that can be used to interact with the database.
 */
public class DatabaseConnection {
	private static String url="jdbc:mysql://localhost:3306/gym_management";
	private static String user="root";
	private static String upwd="Ayan@3008";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,upwd);
			return con;
		}
		catch(Exception e) {
			System.err.println("Error occured while connecting to te database....");
			e.printStackTrace();
		}
		return null;
	}
}
