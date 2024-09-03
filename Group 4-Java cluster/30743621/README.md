# Gym Management System

Welcome to the **Gym Management System** project! This console-based application is designed to efficiently manage gym operations, including member registrations, trainer details, and class schedules. The system leverages **Core Java**, **MySQL**, and **JDBC** to provide a seamless and interactive experience.

## Table of Contents

## Features

### 1. Member Management
- **Register New Members**: Add new members to the gym database with relevant details.
- **View Member Details**: Retrieve and display information about existing members.
- **Update Member Information**: Modify member details as needed.
- **Delete Members**: Remove member records from the system.

### 2. Trainer Management
- **Add New Trainers**: Include new trainers into the gym's roster.
- **View Trainer Details**: Access information about current trainers.
- **Update Trainer Information**: Update trainer profiles and specialties.
- **Delete Trainers**: Delete trainer records from the database.

### 3. Class Schedule Management
- **Create New Class Schedules**: Schedule new classes with specified trainers and timings.
- **View Class Schedules**: Display all scheduled classes and their details.
- **Update Class Information**: Amend class details such as timings or trainers.
- **Cancel Classes**: Remove scheduled classes from the system.

## Technologies Used

- **Java SE 8**: Core application development.
- **MySQL 8.0**: Database management system.
- **JDBC**: Java Database Connectivity for interacting with MySQL.
- **Git**: Version control system.

## Database Setup

Install MySQL and create a new database:

```sql
CREATE DATABASE gym_management;

USE gym_management;

CREATE TABLE Member (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    contact_number VARCHAR(15),
    email VARCHAR(50),
    membership_type VARCHAR(20)
);

CREATE TABLE Trainer (
    trainer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    contact_number VARCHAR(15),
    email VARCHAR(50),
    speciality VARCHAR(50)
);

CREATE TABLE ClassSchedule (
    schedule_id INT PRIMARY KEY AUTO_INCREMENT,
    class_name VARCHAR(50),
    trainer_id INT,
    day_of_week VARCHAR(20),
    start_time TIME,
    end_time TIME,
    FOREIGN KEY (trainer_id) REFERENCES Trainer(trainer_id)
);
```
## Project Setup

### Configure Database Connection

1. Open `src/com/gymmanagement/dao/DatabaseConnection.java`.
2. Update the database URL, username, and password as per your MySQL configuration:

```java
private static String URL = "jdbc:mysql://localhost:3306/gym_management";
private static String USER = "your_mysql_username";
private static String PASSWORD = "your_mysql_password";
```

## Usage

Upon running the application, you will be presented with a menu-driven interface that allows you to perform various operations:

![Start](https://github.com/user-attachments/assets/b684a707-eb1b-4451-ba86-cfbb4f05961b)

<table>
    <tr>
        <td><strong>Member Management</strong></td>
        <td><img src="https://github.com/user-attachments/assets/3793dbd2-dbd8-4619-9bbd-18efb501c94e" alt="Member"></td>
    </tr>
    <tr>
        <td><strong>Trainer Management</strong></td>
        <td><img src="https://github.com/user-attachments/assets/a408cb66-aa2d-4a37-a143-de30d4c73f4b" alt="Trainer"></td>
    </tr>
    <tr>
        <td><strong>Class Schedule Management</strong></td>
        <td><img src="https://github.com/user-attachments/assets/faee366f-2132-4f4c-8645-e7fb0b5cead0" alt="Class"></td>
    </tr>
</table>


## Project Structure

# The project follows a modular structure for better organization and maintainability:

```plaintext
src/
├── com/
    └── gymmanagement/
        ├── dao/
        │   ├── MemberDAO.java
        │   ├── TrainerDAO.java
        │   ├── ClassScheduleDAO.java
        │   └── DatabaseConnection.java
        ├── model/
        │   ├── Member.java
        │   ├── Trainer.java
        │   └── ClassSchedule.java
        └── main/
            └── GymManagementSystem.java
```
# Running the application
Compile the Java Files:- Before running the application, you need to compile the Java source files. Use the following command to compile the files
```java
javac -d bin src/com/gymmanagement/*.java
```
Run the Application:- Once the compilation is successful, you can run the application using the following command
```java
java -cp bin com.gymmanagement.main.GymManagementSystem
```
# Output Samples
<table>
    <tr>
        <td><strong>Member Registration</strong></td>
        <td><img src="https://github.com/user-attachments/assets/f2cff7ab-873f-407d-a0db-aa2557c3f4c8" alt="Member Addition"></td>
        <td><strong>Member Updation</strong></td>
        <td><img src="https://github.com/user-attachments/assets/42f667d3-2554-4779-ac4d-0fd90f43efde" alt="Member Updation"></td>
    </tr>
    <tr>
        <td><strong>View Trainer Details</strong></td>
        <td><img src="https://github.com/user-attachments/assets/6307659e-755d-4694-a38d-7d1b18ecae43" alt="View Trainer Details"></td>
        <td><strong>Trainer Deletion</strong></td>
        <td><img src="https://github.com/user-attachments/assets/f15a13c8-5a3a-41b7-9261-63b19dd96736" alt="Trainer Deletion"></td>
    </tr>
    <tr>
        <td><strong>Add Class Schedule</strong></td>
        <td><img src="https://github.com/user-attachments/assets/d94b47b6-8cfa-485d-bcc6-4822ffb54900" alt="Add Class"></td>
        <td><strong>View Class Schedule based on scheduleId</strong></td>
        <td><img src="https://github.com/user-attachments/assets/f6bca136-ca30-4528-af87-3e410b386294" alt="View Class"></td>
    </tr>
</table>

