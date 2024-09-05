package com.cts.dao;

import com.cts.model.Booking;
import com.cts.util.ConnectDB;

import java.sql.*;

public class BookingDAO {
    ConnectDB connectDB = new ConnectDB();

    public void addBooking(Booking booking) throws SQLException {
        String addRoomSql = "INSERT INTO bookings (room_id, customer_id, check_in_date, check_out_date) VALUES (?, ?, ?, ?)";
        String updateRoomStatusSql = "UPDATE rooms SET status = 'booked' WHERE room_id = ?";

        try(Connection conn = connectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(addRoomSql);
            PreparedStatement roomStmt = conn.prepareStatement(updateRoomStatusSql)) {
            stmt.setInt(1, booking.getRoomId());
            stmt.setInt(2, booking.getCustomerId());
            stmt.setDate(3, booking.getCheckInDate());
            stmt.setDate(4, booking.getCheckOutDate());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("\nBooking done successfully!");

                roomStmt.setInt(1, booking.getRoomId());
                int affectedRoomRows = roomStmt.executeUpdate();

                if (affectedRoomRows > 0) {
                    System.out.println("\nRoom status updated successfully!");
                } else {
                    System.out.println("\nRoom status update failed!");
                }
            } else {
                System.out.println("\nBooking failed!");
            }
        }
    } // End of addBooking method

    public void viewAllBookings() throws SQLException {
        String viewBookingSql = "SELECT b.booking_id, b.room_id, r.room_number, r.type, r.price, b.customer_id, c.name, c.email, c.phone_number, b.check_in_date, b.check_out_date FROM bookings b JOIN rooms r ON b.room_id = r.room_id JOIN customers c ON b.customer_id = c.customer_id";

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(viewBookingSql)) {

            System.out.println("\nBooking Details:");
            System.out.println("+------------+---------+------------ +------------+------------+-------------+----------------------------+-----------------------------+--------------+---------------+----------------+");
            System.out.println("| Booking ID | Room ID | Room Number | Type       | Price(Rs.) | Customer ID | Name                       | Email                       | Phone Number | Check In Date | Check Out Date |");
            System.out.println("+------------+---------+------------ +------------+------------+-------------+----------------------------+-----------------------------+--------------+---------------+----------------+");

            while (rset.next()) {
                int bookingId = rset.getInt("booking_id");
                int roomId = rset.getInt("room_id");
                String roomNumber = rset.getString("room_number");
                String type = rset.getString("type");
                Double price = rset.getDouble("price");
                int customerId = rset.getInt("customer_id");
                String name = rset.getString("name");
                String email = rset.getString("email");
                String phoneNumber = rset.getString("phone_number");
                Date checkInDate = rset.getDate("check_in_date");
                Date checkOutDate = rset.getDate("check_out_date");
                System.out.printf("| %-10d | %-7d | %-11s | %-10s | %-10.2f | %-11d | %-26s | %-27s | %-12s | %-13s | %-14s |\n",
                        bookingId, roomId, roomNumber, type, price, customerId, name, email, phoneNumber, checkInDate, checkOutDate);
            }

            System.out.println("+------------+---------+------------ +------------+------------+-------------+----------------------------+-----------------------------+--------------+---------------+----------------+");
        }
    } // End of viewAllBookings method

    public void viewBookingDetails(int customerID) throws SQLException {
        String viewBookingSql = "SELECT b.booking_id, b.room_id, r.room_number, r.type, r.price, b.customer_id, c.name, c.email, c.phone_number, b.check_in_date, b.check_out_date FROM bookings b JOIN rooms r ON b.room_id = r.room_id JOIN customers c ON b.customer_id = c.customer_id WHERE b.customer_id = " + customerID;

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(viewBookingSql)) {

            System.out.println("\nBooking Details:");
            System.out.println("+------------+---------+------------ +------------+------------+-------------+----------------------------+-----------------------------+--------------+---------------+----------------+");
            System.out.println("| Booking ID | Room ID | Room Number | Type       | Price(Rs.) | Customer ID | Name                       | Email                       | Phone Number | Check In Date | Check Out Date |");
            System.out.println("+------------+---------+------------ +------------+------------+-------------+----------------------------+-----------------------------+--------------+---------------+----------------+");

            while (rset.next()) {
                int bookingId = rset.getInt("booking_id");
                int roomId = rset.getInt("room_id");
                String roomNumber = rset.getString("room_number");
                String type = rset.getString("type");
                Double price = rset.getDouble("price");
                int customerId = rset.getInt("customer_id");
                String name = rset.getString("name");
                String email = rset.getString("email");
                String phoneNumber = rset.getString("phone_number");
                Date checkInDate = rset.getDate("check_in_date");
                Date checkOutDate = rset.getDate("check_out_date");
                System.out.printf("| %-10d | %-7d | %-11s | %-10s | %-10.2f | %-11d | %-26s | %-27s | %-12s | %-13s | %-14s |\n",
                        bookingId, roomId, roomNumber, type, price, customerId, name, email, phoneNumber, checkInDate, checkOutDate);
            }

            System.out.println("+------------+---------+------------ +------------+------------+-------------+----------------------------+-----------------------------+--------------+---------------+----------------+");
        }
    } // End of viewBookingDetails method

    public void deleteBooking(int bookingId) throws SQLException {
        String getRoomIdSql = "SELECT room_id FROM bookings WHERE booking_id = " + bookingId;
        String deleteBookingSql = "DELETE FROM bookings WHERE booking_id = " + bookingId;
        String updateRoomStatusSql = "UPDATE rooms SET status = 'available' WHERE room_id = ?";

        try (Connection conn = connectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(getRoomIdSql);
             PreparedStatement roomStatusStmt = conn.prepareStatement(updateRoomStatusSql)) {

            if (rset.next()) {
                int roomId = rset.getInt("room_id");

                int affectedRows = stmt.executeUpdate(deleteBookingSql);

                if (affectedRows > 0) {
                    System.out.println("\nBooking cancelled successfully!");

                    roomStatusStmt.setInt(1, roomId);
                    int affectedRoomRows = roomStatusStmt.executeUpdate();

                    if (affectedRoomRows > 0) {
                        System.out.println("\nRoom status updated successfully!");
                    } else {
                        System.out.println("\nRoom status update failed!");
                    }
                } else {
                    System.out.println("\nBooking cancel failed!");
                }
            }
        }
    } // End of deleteBooking method
}
