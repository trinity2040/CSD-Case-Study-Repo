package com.schoolmanagement.dao;

import com.schoolmanagement.model.Teacher;
import com.schoolmanagement.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    public void addTeacher(Teacher teacher) {
        String query = "INSERT INTO Teacher (name, date_of_birth, address, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getDateOfBirth()); // Ensure this is in YYYY-MM-DD format
            preparedStatement.setString(3, teacher.getAddress());
            preparedStatement.setString(4, teacher.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Teacher getTeacher(int teacherId) {
        Teacher teacher = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Teacher WHERE teacher_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, teacherId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt("teacher_id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setDateOfBirth(resultSet.getString("date_of_birth"));
                teacher.setAddress(resultSet.getString("address"));
                teacher.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    public void updateTeacher(Teacher teacher) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Teacher SET name = ?, date_of_birth = ?, address = ?, email = ? WHERE teacher_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getDateOfBirth());
            preparedStatement.setString(3, teacher.getAddress());
            preparedStatement.setString(4, teacher.getEmail());
            preparedStatement.setInt(5, teacher.getTeacherId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacher(int teacherId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Teacher WHERE teacher_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, teacherId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Teacher";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt("teacher_id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setDateOfBirth(resultSet.getString("date_of_birth"));
                teacher.setAddress(resultSet.getString("address"));
                teacher.setEmail(resultSet.getString("email"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
}
