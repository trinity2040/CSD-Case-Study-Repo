package com.healthinsurancemanagement.model;

public class Policy {
    private int policyId;
    private String policyNumber;
    private String type;
    private double coverageAmount;
    private double premiumAmount;

    // Default Constructor
    public Policy() {
    }

    // Parameterized Constructor
    public Policy(int policyId, String policyNumber, String type, double coverageAmount, double premiumAmount) {
        this.policyId = policyId;
        this.policyNumber = policyNumber;
        this.type = type;
        this.coverageAmount = coverageAmount;
        this.premiumAmount = premiumAmount;
    }

    // Getter for policyId
    public int getPolicyId() {
        return policyId;
    }

    // Setter for policyId
    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    // Getter for policyNumber
    public String getPolicyNumber() {
        return policyNumber;
    }

    // Setter for policyNumber
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for coverageAmount
    public double getCoverageAmount() {
        return coverageAmount;
    }

    // Setter for coverageAmount
    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    // Getter for premiumAmount
    public double getPremiumAmount() {
        return premiumAmount;
    }

    // Setter for premiumAmount
    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    // toString method for easy display of Policy information
    @Override
    public String toString() {
        return "\nThe Policy Detail :-" +
                "\nPolicy Id : " + policyId +
                "\nPolicy Number :" + policyNumber +
                "\nPolicy Type : " + type +
                "\nCoverage Amount : " + coverageAmount +
                "\nPremium Amount : " + premiumAmount;
    }
}
