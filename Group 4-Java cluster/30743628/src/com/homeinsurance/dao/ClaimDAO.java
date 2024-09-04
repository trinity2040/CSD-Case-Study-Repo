package com.homeinsurance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.connection.DBConnection;
import com.homeinsurance.model.Claim;

public class ClaimDAO {

    // Add claim 
    public void addClaim(Claim claim) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Claim (policy_id, homeowner_id, claim_date, status) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, claim.getPolicyId());
            stmt.setInt(2, claim.getHomeownerId());
            stmt.setString(3, claim.getClaimDate()); // Convert LocalDate to SQL Date
            stmt.setString(4, claim.getStatus());
            stmt.executeUpdate();
            System.out.println("Claim submitted successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding claim: " + e.getMessage());
        }
    }

    // Display claim details
    public Claim getClaimById(int claimId) {
        Claim claim = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Claim WHERE claim_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, claimId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                claim = new Claim();
                claim.setClaimId(rs.getInt("claim_id"));
                claim.setPolicyId(rs.getInt("policy_id"));
                claim.setHomeownerId(rs.getInt("homeowner_id"));
                claim.setClaimDate(rs.getString("claim_date")); // Convert SQL Date to LocalDate
                claim.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving claim: " + e.getMessage());
        }
        return claim;
    }

    // Update claim details
    public void updateClaim(Claim claim) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Claim SET policy_id = ?, homeowner_id = ?, claim_date = ?, status = ? WHERE claim_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, claim.getPolicyId());
            stmt.setInt(2, claim.getHomeownerId());
            stmt.setDate(3, Date.valueOf(claim.getClaimDate())); // Convert LocalDate to SQL Date
            stmt.setString(4, claim.getStatus());
            stmt.setInt(5, claim.getClaimId());
            stmt.executeUpdate();
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Claim updated successfully.");
            } else {
                System.out.println("Claim not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating claim: " + e.getMessage());
        }
    }

    // Delete a claim
    public void deleteClaim(int claimId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Claim WHERE claim_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, claimId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Claim deleted successfully.");
            } else {
                System.out.println("Claim not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting claim: " + e.getMessage());
        }
    }

    // Get all claims 
    public List<Claim> getAllClaims() {
        List<Claim> claims = new ArrayList<>();
        String sql = "SELECT * FROM Claim";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Claim claim = new Claim();
                claim.setClaimId(rs.getInt("claim_id"));
                claim.setPolicyId(rs.getInt("policy_id"));
                claim.setHomeownerId(rs.getInt("homeowner_id"));
                claim.setClaimDate(rs.getString("claim_date")); // Convert SQL Date to LocalDate
                claim.setStatus(rs.getString("status"));
                claims.add(claim);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving claims: " + e.getMessage());
        }
        return claims;
    }
}
