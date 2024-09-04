package com.homeinsurance.model;

public class Policy {
	    private int policyId;
	    private String policyNumber;
	    private String type;
	    private double coverageAmount;
	    private double premiumAmount;

	    // Constructors, Getters, and Setters
	    public int getpolicyId() {
			return policyId;
		}
		public void setpolicyId(int policyId) {
			this.policyId = policyId;
		}
		
		public String getpolicyNumber() {
			return policyNumber;
		}
		public void setpolicyNumber(String policyNumber) {
			this.policyNumber = policyNumber;
		}
		
		public String gettype() {
			return type;
		}
		public void settype(String type) {
			this.type = type;
		}
		
		public double getcoverageAmount() {
			return coverageAmount;
		}
		public void setcoverageAmount(double coverageAmount) {
			this.coverageAmount = coverageAmount;
		}
		
		public double getpremiumAmount() {
			return premiumAmount;
		}
		public void setpremiumAmount(double premiumAmount) {
			this.premiumAmount = premiumAmount;
		}
	}


