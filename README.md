# HMS (Hospital Management System)

## Overview

The Hospital Management System is a simple Java application designed to manage patients, doctors, and medical records in a hospital. This system allows users to perform CRUD operations on patients, doctors, and medical records, and is built using Java, MySQL, and JDBC.

## Features

- **Manage Patients**
  - Register new patients
  - View patient details
  - Update patient information
  - Delete patients
  - View all patients

- **Manage Doctors**
  - Register new doctors
  - View doctor details
  - Update doctor information
  - Delete doctors
  - View all doctors

- **Manage Medical Records**
  - Add new medical records
  - View medical record details
  - Update medical record information
  - Delete medical records
  - View all medical records

## Technologies Used

- **Java**: Programming language used for the application.
- **MySQL**: Database management system for storing data.
- **JDBC**: Java Database Connectivity for interacting with the MySQL database.
- **IntelliJ IDEA**: IDE used for development (though the application can be developed in any Java IDE).

- ## Setup Instructions

1. **Clone the Repository**

   git clone https://github.com/Shravanth96/CSD-Case-Study-Repo/

2. **Set Up MySQL Database**

Create a database named hospital_management.
Execute the provided SQL scripts to create the necessary tables.

```
CREATE DATABASE hospital_management;

USE hospital_management;

CREATE TABLE Patient (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    date_of_birth DATE,
    gender VARCHAR(10),
    address VARCHAR(255)
);

CREATE TABLE Doctor (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialization VARCHAR(100),
    contact_number VARCHAR(15),
    email VARCHAR(100)
);

CREATE TABLE Medical_Record (
    record_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    date DATE,
    diagnosis TEXT,
    treatment TEXT,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);
```

3. **Configure Database Connection**

Open the DatabaseConnection.java file located in the src/com/HospitalManagementSystem/hospital/util directory.
Update the URL, USER, and PASSWORD fields with your MySQL credentials.

private static final String URL = "jdbc:mysql://localhost:3306/hospital_management";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";

4. **Build and Run the Application**

Open the project in IntelliJ IDEA (or another Java IDE).
Build the project to ensure all dependencies are included.
Run the Main class to start the application.

**Usage**

Upon starting the application, you will be presented with a menu to manage patients, doctors, or medical records.
Follow the on-screen prompts to perform the desired operations.
