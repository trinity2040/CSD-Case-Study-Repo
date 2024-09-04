HMS (Healthcare Management System)

## Overview

The Healthcare Management System is a simple Java application designed to manage patients, doctors, and appointment records in a hospital. This system allows users to perform CRUD operations on patients, doctors, and appointment records, and is built using Java, MySQL, and JDBC.

## Features

- **Patient Management:**
  - Register a new patient
  - View patient details
  - Update patient information
  - Delete patients

- **Doctor Management:**
  - Register new doctors
  - View doctor details
  - Update doctor information
  - Delete doctors

- **Appointment Management**
  - Schedule a new appointment
  - View appointment details
  - Update appointment information
  - Cancel an appointment

## Technologies Used

- **Java**: Programming language used for the application.
- **MySQL**: Database management system for storing data.
- **JDBC**: Java Database Connectivity for interacting with the MySQL database.
- **IntelliJ IDEA**: IDE used for development (though the application can be developed in any Java IDE).

- ## Setup Instructions

1. **Clone the Repository**

   git clone https://github.com/PranithOmkar/CSD-Case-Study-Repo/

2. **Set Up MySQL Database**

Create a database named healcare.
Execute the provided SQL scripts to create the necessary tables.

```
CREATE DATABASE healthcare;
USE healthcare;
CREATE TABLE patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    date_of_birth DATE,
    gender VARCHAR(10),
    address VARCHAR(255)
);

CREATE TABLE doctors (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialization VARCHAR(100),
    contact_number VARCHAR(15),
    email VARCHAR(100)
);

CREATE TABLE appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    appointment_time TIME,
    status VARCHAR(20),
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
);


3. **Configure Database Connection**

Open the DatabaseConnection.java file located in the src\com\healthcare\management\util directory.
Update the URL, USER, and PASSWORD fields with your MySQL credentials.

private static final String URL = "jdbc:mysql://localhost:3306/healthcare";
private static final String USER = "root";
private static final String PASSWORD = "your_password";

4. **Build and Run the Application**

Open the project in IntelliJ IDEA (or another Java IDE).
Build the project to ensure all dependencies are included.
Run the Main class to start the application.

**Usage**

Upon starting the application, you will be presented with a menu to manage patients, doctors, or appointment records.
Follow the on-screen prompts to perform the desired operations.
