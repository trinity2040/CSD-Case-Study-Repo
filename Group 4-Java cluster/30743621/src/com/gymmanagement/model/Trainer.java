package com.gymmanagement.model;

/**
 * The Trainer class represents a gym Trainer with attributes such as trainerId, name,
 * contactNumber, email, and speciality. This class serves as a model in the gym
 * management system and includes standard getters and setters for these attributes.
 * 
 * Usage:
 * - This class can be used to store and retrieve information about gym trainers.
 */
public class Trainer {
	private int trainerId;
    private String name,contactNumber,email,speciality;

//	getters and setters
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
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

	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
}