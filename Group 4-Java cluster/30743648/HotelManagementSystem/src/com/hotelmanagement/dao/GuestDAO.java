package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelmanagement.exception.GuestNotFoundException;
import com.hotelmanagement.model.Guest;
import com.hotelmanagement.util.JDBCUtil;

public class GuestDAO {

    public void addGuest(Guest guest) throws SQLException {
        String query = "INSERT INTO Guest (name, email, phone_number, address) VALUES (?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, guest.getName());
            preparedStatement.setString(2, guest.getEmail());
            preparedStatement.setString(3, guest.getPhoneNumber());
            preparedStatement.setString(4, guest.getAddress());

            preparedStatement.executeUpdate();
            System.out.println("Guest added successfully.");
        }
    }

    public Guest getGuest(int guestId) throws SQLException, GuestNotFoundException {
        String query = "SELECT * FROM Guest WHERE guest_id = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, guestId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return new Guest(
                        rs.getInt("guest_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address")
                );
            } else {
                throw new GuestNotFoundException("Guest with ID " + guestId + " not found.");
            }
        }
    }

    public void updateGuest(Guest guest) throws SQLException {
        String query = "UPDATE Guest SET name = ?, email = ?, phone_number = ?, address = ? WHERE guest_id = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, guest.getName());
            preparedStatement.setString(2, guest.getEmail());
            preparedStatement.setString(3, guest.getPhoneNumber());
            preparedStatement.setString(4, guest.getAddress());
            preparedStatement.setInt(5, guest.getGuestId());

            preparedStatement.executeUpdate();
            System.out.println("Guest updated successfully.");
        }
    }

    public void deleteGuest(int guestId) throws SQLException {
        String query = "DELETE FROM Guest WHERE guest_id = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, guestId);
            preparedStatement.executeUpdate();
            System.out.println("Guest deleted successfully.");
        }
    }
}
