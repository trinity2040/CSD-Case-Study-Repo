package com.healthinsurancemanagement.dao;

import com.healthinsurancemanagement.model.Policy;
import com.healthinsurancemanagement.util.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PolicyDAO 
{
    // Method to add a new policy
    public void addPolicy(Policy policy) 
    {
        String query = "INSERT INTO Policy (policy_number, type, coverage_amount, premium_amount) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, policy.getPolicyNumber());
            pstmt.setString(2, policy.getType());
            pstmt.setDouble(3, policy.getCoverageAmount());
            pstmt.setDouble(4, policy.getPremiumAmount());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) 
            {
                System.out.println("\nPolicy added successfully !");
            } else 
            {
                System.out.println("\nFailed to add policy.");
            }

        } catch (SQLException e) 
        {
            System.out.println("\nError while adding policy: " + e.getMessage());
        }
    }

    // Method to retrieve a policy by its ID
    public Policy getPolicy(int policyId) 
    {
        String query = "SELECT * FROM Policy WHERE policy_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        {

            pstmt.setInt(1, policyId);

            try (ResultSet rs = pstmt.executeQuery()) 
            {
                if (rs.next()) 
                {
                    return new Policy(
                            rs.getInt("policy_id"),
                            rs.getString("policy_number"),
                            rs.getString("type"),
                            rs.getDouble("coverage_amount"),
                            rs.getDouble("premium_amount")
                    );
                } else 
                {
                    System.out.println("\nPolicy not found.");
                }
            }

        } 
        catch (SQLException e) 
        {
            System.out.println("\nError while retrieving policy: " + e.getMessage());
        }
        return null;
    }

    // Method to update an existing policy
    public void updatePolicy(Policy policy) 
    {
        String query = "UPDATE Policy SET policy_number = ?, type = ?, coverage_amount = ?, premium_amount = ? WHERE policy_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        {

            pstmt.setString(1, policy.getPolicyNumber());
            pstmt.setString(2, policy.getType());
            pstmt.setDouble(3, policy.getCoverageAmount());
            pstmt.setDouble(4, policy.getPremiumAmount());
            pstmt.setInt(5, policy.getPolicyId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) 
            {
                System.out.println("\nPolicy information updated successfully.");
            } 
            else 
            {
                System.out.println("\nFailed to update policy.");
            }

        } catch (SQLException e) 
        {
            System.out.println("\nError while updating policy: " + e.getMessage());
        }
    }

    // Method to delete a policy by its ID
    public void deletePolicy(int policyId) 
    {
        String query = "DELETE FROM Policy WHERE policy_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        {

            pstmt.setInt(1, policyId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0)
            {
                System.out.println("\nPolicy deleted successfully.");
            } 
            else 
            {
                System.out.println("\nFailed to delete policy.");
            }

        } 
        catch (SQLException e) 
        {
            System.out.println("\nError while deleting policy: " + e.getMessage());
        }
    }
}
