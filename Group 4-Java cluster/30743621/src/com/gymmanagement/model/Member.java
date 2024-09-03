package com.gymmanagement.model;

/**
 * The Member class represents a gym member with attributes such as memberId, name,
 * contactNumber, email, and membershipType. This class serves as a model in the gym
 * management system and includes standard getters and setters for these attributes.
 * 
 * Usage:
 * - This class can be used to store and retrieve information about gym members.
 */
public class Member {
	private int memberId;
    private String name,contactNumber,email,membershipType;

//	getters and setters
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
}