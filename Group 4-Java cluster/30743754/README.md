Student Enrollment Management System
Introduction
The Student Enrollment Management System is a console-based application developed in Java using the MVC architecture. The application facilitates the management of students, courses, and enrollments in a university setting. It provides functionalities for adding, updating, viewing, and deleting records in the system, interacting with a MySQL database through JDBC.

Requirements
Java Development Kit (JDK) 8 or higher
MySQL Database
MySQL JDBC Driver (Connector/J)
Database Setup
Install MySQL and create a database named studentmanagement.

Execute the following SQL statements to create the necessary tables:

CREATE DATABASE studentmanagement;

USE university;

CREATE TABLE Student (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    major VARCHAR(50),
    enrollment_year INT
);

CREATE TABLE Course (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100),
    instructor VARCHAR(100),
    credits INT
);

CREATE TABLE Enrollment (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    status VARCHAR(20),
    FOREIGN KEY (student_id) REFERENCES Student(student_id),
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);
Project Setup
Clone the repository

git clone 
Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).

Add the MySQL JDBC Driver to the project dependencies.

Update the database connection details in DbUtil.java:

private static final String URL = "jdbc:mysql://localhost:3306/studentmanagement"; 
private static final String USER = "root";
private static final String PASSWORD = "password";
Build and run the project.

Usage
Run the Main class to start the application.

Follow the menu options to manage students, courses, and enrollments.

