package com.hotelmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_management";
    private static final String USER = "root";
    private static final String PASSWORD = "qwert";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
