# Grade Calculation for School Management System
### Candidate ID: 29017917

## Overview

The School Management System is a Java-based console application designed to manage students, teachers, courses, and grades. The application uses MySQL for data storage and JDBC for database interactions. It provides functionalities for adding, updating, viewing, and deleting records, as well as calculating Grade Point Averages (GPA) for students.

## Features

- **Student Management**
  - Add a new student
  - View student details
  - Update student information
  - Delete a student

- **Teacher Management**
  - Add a new teacher
  - View teacher details
  - Update teacher information
  - Delete a teacher

- **Course Management**
  - Add a new course
  - View course details
  - Update course information
  - Delete a course

- **Grade Management**
  - Assign grades to students for courses
  - View grades of students for courses
  - Update grades of students for courses
  - Calculate GPA (Grade Point Average) of students

## Database Schema

### Student Table
CREATE TABLE Student (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    date_of_birth DATE,
    address VARCHAR(255),
    email VARCHAR(100)
);
  
### Teacher Table 
CREATE TABLE Teacher (
    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    date_of_birth DATE,
    address VARCHAR(255),
    email VARCHAR(100)
);

### Course Table
CREATE TABLE Course (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    description TEXT,
    teacher_id INT,
    FOREIGN KEY (teacher_id) REFERENCES Teacher(teacher_id)
);

### Grade Table
CREATE TABLE Grade (
    grade_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    grade VARCHAR(2),
    FOREIGN KEY (student_id) REFERENCES Student(student_id),
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);

## Prerequisites
- **Java Development Kit (JDK) 8 or higher**
- **MySQL Server**
- **JDBC Driver for MySQL**

### Setup and Configuration
1. Database Setup
Create a Database: Create a MySQL database named school_management.Run the provided SQL scripts to create the necessary tables in the database.

2. JDBC Configuration
JDBC Driver: Place the MySQL JDBC driver (mysql-connector-java-X.X.XX.jar) in the lib directory.
Database Credentials: Modify the DatabaseConnection.java file to include your MySQL database credentials (URL, username, and password).

## Database Schema
### Student Table
- `student_id` (Primary Key)
- `name`
- `date_of_birth`
- `address`
- `email`

### Teacher Table
- `teacher_id` (Primary Key)
- `name`
- `date_of_birth`
- `address`
- `email`

### Course Table
- `course_id` (Primary Key)
- `title`
- `description`
- `teacher_id` (Foreign Key references Teacher Table)

### Grade Table
- `grade_id` (Primary Key)
- `student_id` (Foreign Key references Student Table)
- `course_id` (Foreign Key references Course Table)
- `grade`



### Usage
Once the application is running, we will be presented with a menu. Follow the prompts to perform operations such as adding a student, viewing teacher details, assigning grades, calculating GPA, etc.

### Sample Menu Options
1. Student Management
    Add Student
    View Student
    Update Student
    Delete Student
2. Teacher Management
    Add Teacher
    View Teacher
    Update Teacher
    Delete Teacher
3. Course Management
    Add Course
    View Course
    Update Course
    Delete Course
4. Grade Management
    Assign Grades
    View Grades
    Update Grades
    Calculate GPA

### Candidate ID: 29017917

### Output Console pannel image: 
![alt text](<src/Screenshot (70).png>)

### Code Conventions
The code follows standard Java naming conventions.
Proper documentation and comments are included for better understanding and maintainability.

### contact
mitradiptamoy2000@gmail.com