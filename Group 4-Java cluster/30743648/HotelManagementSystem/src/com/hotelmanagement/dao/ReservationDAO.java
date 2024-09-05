package com.hotelmanagement.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelmanagement.exception.ReservationNotFoundException;
import com.hotelmanagement.model.Reservation;
import com.hotelmanagement.util.JDBCUtil;

public class ReservationDAO {

    public void addReservation(Reservation reservation) throws SQLException {
        String query = "INSERT INTO Reservation (room_number, guest_id, check_in_date, check_out_date, total_price) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reservation.getRoomNumber());
            preparedStatement.setInt(2, reservation.getGuestId());
            preparedStatement.setDate(3, reservation.getCheckInDate());
            preparedStatement.setDate(4, reservation.getCheckOutDate());
            preparedStatement.setDouble(5, reservation.getTotalPrice());

            preparedStatement.executeUpdate();
            System.out.println("Reservation added successfully.");
        }
    }

    public Reservation getReservation(int reservationId) throws SQLException, ReservationNotFoundException {
        String query = "SELECT * FROM Reservation WHERE reservation_id = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reservationId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("room_number"),
                        rs.getInt("guest_id"),
                        rs.getDate("check_in_date"),
                        rs.getDate("check_out_date"),
                        rs.getDouble("total_price")
                );
            } else {
                throw new ReservationNotFoundException("Reservation with ID " + reservationId + " not found.");
            }
        }
    }

    public void updateReservation(Reservation reservation) throws SQLException {
        String query = "UPDATE Reservation SET room_number = ?, guest_id = ?, check_in_date = ?, check_out_date = ?, total_price = ? WHERE reservation_id = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reservation.getRoomNumber());
            preparedStatement.setInt(2, reservation.getGuestId());
            preparedStatement.setDate(3, reservation.getCheckInDate());
            preparedStatement.setDate(4, reservation.getCheckOutDate());
            preparedStatement.setDouble(5, reservation.getTotalPrice());
            preparedStatement.setInt(6, reservation.getReservationId());

            preparedStatement.executeUpdate();
            System.out.println("Reservation updated successfully.");
        }
    }

    public void cancelReservation(int reservationId) throws SQLException {
        String query = "DELETE FROM Reservation WHERE reservation_id = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reservationId);
            preparedStatement.executeUpdate();
            System.out.println("Reservation cancelled successfully.");
        }
    }
}
