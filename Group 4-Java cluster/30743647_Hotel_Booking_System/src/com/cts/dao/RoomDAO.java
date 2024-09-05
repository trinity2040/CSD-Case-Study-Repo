package com.cts.dao;

import com.cts.model.Room;
import com.cts.util.ConnectDB;

import java.sql.*;

public class RoomDAO {
    ConnectDB connectDB = new ConnectDB();

    public void addRoom(Room room) throws SQLException {
        String addRoomSql = "INSERT INTO rooms (room_number, type, price, status) VALUES (?, ?, ?, ?)";

        try(Connection conn = connectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(addRoomSql)) {
            stmt.setString(1, room.getRoomNumber());
            stmt.setString(2, room.getType());
            stmt.setDouble(3, room.getPrice());
            stmt.setString(4, room.getStatus());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("\nRoom added successfully!");
            } else {
                System.out.println("\nAdd room failed!");
            }
        }
    } // End of addRoom method

    public void viewAllRooms() throws SQLException {
        String viewAllRoomsSql = "SELECT room_id, room_number, type, price, status FROM rooms";

        try(Connection conn = connectDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(viewAllRoomsSql)) {
            System.out.println("\nAll Room Details:");
            System.out.println("+---------+-------------+------------+------------+-----------+");
            System.out.println("| Room ID | Room Number | Type       | Price(Rs.) | Status    |");
            System.out.println("+---------+-------------+------------+------------+-----------+");

            while (rset.next()) {
                int roomId = rset.getInt("room_id");
                String roomNum = rset.getString("room_number");
                String type = rset.getString("type");
                Double price = rset.getDouble("price");
                String status = rset.getString("status");

                System.out.printf("| %-7d | %-11s | %-10s | %-10.2f | %-9s |\n", roomId, roomNum, type, price,
                        status);
            }

            System.out.println("+---------+-------------+------------+------------+-----------+");
        }
    } // End of viewAllRooms method

    public void viewRoomDetails(int roomID) throws SQLException {
        String viewRoomSql = "SELECT room_id, room_number, type, price, status FROM rooms WHERE room_id = " + roomID;

        try(Connection conn = connectDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(viewRoomSql)) {
            System.out.println("\nRoom Details:");
            System.out.println("+---------+-------------+------------+------------+-----------+");
            System.out.println("| Room ID | Room Number | Type       | Price(Rs.) | Status    |");
            System.out.println("+---------+-------------+------------+------------+-----------+");

            while (rset.next()) {
                int roomId = rset.getInt("room_id");
                String roomNum = rset.getString("room_number");
                String type = rset.getString("type");
                Double price = rset.getDouble("price");
                String status = rset.getString("status");

                System.out.printf("| %-7d | %-11s | %-10s | %-10.2f | %-9s |\n", roomId, roomNum, type, price,
                        status);
            }

            System.out.println("+---------+-------------+------------+------------+-----------+");
        }
    } // End of viewRoomDetails method

    public void updateRoom(Room room, int roomId) throws SQLException {
        String addRoomSql = "UPDATE rooms SET room_number = ?, type = ?, price = ?, status = ? WHERE room_id = " + roomId;

        try(Connection conn = connectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(addRoomSql)) {
            stmt.setString(1, room.getRoomNumber());
            stmt.setString(2, room.getType());
            stmt.setDouble(3, room.getPrice());
            stmt.setString(4, room.getStatus());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("\nRoom details updated successfully!");
            } else {
                System.out.println("\nUpdating room details failed!");
            }
        }
    } // End of updateRoom method

    public void deleteRoom(int roomID) throws SQLException {
        String deleteRoomSql = "DELETE FROM rooms WHERE room_id = " + roomID;

        try(Connection conn = connectDB.getConnection();
            Statement stmt = conn.createStatement()) {

            int affectedRows = stmt.executeUpdate(deleteRoomSql);

            if (affectedRows > 0) {
                System.out.println("\nRoom deleted Successfully!");
            } else {
                System.out.println("\nDeleting room failed!");
            }
        }
    } // End of deleteRoom method
}