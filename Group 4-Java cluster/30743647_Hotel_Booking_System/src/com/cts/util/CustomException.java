package com.cts.util;

import java.sql.*;

public class CustomException {
    ConnectDB connectDB = new ConnectDB();

    public boolean roomExists(int roomId) throws SQLException {
        String findRoomSql = "SELECT * FROM rooms WHERE room_id = " + roomId;

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(findRoomSql)){

            return rset.next();
        }
    } // End of roomExists exception

    public boolean customerExists(int customerId) throws SQLException {
        String findRoomSql = "SELECT * FROM customers WHERE customer_id = " + customerId;

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(findRoomSql)){

            return rset.next();
        }
    } // End of customerExists exception

    public boolean bookingExists(int bookingId) throws SQLException {
        String findRoomSql = "SELECT * FROM bookings WHERE booking_id = " + bookingId;

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(findRoomSql)){

            return rset.next();
        }
    } // End of bookingExists exception

    public boolean roomAvailable(int roomId) throws SQLException {
        String roomStatusSql = "SELECT status FROM rooms WHERE room_id = " + roomId;

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(roomStatusSql)) {

            if (rset.next()) {
                return "available".equals(rset.getString("status"));
            }
        }
        return false;
    } // End of roomAvailable exception

    public boolean roomInUse(int roomId) throws SQLException {
        String findRoomSql = "SELECT * FROM bookings WHERE room_id = " + roomId;

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(findRoomSql)){

            return rset.next();
        }
    } // End of roomInUse exception

    public boolean customerInUse(int customerId) throws SQLException {
        String findRoomSql = "SELECT * FROM bookings WHERE customer_id = " + customerId;

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(findRoomSql)){

            return rset.next();
        }
    } // End of customerInUse exception
}
