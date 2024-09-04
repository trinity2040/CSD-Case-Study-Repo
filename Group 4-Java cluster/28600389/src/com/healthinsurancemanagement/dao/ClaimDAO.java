package com.healthinsurancemanagement.dao;

import com.healthinsurancemanagement.model.Claim;
import com.healthinsurancemanagement.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class ClaimDAO 
{
    // Method to add a new claim
    public void addClaim(Claim claim) 
    {
        String query = "INSERT INTO Claim (policy_id, member_id, claim_date, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, claim.getPolicyId());
            pstmt.setInt(2, claim.getMemberId());
            pstmt.setDate(3, claim.getClaimDate());
            pstmt.setString(4, claim.getStatus());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nClaim added successfully.");
            } else {
                System.out.println("\nFailed to add claim.");
            }

        } catch (SQLException e) {
            System.out.println("\nError while adding claim: " + e.getMessage());
        }
    }

    // Method to retrieve a claim by its ID
    public Claim getClaim(int claimId) {
        String query = "SELECT * FROM Claim WHERE claim_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, claimId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Claim(
                            rs.getInt("claim_id"),
                            rs.getInt("policy_id"),
                            rs.getInt("member_id"),
                            rs.getDate("claim_date"),
                            rs.getString("status")
                    );
                } else 
                {
                    System.out.println("Sorry, Claim not found.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error while retrieving claim: " + e.getMessage());
        }
        return null;
    }

    // Method to update an existing claim
    public void updateClaim(Claim claim) {
        String query = "UPDATE Claim SET policy_id = ?, member_id = ?, claim_date = ?, status = ? WHERE claim_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, claim.getPolicyId());
            pstmt.setInt(2, claim.getMemberId());
            pstmt.setDate(3, claim.getClaimDate());
            pstmt.setString(4, claim.getStatus());
            pstmt.setInt(5, claim.getClaimId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Claim updated successfully.");
            } else {
                System.out.println("Failed to update claim.");
            }

        } catch (SQLException e) {
            System.out.println("Error while updating claim: " + e.getMessage());
        }
    }

    // Method to delete a claim by its ID
    public void deleteClaim(int claimId) {
        String query = "DELETE FROM Claim WHERE claim_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, claimId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Claim deleted successfully.");
            } else {
                System.out.println("Failed to delete claim.");
            }

        } catch (SQLException e) {
            System.out.println("Error while deleting claim: " + e.getMessage());
        }
    }
}
