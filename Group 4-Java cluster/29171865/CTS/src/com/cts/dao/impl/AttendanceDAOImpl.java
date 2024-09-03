package com.cts.dao.impl;


import com.cts.dao.AttendanceDAO;
import com.cts.exception.DuplicateAttendanceException;

import com.cts.model.Attendance;
import com.cts.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {
    private Connection connection;

    public AttendanceDAOImpl() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public void addAttendance(Attendance attendance) throws DuplicateAttendanceException {
        String checkQuery = "SELECT COUNT(*) FROM Attendance WHERE employee_id = ? AND date = ?";
        try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
            checkStmt.setInt(1, attendance.getEmployeeId());
            checkStmt.setString(2, attendance.getDate());

            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    throw new DuplicateAttendanceException("Duplicate attendance entry for employee ID "
                            + attendance.getEmployeeId() + " on date " + attendance.getDate());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO Attendance(employee_id, date, status) VALUES(?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, attendance.getEmployeeId());
            preparedStatement.setString(2, attendance.getDate());
            preparedStatement.setString(3, attendance.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        String query = "UPDATE Attendance SET status = ? WHERE employee_id = ? AND date = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, attendance.getStatus());
            preparedStatement.setInt(2, attendance.getEmployeeId());
            preparedStatement.setString(3, attendance.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAttendance(int attendanceId) {
        String query = "DELETE FROM Attendance WHERE attendance_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, attendanceId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Attendance getAttendanceById(int attendanceId) {
        String query = "SELECT * FROM Attendance WHERE attendance_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, attendanceId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Attendance(
                        resultSet.getInt("attendance_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("date"),
                        resultSet.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Attendance> getAttendancesByEmployeeId(int employeeId) {
        List<Attendance> attendances = new ArrayList<>();
        String query = "SELECT * FROM Attendance WHERE employee_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                attendances.add(new Attendance(
                        resultSet.getInt("attendance_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("date"),
                        resultSet.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }
    @Override
    public List<Attendance> getMonthlyAttendanceReport(int employeeId, String monthYear) {
        List<Attendance> attendances = new ArrayList<>();
        String query = "SELECT * FROM Attendance WHERE employee_id = ? AND DATE_FORMAT(date, '%Y-%m') = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setString(2, monthYear);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                attendances.add(new Attendance(
                        resultSet.getInt("attendance_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDate("date").toString(),
                        resultSet.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }

    @Override
    public List<Attendance> getDailyAttendanceReport() {
        List<Attendance> attendances = new ArrayList<>();
        String query = "SELECT * FROM Attendance ORDER BY date,employee_id";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                attendances.add(new Attendance(
                        resultSet.getInt("attendance_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDate("date").toString(),
                        resultSet.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }
}

