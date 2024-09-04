package com.homeinsurance.model;

public class Homeowner {
	    private int homeownerId;
	    private String name;
	    private String email;
	    private String phoneNumber;
	    private String address;

	    // Constructors, Getters, and Setters
	    public int getHomeownerId() {
			return homeownerId;
		}
		public void setHomeownerId(int homeownerId) {
			this.homeownerId = homeownerId;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

	    public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}


		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}

	}

