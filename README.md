                                                                                    **Car Rental Management System**
This is a Java-based console application designed to manage a car rental service. The application provides functionality for managing customers, cars, and rental transactions, including renting, returning, and viewing rental details.

**Features**
Customer Management: Add, update, view, and delete customer records.
Car Management: Add, update, view, and delete car records.
Rental Management: Rent a car, return a car, and view rental details.
Database Integration: Uses a MySQL database to store and manage data.
Technologies Used
Java: The main programming language used to build the application.
JDBC (Java Database Connectivity): For connecting and executing queries on the MySQL database.
MySQL: The relational database management system used to store data and manipulate database tables.

**Database Schema**
Before running the application, create the necessary database tables in MySQL using the following SQL commands.

1. Database Creation
First, create a database named car_rental_db:

CREATE DATABASE car_rental_db;
USE Ccar_rental_db;

2. Customers Table
Create a table to store customer details:

CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL
);

3. Cars Table
Create a table to store car details:

CREATE TABLE Car (
    car_id INT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    daily_rate DECIMAL(10, 2) NOT NULL
);

4. Rentals Table
Create a table to store rental records:

CREATE TABLE Rental (
    rental_id INT AUTO_INCREMENT PRIMARY KEY,
    car_id INT NOT NULL,
    customer_id INT NOT NULL,
    rental_start_date DATE NOT NULL,
    rental_end_date DATE NOT NULL,
    total_charges DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (car_id) REFERENCES Car(car_id),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);
Getting Started
Follow the steps below to set up the project locally.

**1. Clone the Repository**

git clone https://github.com/your-username/car-rental-management-system.git
cd car-rental-management-system
**2. Set Up the Database**
Make sure you have MySQL installed and running. Execute the SQL commands provided above to create the necessary tables in the CarRentalDB database.

**3. Configure Database Connection**
Open the Car_Rental_Menu class and configure the database connection details:

conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarRentalDB", "username", "password");
Replace "username" and "password" with your MySQL credentials.

**4. Compile and Run the Application**
Compile the Java classes using the terminal or an IDE of your choice:


**How to Use**

1.Customer Management:
Add, view, update, or delete customer records.

2.Car Management:
Add, view, update, or delete car records.

3.Rental Management:
Rent a car, return a car, or view rental details.
