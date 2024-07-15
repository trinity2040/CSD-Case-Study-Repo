CREATE DATABASE fitness_center;
USE fitness_center;



CREATE TABLE Memberships (
    membership_id INT PRIMARY KEY AUTO_INCREMENT,
    member_name VARCHAR(255) NOT NULL,
    member_contact VARCHAR(20) NOT NULL,
    membership_type VARCHAR(50) NOT NULL,
    membership_expiry DATE NOT NULL
);


CREATE TABLE Trainers (
    trainer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    specialty VARCHAR(50) NOT NULL,
    contact_info VARCHAR(255) NOT NULL,
    availability TEXT NOT NULL
);


CREATE TABLE Classes (
    class_id INT PRIMARY KEY AUTO_INCREMENT,
    class_name VARCHAR(100) NOT NULL,
    trainer_id INT NOT NULL,
    schedule DATETIME NOT NULL,
    capacity INT NOT NULL,
    FOREIGN KEY (trainer_id) REFERENCES Trainers(trainer_id)
);


CREATE TABLE Attendance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT NOT NULL,
    class_id INT NOT NULL,
    attendance_date DATE NOT NULL,
    FOREIGN KEY (member_id) REFERENCES Memberships(membership_id),
    FOREIGN KEY (class_id) REFERENCES Classes(class_id)
);

-- -- Drop tables if they already exist
-- DROP TABLE IF EXISTS Attendance;
-- DROP TABLE IF EXISTS Classes;
-- DROP TABLE IF EXISTS Trainers;
-- DROP TABLE IF EXISTS Memberships;


CREATE TABLE Memberships (
    membership_id INT PRIMARY KEY AUTO_INCREMENT,
    member_name VARCHAR(255) NOT NULL,
    member_contact VARCHAR(20) NOT NULL,
    membership_type VARCHAR(50) NOT NULL,
    membership_expiry DATE NOT NULL
);


CREATE TABLE Trainers (
    trainer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    specialty VARCHAR(50) NOT NULL,
    contact_info VARCHAR(255) NOT NULL,
    availability TEXT NOT NULL
);


CREATE TABLE Classes (
    class_id INT PRIMARY KEY AUTO_INCREMENT,
    class_name VARCHAR(100) NOT NULL,
    trainer_id INT NOT NULL,
    schedule DATETIME NOT NULL,
    capacity INT NOT NULL,
    FOREIGN KEY (trainer_id) REFERENCES Trainers(trainer_id)
);


CREATE TABLE Attendance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT NOT NULL,
    class_id INT NOT NULL,
    attendance_date DATE NOT NULL,
    FOREIGN KEY (member_id) REFERENCES Memberships(membership_id),
    FOREIGN KEY (class_id) REFERENCES Classes(class_id)
);
