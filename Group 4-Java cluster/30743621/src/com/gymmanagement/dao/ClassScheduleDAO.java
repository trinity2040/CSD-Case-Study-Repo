package com.gymmanagement.dao;

import com.gymmanagement.model.ClassSchedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassScheduleDAO is responsible for interacting with the database to perform operations 
 * on the Class Data. It contains methods to register a new class, retrieve Class details  
 * by scheduleID, update class information, delete a class,and retrieve a list of all Classes. 
 * 
 * This class relies on the DatabaseConnection utility to manage database connections.
 */
public class ClassScheduleDAO {

// Register a new class schedule
    public void addClassSchedule(ClassSchedule classSchedule) {
        String query = "INSERT INTO ClassSchedule (class_name,trainer_id,day_of_week,start_time,end_time) VALUES (?,?,?,?,?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
        	// Setting the values for the prepared statement using the class details
            preparedStatement.setString(1,classSchedule.getClassName());
            preparedStatement.setInt(2,classSchedule.getTrainerId());
            preparedStatement.setString(3,classSchedule.getDayOfWeek());
            preparedStatement.setTime(4,Time.valueOf(classSchedule.getStartTime()));
            preparedStatement.setTime(5,Time.valueOf(classSchedule.getEndTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Failed to add class: " + classSchedule.getClassName());
        	e.printStackTrace();
        	System.out.println("An error occurred while adding the class.");
        }
    }
    
//  Get class details by their scheduleId
    public ClassSchedule getClass(int scheduleId) {
        String query = "SELECT * FROM ClassSchedule WHERE schedule_id=?";
        ClassSchedule class1 = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, scheduleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                class1 = new ClassSchedule();
                
             // Setting the values using ClassShedule class setter methods
                class1.setScheduleId(resultSet.getInt("schedule_id"));
                class1.setClassName(resultSet.getString("class_name"));
                class1.setTrainerId(resultSet.getInt("trainer_id"));
                class1.setDayOfWeek(resultSet.getString("day_of_week"));
                class1.setStartTime(resultSet.getTime("start_time").toLocalTime());
                class1.setEndTime(resultSet.getTime("end_time").toLocalTime());
            }
        } catch (SQLException e) {
        	System.err.println("Error occurred while getting the class details.");
        	e.printStackTrace();
        }
        return class1;
    }

// View all class Schedules
    public List<ClassSchedule> getAllClassSchedules() {
        String query = "SELECT * FROM ClassSchedule";
        List<ClassSchedule> classSchedules = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
                ClassSchedule classSchedule = new ClassSchedule();
                classSchedule.setScheduleId(resultSet.getInt("schedule_id"));
                classSchedule.setClassName(resultSet.getString("class_name"));
                classSchedule.setTrainerId(resultSet.getInt("trainer_id"));
                classSchedule.setDayOfWeek(resultSet.getString("day_of_week"));
                classSchedule.setStartTime(resultSet.getTime("start_time").toLocalTime());
                classSchedule.setEndTime(resultSet.getTime("end_time").toLocalTime());
                classSchedules.add(classSchedule);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println("An error occurred while listing the class details.");
        }
        return classSchedules;
    }

// Update class information
    public void updateClassSchedule(ClassSchedule classSchedule) {
        String query = "UPDATE ClassSchedule SET class_name=?, trainer_id=?, day_of_week=?, start_time=?, end_time=? WHERE schedule_id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
        	// Setting the values for the prepared statement using the class details
            preparedStatement.setString(1, classSchedule.getClassName());
            preparedStatement.setInt(2, classSchedule.getTrainerId());
            preparedStatement.setString(3, classSchedule.getDayOfWeek());
            preparedStatement.setTime(4, Time.valueOf(classSchedule.getStartTime()));
            preparedStatement.setTime(5, Time.valueOf(classSchedule.getEndTime()));
            preparedStatement.setInt(6, classSchedule.getScheduleId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to update class with scheduleID: " + classSchedule.getScheduleId());
            e.printStackTrace();
            System.out.println("An error occurred while updating the member.");
        }
    }

// Cancel (delete) a class
    public void deleteClassSchedule(int scheduleId) {
        String query = "DELETE FROM ClassSchedule WHERE schedule_id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1,scheduleId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Failed to delete class with scheduleID: " + scheduleId);
            e.printStackTrace();
            System.out.println("An error occurred while deleting the class.");
        }
    }
}
