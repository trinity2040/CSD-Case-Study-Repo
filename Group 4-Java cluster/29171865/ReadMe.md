
# Employee Attendance System

## Overview

The **Employee Attendance System** is a Java-based console application designed to manage employee records and their attendance efficiently. The application uses JDBC for database interactions and MySQL as the database management system. 

## Features

- **Employee Management**: Add, update, delete, and view employee details.
- **Attendance Management**: Track daily attendance, update attendance records, and generate reports.
- **Attendance Reports**: 
  - Monthly attendance report for a specific employee.
  - Daily attendance report for all employees, sorted by date and employee ID.
- **Custom Exceptions**:
  - `EmployeeNotFoundException`: Thrown when an operation is performed on a non-existing employee.
  - `AttendanceNotFoundException`: Thrown when an attendance record is not found.
  - `DuplicateAttendanceException`: Thrown when attempting to add a duplicate attendance entry for the same employee on the same day.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Database
- IDE such as IntelliJ IDEA, Eclipse, or any other Java-supported IDE

## Database Setup

1. **Create the Database**: 

   ```sql
   CREATE DATABASE EmployeeAttendanceSystem;
   USE EmployeeAttendanceSystem;

   CREATE TABLE Employee (
       employee_id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100),
       department VARCHAR(50),
       email VARCHAR(100),
       phone_number VARCHAR(15)
   );

   CREATE TABLE Attendance (
       attendance_id INT PRIMARY KEY AUTO_INCREMENT,
       employee_id INT,
       date DATE,
       status VARCHAR(10),
       FOREIGN KEY (employee_id) REFERENCES Employee(employee_id),
       UNIQUE (employee_id, date)
   );
   ```

   The `Attendance` table includes a `UNIQUE` constraint to prevent duplicate attendance entries for the same employee on the same day.

2. **Configure Database Connection**:

   Update the `DatabaseConnection.java` file with your MySQL database credentials.

   ```java
   // Example
   private static final String URL = "jdbc:mysql://localhost:3306/EmployeeAttendanceSystem";
   private static final String USER = "your-username";
   private static final String PASSWORD = "your-password";
   ```

## How to Run

1. **Clone the Repository**: 

   ```bash
   git clone https://github.com/your-repo/EmployeeAttendanceSystem.git
   cd EmployeeAttendanceSystem
   ```

2. **Compile the Project**:

   If using an IDE like IntelliJ or Eclipse, simply import the project and build it. 

   Or, if using the command line:

   ```bash
   javac -d bin -sourcepath src src/com/cts/client/Main.java
   ```

3. **Run the Application**:

   ```bash
   java -cp bin com.cts.client.Main
   ```

4. **Navigate Through the Menu**:

   The application will display a menu for managing employees and attendance. Use the corresponding numbers to perform actions like adding employees, marking attendance, generating reports, etc.

## Usage

- **Adding Employees**: Input employee details like name, department, email, and phone number.
- **Managing Attendance**: Record attendance by providing employee ID, date, and status (Present/Absent).
- **Generating Reports**: View monthly attendance for specific employees or daily attendance for all employees.
- **Exception Handling**:
  - If an employee is not found during any operation, the system will throw an `EmployeeNotFoundException`.
  - If an attendance record is not found, the system will throw an `AttendanceNotFoundException`.
  - If a duplicate attendance entry is attempted for the same employee on the same day, the system will throw a `DuplicateAttendanceException`.

## Custom Exceptions

### `EmployeeNotFoundException`

- **Description**: Thrown when the application attempts to access or modify an employee record that does not exist.
- **Usage**: Automatically triggered during operations like updating, deleting, or fetching an employee by ID if the employee does not exist.

### `AttendanceNotFoundException`

- **Description**: Thrown when the application cannot find an attendance record for the given criteria (e.g., ID or date).
- **Usage**: Used in attendance management operations when a non-existent record is referenced.

### `DuplicateAttendanceException`

- **Description**: Thrown when attempting to add an attendance entry that already exists for a given employee on the same day.
- **Usage**: Ensures that the attendance table maintains unique records for each employee on each day.

---
