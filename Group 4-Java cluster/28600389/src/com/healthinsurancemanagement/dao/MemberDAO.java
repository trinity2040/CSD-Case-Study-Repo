package com.healthinsurancemanagement.dao;

import com.healthinsurancemanagement.model.Member;
import com.healthinsurancemanagement.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO 
{

    // Method to add a new member and return the generated member_id
    public int addMember(Member member) 
    {
        String query = "INSERT INTO Member (name, date_of_birth, email, phone_number) VALUES (?, ?, ?, ?)";
        int generatedId = -1; // Default value indicating no ID generated
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, member.getName());
            pstmt.setDate(2, member.getDateOfBirth());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getPhoneNumber());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) 
            {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) 
                {
                    if (generatedKeys.next()) 
                    {
                        generatedId = generatedKeys.getInt(1);
                        System.out.println("\nMember added successfully with ID : " + generatedId);
                    }
                }
            } 
            else 
            {
                System.out.println("\nFailed to add member.");
            }

        } 
        catch (SQLException e) 
        {
            System.out.println("\nError while adding member: " + e.getMessage());
        }
        return generatedId;
    }

    // Method to retrieve a member by their ID
    public Member getMember(int memberId) 
    {
        String query = "SELECT * FROM Member WHERE member_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        {

            pstmt.setInt(1, memberId);

            try (ResultSet rs = pstmt.executeQuery()) 
            {
                if (rs.next()) 
                {
                    return new Member(
                            rs.getInt("member_id"),
                            rs.getString("name"),
                            rs.getDate("date_of_birth"),
                            rs.getString("email"),
                            rs.getString("phone_number")
                    );
                } else 
                {
                    System.out.println("\nSorry Member not found.");
                }
            }

        } catch (SQLException e) 
        {
            System.out.println("\nError while retrieving member: " + e.getMessage());
        }
        return null;
    }

    // Method to update an existing member
    public void updateMember(Member member) 
    {
        String query = "UPDATE Member SET name = ?, date_of_birth = ?, email = ?, phone_number = ? WHERE member_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        {

            pstmt.setString(1, member.getName());
            pstmt.setDate(2, member.getDateOfBirth());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getPhoneNumber());
            pstmt.setInt(5, member.getMemberId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) 
            {
                System.out.println("\nMember updated successfully !");
            } 
            else 
            {
                System.out.println("\nFailed to update member.");
            }

        } catch (SQLException e) 
        {
            System.out.println("\nError while updating member: " + e.getMessage());
        }
    }

    // Method to delete a member by their ID
    public void deleteMember(int memberId) 
    {
        String query = "DELETE FROM Member WHERE member_id = ?";  //Query Statement
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) 
        {

            pstmt.setInt(1, memberId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) 
            {
                System.out.println("\nMember deleted successfully !");
            } 
            else 
            {
                System.out.println("\nFailed to delete member.");
            }

        } 
        catch (SQLException e) 
        {
            System.out.println("\nError while deleting member: " + e.getMessage());
        }
    }
}
