# Hotel Booking System

## Overview

The Hotel Booking System is a Java-based application designed to manage customers, rooms, and bookings in a hotel setting. This system provides an easy-to-use interface for users to add customers and rooms, view customers and rooms details, and book rooms efficiently.

## Features

1.	**Room Management:**
- Add a new room
- View room details by ID
- View all room details
- Update room details
- Delete a room
2. **Customer Management:**
- Register a new customer
- view customer details by ID
- View all customer details
- Update customer details
- Remove a customer
3.	**Booking Management:**
- Book a room for a customer
- View all booking details
- List all bookings for a specific customer
- Cancel a booking

## Technologies Used

- Java
- MySQL
- JDBC (Java Database Connectivity)

## Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- MySQL Server

## Setup Instructions

1. **Clone the Repository:**
   ```bash
   https://github.com/Dipanjan2910/30743647-hotel-booking-system.git
   ```

2. **Create the Database:**
Open your MySQL client and execute the following SQL commands to create the necessary tables:

```bash
CREATE DATABASE hotel-booking-system;
```

```bash
USE hotel-booking-system;
```

3. **Create Rooms Table:**
```bash
CREATE TABLE rooms (
  room_id INT AUTO_INCREMENT PRIMARY KEY,
  room_number VARCHAR(10) NOT NULL,
  type VARCHAR(50) NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  status VARCHAR(10) NOT NULL CHECK (status IN ('available', 'booked'))
);
```

4. **Create Customers Table:** 
```bash
CREATE TABLE customers (
  customer_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  phone_number VARCHAR(15) NOT NULL
);
```

5. **Create Bookings Table:**
```bash
CREATE TABLE bookings (
  booking_id INT AUTO_INCREMENT PRIMARY KEY,
  room_id INT NOT NULL,
  customer_id INT NOT NULL,
  check_in_date DATE NOT NULL,
   check_out_date DATE NOT NULL,
  FOREIGN KEY (room_id) REFERENCES rooms(room_id),
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
```

6. **Configure Database Connection:**
Update the database connection details in the ConnectDb.java file:
```bash
private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
private static final String URL = "jdbc:mysql://localhost:3306/hotel_booking_system";
private static final String USER = "root";
private static final String PASSWORD = "<your MySQL password>";
```

Compile and Run the Main file of the Application.


