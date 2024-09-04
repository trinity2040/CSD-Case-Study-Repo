package com.healthinsurancemanagement.model;

import java.sql.Date;

public class Claim {
    private int claimId;
    private int policyId;
    private int memberId;
    private Date claimDate;
    private String status;

    // Default Constructor
    public Claim() {
    }

    // Parameterized Constructor
    public Claim(int claimId, int policyId, int memberId, Date claimDate, String status) {
        this.claimId = claimId;
        this.policyId = policyId;
        this.memberId = memberId;
        this.claimDate = claimDate;
        this.status = status;
    }

    // Getter for claimId
    public int getClaimId() {
        return claimId;
    }

    // Setter for claimId
    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    // Getter for policyId
    public int getPolicyId() {
        return policyId;
    }

    // Setter for policyId
    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    // Getter for memberId
    public int getMemberId() {
        return memberId;
    }

    // Setter for memberId
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    // Getter for claimDate
    public Date getClaimDate() {
        return claimDate;
    }

    // Setter for claimDate
    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    // Getter for status
    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // toString method for easy display of Claim information
    @Override
    public String toString() {
        return "\nThe Claim Detail :- " +
                "\nClaim Id : " + claimId +
                "\nPolicy Id : " + policyId +
                "\nMember Id : " + memberId +
                "\nClaim Date : " + claimDate +
                "\nStatus : " + status;
    }
}
