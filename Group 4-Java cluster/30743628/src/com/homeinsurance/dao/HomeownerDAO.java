package com.homeinsurance.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import com.cts.connection.DBConnection;
import com.homeinsurance.model.Homeowner;

	public class HomeownerDAO {
	// Add Homeowner
	    public void addHomeowner(Homeowner homeowner) {
	        try (Connection conn = DBConnection.getConnection()) {
	            String sql = "INSERT INTO Homeowner (homeowner_id,name, email, phone_number, address) VALUES (?,?, ?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, homeowner.getName());
	            stmt.setString(2, homeowner.getEmail());
	            stmt.setString(3, homeowner.getPhoneNumber());
	            stmt.setString(4, homeowner.getAddress());
	            stmt.executeUpdate();
	            System.out.println("Homeowner added successfully.");
	        } catch (SQLException e) {
	            System.err.println("Error adding homeowner: " + e.getMessage());
	        }
	    }
	// View Homeowner details 
	    public Homeowner getHomeownerById(int homeownerId) {
	        Homeowner homeowner = null;
	        try (Connection conn = DBConnection.getConnection()) {
	            String sql = "SELECT * FROM Homeowner WHERE homeowner_id = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, homeownerId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                homeowner = new Homeowner();
	                homeowner.setHomeownerId(rs.getInt("homeowner_id"));
	                homeowner.setName(rs.getString("name"));
	                homeowner.setEmail(rs.getString("email"));
	                homeowner.setPhoneNumber(rs.getString("phone_number"));
	                homeowner.setAddress(rs.getString("address"));
	            }
	        } catch (SQLException e) {
	            System.err.println("Error retrieving homeowner details: " + e.getMessage());
	        }
	        return homeowner;
	    }
	// update homeowner details 
	    public void updateHomeowner(Homeowner homeowner) {
	        try (Connection conn = DBConnection.getConnection()) {
	            String sql = "UPDATE Homeowner SET name = ?, email = ?, phone_number = ?, address = ? WHERE homeowner_id = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, homeowner.getName());
	            stmt.setString(2, homeowner.getEmail());
	            stmt.setString(3, homeowner.getPhoneNumber());
	            stmt.setString(4, homeowner.getAddress());
	            stmt.setInt(5, homeowner.getHomeownerId());

	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Homeowner updated successfully.");
	            } else {
	                System.out.println("Homeowner not found.");
	            }
	        } catch (SQLException e) {
	            System.err.println("Error updating homeowner details: " + e.getMessage());
	        }
	    }
	// delete homeowner details 
	    public void deleteHomeowner(int homeownerId) {
	        try (Connection conn = DBConnection.getConnection()) {
	            String sql = "DELETE FROM Homeowner WHERE homeowner_id = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, homeownerId);

	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Homeowner deleted successfully.");
	            } else {
	                System.out.println("Homeowner not found.");
	            }
	        } catch (SQLException e) {
	            System.err.println("Error deleting homeowner details" + e.getMessage());
	        }
	    }
	// get all homeowner details 
	public List<Homeowner> getAllHomeowners() {
	    List<Homeowner> homeowners = new ArrayList<>();
	    String sql = "SELECT * FROM Homeowner";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {
	         
	        while (rs.next()) {
	            Homeowner homeowner = new Homeowner();
	            homeowner.setHomeownerId(rs.getInt("homeowner_id"));
	            homeowner.setName(rs.getString("name"));
	            homeowner.setEmail(rs.getString("email"));
	            homeowner.setPhoneNumber(rs.getString("phone_number"));
	            homeowner.setAddress(rs.getString("address"));
	            homeowners.add(homeowner);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error retrieving homeowners: " + e.getMessage());
	    }
	    return homeowners;
	}
	}
