package com.hotelmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelmanagement.exception.RoomNotFoundException;
import com.hotelmanagement.model.Room;
import com.hotelmanagement.util.JDBCUtil;

public class RoomDAO {

    public void addRoom(Room room) throws SQLException {
        String query = "INSERT INTO Room (room_number, type, price_per_night, availability_status) VALUES (?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, room.getRoomNumber());
            preparedStatement.setString(2, room.getType());
            preparedStatement.setDouble(3, room.getPricePerNight());
            preparedStatement.setBoolean(4, room.isAvailabilityStatus());

            preparedStatement.executeUpdate();
            System.out.println("Room added successfully.");
        }
    }

    public Room getRoom(int roomNumber) throws SQLException, RoomNotFoundException {
        String query = "SELECT * FROM Room WHERE room_number = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, roomNumber);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return new Room(
                        rs.getInt("room_number"),
                        rs.getString("type"),
                        rs.getDouble("price_per_night"),
                        rs.getBoolean("availability_status")
                );
            } else {
                throw new RoomNotFoundException("Room with number " + roomNumber + " not found.");
            }
        }
    }

    public void updateRoom(Room room) throws SQLException {
        String query = "UPDATE Room SET type = ?, price_per_night = ?, availability_status = ? WHERE room_number = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, room.getType());
            preparedStatement.setDouble(2, room.getPricePerNight());
            preparedStatement.setBoolean(3, room.isAvailabilityStatus());
            preparedStatement.setInt(4, room.getRoomNumber());

            preparedStatement.executeUpdate();
            System.out.println("Room updated successfully.");
        }
    }

    public void deleteRoom(int roomNumber) throws SQLException {
        String query = "DELETE FROM Room WHERE room_number = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, roomNumber);
            preparedStatement.executeUpdate();
            System.out.println("Room deleted successfully.");
        }
    }
}
