# Health Care Management System

This is a simple console-based Helath Care Management System implemented in Java, using JDBC for database operations. The application provides a menu-based interface for managing patients, doctors, and appointments. Follow the on-screen prompts to navigate through the system and perform various operations.


## Pre-requisites

- Java Development Kit (JDK) 8 or higher
- MySQL Database Server
- MySQL Connector/J (JDBC driver for MySQL)

## Setup

1. Set up your MySQL database:
   - Create a new database named `health_care_system`
   - Create the following tables:
     - `patients` (patient_id, name, date_of_birth, gender, address)
     - `doctors` (doctor_id, name, specialization, contact_number, email)
     - `appointment` (appointment_id, patient_id, doctor_id, appointment_date, appointment_time, status)

2. Update the `DatabaseManager` class with your MySQL credentials:
   - Update the `URL`, `USER`, and `PASSWORD` constants with your database details.

3. Compile the Java files.

4. Run the application in your preferred IDE.


## Features

- Patient Management: Add, view, update, and delete patient records
- Doctor Management: Add, view, update, and delete doctor records
- Appointment Management: Add, view, update, and delete appointment records

