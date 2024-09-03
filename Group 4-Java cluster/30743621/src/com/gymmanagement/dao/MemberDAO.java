package com.gymmanagement.dao;

import com.gymmanagement.model.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MemberDAO is responsible for interacting with the database to perform operations 
 * on the Member data. It contains methods to add a new member, retrieve member details  
 * by ID, update member information, delete a member,and retrieve a list of all members. 
 * 
 * This class relies on the DatabaseConnection utility to manage database connections.
 */
public class MemberDAO {
	
//	Add new member to the database
	public void addMember(Member member) {
		String query = "INSERT INTO Member(name,contact_number,email,membership_type) VALUES (?,?,?,?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
        	// Setting the values for the prepared statement using the member's details
            preparedStatement.setString(1,member.getName());
            preparedStatement.setString(2,member.getContactNumber());
            preparedStatement.setString(3,member.getEmail());
            preparedStatement.setString(4,member.getMembershipType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Failed to add member: " + member.getName());
        	e.printStackTrace();
        	System.out.println("An error occurred while adding the member.");
        }
	}
	
//	Get member details by their memberId
	public Member getMember(int memberId) {
        String query = "SELECT * FROM Member WHERE member_id=?";
        Member member = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1,memberId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                member = new Member();
                
                // Setting the values using Member class setter methods
                member.setMemberId(resultSet.getInt("member_id"));
                member.setName(resultSet.getString("name"));
                member.setContactNumber(resultSet.getString("contact_number"));
                member.setEmail(resultSet.getString("email"));
                member.setMembershipType(resultSet.getString("membership_type"));
            }
        } catch (SQLException e) {
        	System.err.println("Error occurred while getting the member details.");
        	e.printStackTrace();
        }
        return member;
    }
	
//	Update Member Informations
	public void updateMember(Member member) {
        String query = "UPDATE Member SET name=?,contact_number=?,email=?,membership_type=? WHERE member_id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
        	// Setting the values for the prepared statement using the member's details
            preparedStatement.setString(1,member.getName());
            preparedStatement.setString(2,member.getContactNumber());
            preparedStatement.setString(3,member.getEmail());
            preparedStatement.setString(4,member.getMembershipType());
            preparedStatement.setInt(5,member.getMemberId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Failed to update member with ID: " + member.getMemberId());
            e.printStackTrace();
            System.out.println("An error occurred while updating the member.");
        }
    }

//  Delete Member Informations
    public void deleteMember(int memberId) {
        String query = "DELETE FROM Member WHERE member_id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1,memberId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Failed to delete member with ID: " + memberId);
            e.printStackTrace();
            System.out.println("An error occurred while deleting the member.");
        }
    }

//  View all member details
    public List<Member> getAllMembers() {
        String query = "SELECT * FROM Member";
        List<Member> members = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
                Member member = new Member();
                member.setMemberId(resultSet.getInt("member_id"));
                member.setName(resultSet.getString("name"));
                member.setContactNumber(resultSet.getString("contact_number"));
                member.setEmail(resultSet.getString("email"));
                member.setMembershipType(resultSet.getString("membership_type"));
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while listing the member details.");
        }
        return members;
    }
}