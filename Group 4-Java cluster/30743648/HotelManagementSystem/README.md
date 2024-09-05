# Hotel Management System

## Overview
This is a Java-based Hotel Management System that allows users to manage rooms, guests, and reservations using a MySQL database.

## Features
- **Room Management**: 
        Add a new room
        View room details
        Update room information
        Delete a room

- **Guest Management**: 
        Register a new guest
        View guest details
        Update guest information
        Delete a guest

- **Reservation Management**: 
        Make a new reservation
        View reservation details
        Update reservation information
        Cancel a reservation
    Automatically calculates the total price based on the duration of the stay.

## Prerequisites
- **Java**: JDK 8 or higher.
- **MySQL**: MySQL Server running with a database named `hotel_management`.
- **IDE**:  Eclipse or IntelliJ IDE.

## Setup Instructions
1. Clone the repository:
    ```sh
    git clone https://github.com/koustav-s/hotel-management-system.git
    cd hotel-management-system
    ```

2. Import the project into your IDE (Eclipse or IntelliJ IDEA).

3. Add the MySQL Connector/J to your project:
    - Download the MySQL Connector/J JAR file.
    - In your IDE, right-click the project and go to `Build Path > Configure Build Path`.
    - Under the `Libraries` tab, click `Add External JARs` and select the MySQL Connector/J JAR.

4. Set up the MySQL database:
    - Create a database named `hotel_management`.
    - Run the following SQL commands to create the necessary tables:

    ```sql
    create database  hotel_management;

    use hotel_management;

    create table room (
        room_number int primary key,
        type varchar(50),
        price_per_night double,
        availability_status boolean default true
    );

    create table guest (
        guest_id int primary key auto_increment,
        name varchar(100),
        email varchar(100),
        phone_number varchar(10),
        address varchar(100)
    );

    create table reservation (
        reservation_id int primary key auto_increment,
        room_number int,
        guest_id int,
        check_in_date date,
        check_out_date date,
        total_price double,
        foreign key (room_number) references room(room_number),
        foreign key (guest_id)  references guest(guest_id)
    );
    ```

5. Run the application:
    ```sh
    java hms.HotelManagementSystem
    ```

Acknowledgments
Inspired by various hotel management systems and Java tutorials.


This README file provides a comprehensive overview of your project, setup instructions, and usage guidelines, making it easier for others to understand and contribute to your project.
