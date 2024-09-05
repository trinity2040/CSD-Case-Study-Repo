package com.cts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_booking_system";
    private static final String USER = "root";
    private static final String PASSWORD = "Dipanjan@29";

    public ConnectDB() {
        try {
            Class.forName(DRIVER_PATH);
        } catch (Exception e) {
            throw new RuntimeException("Some went wrong. " + e.getMessage());
        }
    } // End of constructor

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    } // End of getConnection method
}