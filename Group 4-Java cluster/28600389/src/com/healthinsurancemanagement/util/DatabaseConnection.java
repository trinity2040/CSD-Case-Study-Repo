package com.healthinsurancemanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
    private static final String URL = "jdbc:mysql://localhost:3306/HealthInsuranceDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Oishik@18"; 
   

    public static Connection getConnection() throws SQLException 
    {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
    		//System.out.print("Connection Established");
    		return con;
    	}
    	catch(Exception e)
    	{
    		System.out.println("Database Error");
    	}
        return null;
    }
}
