# Hospital Management System

This is a simple console-based Hospital Management System implemented in Java, using JDBC for database operations. The application provides a menu-based interface for managing patients, doctors, and medical records. Follow the on-screen prompts to navigate through the system and perform various operations.


## Pre-requisites

- Java Development Kit (JDK) 8 or higher
- MySQL Database Server
- MySQL Connector/J (JDBC driver for MySQL)

## Setup

1. Set up your MySQL database:
   - Create a new database named `hospital_db`
   - Create the following tables:
     - `patients` (patient_id, name, date_of_birth, gender, address)
     - `doctors` (doctor_id, name, specialization, contact_number, email)
     - `medical_records` (record_id, patient_id, doctor_id, date, diagnosis, treatment)

2. Update the `DatabaseManager` class with your MySQL credentials:
   - Update the `URL`, `USER`, and `PASSWORD` constants with your database details.

3. Compile the Java files.

4. Run the application in your preferred IDE.


## Features

- Patient Management: Add, view, update, and delete patient records
- Doctor Management: Add, view, update, and delete doctor records
- Medical Record Management: Add, view, update, and delete medical records

