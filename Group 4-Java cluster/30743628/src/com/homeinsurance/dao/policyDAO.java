package com.homeinsurance.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.connection.DBConnection;
import com.homeinsurance.*;
import com.homeinsurance.model.Policy;


public class policyDAO {
	
	//   add   policy
	     public void addPolicy(Policy policy) {
	        try (Connection conn = DBConnection.getConnection()) {
	            String sql = "INSERT INTO Policy (policy_number, type, coverage_amount, premium_amount) VALUES (?, ?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, policy.getpolicyNumber());
	            stmt.setString(2, policy.gettype());
	            stmt.setDouble(3, policy.getcoverageAmount());
	            stmt.setDouble(4, policy.getpremiumAmount());
	          
	        int rowsInserted = stmt.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("A new policy was inserted successfully!");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error adding policy: " + e.getMessage());
	        }
	    }

	    
	//  display  policy details
	    public Policy getPolicyById(int policyId) {
	        Policy policy = null;
	        try (Connection conn = DBConnection.getConnection()) {
	            String sql = "SELECT * FROM Policy WHERE policy_id = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, policyId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                policy = new Policy();
	                policy.setpolicyId(rs.getInt("policy_id"));
	                policy.setpolicyNumber(rs.getString("policy_number"));
	                policy.settype(rs.getString("type"));
	                policy.setcoverageAmount(rs.getDouble("coverage_amount"));
	                policy.setpremiumAmount(rs.getDouble("premium_amount"));
	            }
	        } catch (SQLException e) {
	            System.err.println("Error retrieving policy: " + e.getMessage());
	        }
	        return policy;
	    }
	    
		
//		Update policy Info
	public void updatePolicy(Policy policy) {
	    try (Connection conn = DBConnection.getConnection()) {
	        String sql = "UPDATE Policy SET policy_number = ?, type = ?, coverage_amount = ?, premium_amount = ? WHERE policy_id = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, policy.getpolicyNumber());
	        stmt.setString(2, policy.gettype());
	        stmt.setDouble(3, policy.getcoverageAmount());
	        stmt.setDouble(4, policy.getpremiumAmount());
	        stmt.setInt(5, policy.getpolicyId());

	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Policy updated successfully.");
	        } else {
	            System.out.println("Policy not found.");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error updating policy: " + e.getMessage());
	    }
	}


	//  Delete policy
	public void deletePolicy(int policyId) {
	    try (Connection conn = DBConnection.getConnection()) {
	        String sql = "DELETE FROM Policy WHERE policy_id = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, policyId);

	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Policy deleted successfully.");
	        } else {
	            System.out.println("Policy not found.");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error deleting policy: " + e.getMessage());
	    }
	}
	    // get all policy details 
	    public List<Policy> getAllPolicies() {
	        List<Policy> policies = new ArrayList<>();
	        String sql = "SELECT * FROM Policy";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {
	             
	            while (rs.next()) {
	                Policy policy = new Policy();
	                policy.setpolicyId(rs.getInt("policy_id"));
	                policy.setpolicyNumber(rs.getString("policy_number"));
	                policy.settype(rs.getString("type"));
	                policy.setcoverageAmount(rs.getDouble("coverage_amount"));
	                policy.setpremiumAmount(rs.getDouble("premium_amount"));
	                policies.add(policy);
	            }
	        } catch (SQLException e) {
	            System.err.println("Error retrieving policies: " + e.getMessage());
	        }
	        return policies;  
	}
	}

