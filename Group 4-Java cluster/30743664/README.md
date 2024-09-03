# Gym Membership Management System

## Overview
The Gym Membership Management System is a menu-based console application developed to manage members, trainers, and membership plans in a gym. The project is built using Core Java, MySQL, and JDBC. It allows users to perform CRUD operations on members, trainers, and membership plans and manage memberships efficiently.
## Features
- **Member Management:**
  - Add a new member
  - View all member details
  - View member by id
  - Update member information
  - Delete a member

- **Trainer Management:**
  - Add a new trainer
  - View trainer details
  - Update trainer information
  - Delete a trainer

- **Membership Plan Management:**
  - Create a new membership plan
  - View plan details
  - Update plan information
  - Delete a membership plan

- **Additional Features:**
  - Handle membership plan expiration and renewal
  - Calculate membership fees based on the selected plan and duration
  - Effective exception handling and user-friendly error messages

## Technologies Used
- **Java**: Core Java for building the application logic.
- **MySQL**: For database management.
- **JDBC**: To connect and interact with the MySQL database.
## Database Schema and Setup

### SQL Commands
Use the following SQL commands to set up your MySQL database:

1. **Create Database:**
   ```sql
   CREATE DATABASE gymdb;
CREATE TABLE Member (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    address VARCHAR(255) NOT NULL
);
CREATE TABLE Trainer (
    trainer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    speciality VARCHAR(100) NOT NULL
);
CREATE TABLE MembershipPlan (
    plan_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    duration_months INT NOT NULL,
    price_per_month DECIMAL(10, 2) NOT NULL
);
CREATE TABLE MemberSubscription (
   id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    plan_id INT,
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (member_id) REFERENCES Member(member_id) ON DELETE CASCADE,
    FOREIGN KEY (plan_id) REFERENCES MembershipPlan(plan_id) ON DELETE CASCADE
);
