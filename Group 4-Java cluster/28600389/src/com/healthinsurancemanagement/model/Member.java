package com.healthinsurancemanagement.model;

import java.sql.Date;

public class Member {
    private int memberId;
    private String name;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;

    // Default Constructor
    public Member() 
    {
    	
    }

    // Parameterized Constructor
    public Member(int memberId, String name, Date dateOfBirth, String email, String phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter for memberId
    public int getMemberId() {
        return memberId;
    }

    // Setter for memberId
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for dateOfBirth
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    // Setter for dateOfBirth
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter for phoneNumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString method for easy display of Member information
    @Override
    public String toString() {
        return "\nThe Member Detail :-" +
                "\nMember ID : " + memberId +
                "\nName : " + name +
                "\nDate Of Birth : " + dateOfBirth +
                "\nEmail : " + email +
                "\nPhone Number : " + phoneNumber;
    }
}
