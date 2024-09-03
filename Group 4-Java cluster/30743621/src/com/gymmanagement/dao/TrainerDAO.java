package com.gymmanagement.dao;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gymmanagement.model.Trainer;

/**
 * TrainerDAO is responsible for interacting with the database to perform operations 
 * on the Trainer data. It contains methods to add a new Trainer, retrieve Trainer details  
 * by ID, update Trainer information, delete a Trainer,and retrieve a list of all Trainers. 
 * 
 * This class relies on the DatabaseConnection utility to manage database connections.
 */
public class TrainerDAO {
	
//	Add new trainer to the database
	public void addTrainer(Trainer trainer) {
		String query = "INSERT INTO Trainer(name,contact_number,email,speciality) VALUES (?,?,?,?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
        	// Setting the values for the prepared statement using the trainer's details
            preparedStatement.setString(1,trainer.getName());
            preparedStatement.setString(2,trainer.getContactNumber());
            preparedStatement.setString(3,trainer.getEmail());
            preparedStatement.setString(4,trainer.getSpeciality());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Failed to add trainer: " + trainer.getName());
        	e.printStackTrace();
        	System.out.println("An error occurred while adding the trainer.");
        }
	}
	
//	Get trainer details by their memberId
	public Trainer getTrainer(int trainerId) {
        String query = "SELECT * FROM Trainer WHERE trainer_id = ?";
        Trainer trainer = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1,trainerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                trainer = new Trainer();
                trainer.setTrainerId(resultSet.getInt("trainer_id"));
                trainer.setName(resultSet.getString("name"));
                trainer.setContactNumber(resultSet.getString("contact_number"));
                trainer.setEmail(resultSet.getString("email"));
                trainer.setSpeciality(resultSet.getString("speciality"));
            }
        } catch (SQLException e) {
        	System.err.println("Error occurred while getting the trainer details.");
        	e.printStackTrace();
        }
        return trainer;
    }
	
//	Update Trainer Informations
	public void updateTrainer(Trainer trainer) {
        String query = "UPDATE Trainer SET name=?, contact_number=?, email=?, speciality=? WHERE trainer_id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
        	//  Setting the values for the prepared statement using the trainer's details
            preparedStatement.setString(1,trainer.getName());
            preparedStatement.setString(2,trainer.getContactNumber());
            preparedStatement.setString(3,trainer.getEmail());
            preparedStatement.setString(4,trainer.getSpeciality());
            preparedStatement.setInt(5,trainer.getTrainerId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Failed to update trainer with ID: " + trainer.getTrainerId());
            e.printStackTrace();
            System.out.println("An error occurred while updating the trainer.");
        }
    }

//  Delete Trainer Informations
    public void deleteTrainer(int trainerId) {
        String query = "DELETE FROM Trainer WHERE trainer_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1,trainerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Failed to delete trainer with ID: " + trainerId);
            e.printStackTrace();
            System.out.println("An error occurred while deleting the trainer.");
        }
    }

//  View all trainer details
    public List<Trainer> getAllTrainers() {
        String query = "SELECT * FROM Trainer";
        List<Trainer> trainers = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
            	Trainer trainer = new Trainer();
                trainer.setTrainerId(resultSet.getInt("trainer_id"));
                trainer.setName(resultSet.getString("name"));
                trainer.setContactNumber(resultSet.getString("contact_number"));
                trainer.setEmail(resultSet.getString("email"));
                trainer.setSpeciality(resultSet.getString("speciality"));
                trainers.add(trainer);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            System.out.println("An error occurred while listing the trainer details.");
        }
        return trainers;
    }
}