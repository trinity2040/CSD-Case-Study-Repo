# Health Insurance Management System

## Overview
This is a Java-based console application that simulates a health insurance management system. The application allows users to manage policies, members, and claims in a database.

## Features
- **Policy Management:** Add, view, update and delete policies.
- **Member Management:** Register, view, update and delete members.
- **Claim Management:** Submit, view, update and delete claims.

## Technologies Used
- **Java**: Core Java for application development.
- **MySQL**: Database to store policies, members and claims.
- **JDBC**: Java Database Connectivity to interact with the MySQL database.

## Prerequisites
- Java 8 or higher
- MySQL database
- MySQL JDBC Driver (included in `lib/`)

## Database Setup
1. Create a MySQL database named `health_insurance_db`.
2. Execute the following SQL commands to create the required tables:

```sql
CREATE TABLE Policy (
    policy_id INT AUTO_INCREMENT PRIMARY KEY,
    policy_number VARCHAR(255) NOT NULL,
    type VARCHAR(255),
    coverage_amount DOUBLE,
    premium_amount DOUBLE
);

CREATE TABLE Member (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date_of_birth DATE,
    email VARCHAR(255),
    phone_number VARCHAR(255)
);

CREATE TABLE Claim (
    claim_id INT AUTO_INCREMENT PRIMARY KEY,
    policy_id INT,
    member_id INT,
    claim_date DATE,
    status VARCHAR(50),
    FOREIGN KEY (policy_id) REFERENCES Policy(policy_id),
    FOREIGN KEY (member_id) REFERENCES Member(member_id)
);
