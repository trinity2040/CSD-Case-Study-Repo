 *Customer Service Management System*

## Description
The Customer Service Management System is a console-based Java application that allows users to manage customer inquiry, complaint and resolutions. The system is built using Core Java and utilizes MySQL as the backend database, with JDBC (Java Database Connectivity) for database operations. This application provides a simple menu-driven interface to perform CRUD (Create, Read, Update, Delete) operations on the data.

## Features
- **Inquiry Management**: Add, view, update, and delete policies.
- **Complaint Management**: Add, view, update, and delete artists.
- **Resolution Management**: Record, view, update, and cancel sales.

## System Requirements
- Java Development Kit (JDK) 8 or later
- MySQL Server
- MySQL Connector/J (JDBC Driver)
- Integrated Development Environment (IDE): Vs code, IntelliJ IDEA, Eclipse, or   any other Java IDE

## Setup Instructions
1. **Database Setup**:
   - Create a MySQL database named `customer_service`.
   - Create the following tables:

    ## sql
     CREATE DATABASE customer_service;

USE customer_service;

CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE Inquiry (
    inquiry_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    inquiry_date DATE,
    description TEXT,
    status VARCHAR(50),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

CREATE TABLE Complaint (
    complaint_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    complaint_date DATE,
    description TEXT,
    status VARCHAR(50),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

CREATE TABLE Resolution (
    resolution_id INT AUTO_INCREMENT PRIMARY KEY,
    inquiry_id INT,
    complaint_id INT,
    resolution_date DATE,
    details TEXT,
    FOREIGN KEY (inquiry_id) REFERENCES Inquiry(inquiry_id),
    FOREIGN KEY (complaint_id) REFERENCES Complaint(complaint_id)
);
     

2. **Configure the Application**:
   - Open the DBconnection.java file located in the src/database directory and update it with your MySQL database credentials:
 
   ## java
      private static final String URL = "jdbc:mysql://localhost:3306/customer_service";
      private static final String USER = "username";
      private static final String PASSWORD = "password";



3. **Run the Application**:
   - Compile and run the `Main.java` class.
   

## Usage
- Select the appropriate menu option to perform operations like adding, viewing, updating, or deleting records in the system.

## Notes
- Ensure that your MySQL server is running and accessible.
- Modify the database credentials in the `DBconnection.java` file if necessary.
