# Health Insurance Management System

Welcome to the *Health Insurance Management System* project! This console-based application is designed to efficiently manage health insurance policies, members, and claims. The system leverages *Core Java, MySQL, and JDBC* to provide a seamless and interactive experience.

## Features

### 1. Policy Management
- **Add a New Policy**: Create new policies with details such as policy number, type, coverage amount, and premium.
- **View Policy Details**: Retrieve and display information about existing policies.
- **Update Policy Information**: Modify policy details as needed.
- **Delete a Policy**: Remove policy records from the system.

### 2. Member Management
- **Register a New Member**: Add new members to the health insurance database with relevant details.
- **View Member Details**: Retrieve and display information about existing members.
- **Update Member Information**: Modify member details as needed.
- **Delete a Member**: Remove member records from the system.

### 3. Claim Management
- **Submit a New Claim**: File claims against policies and members, with details such as claim date and status.
- **View Claim Details**: Access information about submitted claims.
- **Update Claim Information**: Modify claim details, including claim status.
- **Delete a Claim**: Remove claim records from the system.

## Technologies Used
- **Java SE 8**: Core application development.
- **MySQL 8.0**: Database management system.
- **JDBC**: Java Database Connectivity for interacting with MySQL.
- **Git**: Version control system.

## Database Setup

Install MySQL and create a new database:

```sql
CREATE DATABASE health_insurance_management;

USE health_insurance_management;

CREATE TABLE Policy (
    policy_id INT PRIMARY KEY AUTO_INCREMENT,
    policy_number VARCHAR(50),
    type VARCHAR(50),
    coverage_amount DECIMAL(10, 2),
    premium_amount DECIMAL(10, 2)
);

CREATE TABLE Member (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    date_of_birth DATE,
    email VARCHAR(50),
    phone_number VARCHAR(15)
);

CREATE TABLE Claim (
    claim_id INT PRIMARY KEY AUTO_INCREMENT,
    policy_id INT,
    member_id INT,
    claim_date DATE,
    status VARCHAR(20),
    FOREIGN KEY (policy_id) REFERENCES Policy(policy_id),
    FOREIGN KEY (member_id) REFERENCES Member(member_id)
);

```

## Project Setup

### Configure Database Connection
1. Open `src/com/healthinsurancemanagement/dao/DatabaseConnection.java`.
2. Update the database URL, username, and password as per your MySQL configuration:

```java
private static String URL = "jdbc:mysql://localhost:3306/health_insurance_management";
private static String USER = "your_mysql_username";
private static String PASSWORD = "your_mysql_password";
```

## Usage

Upon running the application, you will be presented with a menu-driven interface that allows you to perform various operations:

![ss1](https://github.com/user-attachments/assets/1551da31-50ec-4719-9bc9-3dd8baff9b59)


<table>
    <tr>
        <td><strong>Policy Management</strong></td>
        <td><img src="https://github.com/user-attachments/assets/a7135258-b278-4391-ac55-5e0cc681ecd4" alt="Policy Management"></td>
    </tr>
    <tr>
        <td><strong>Member Management</strong></td>
        <td><img src="https://github.com/user-attachments/assets/008f508b-44c2-44e6-8a3e-411cb2acd835" alt="Member Management"></td>
    </tr>
    <tr>
        <td><strong>Claim Management</strong></td>
        <td><img src="https://github.com/user-attachments/assets/6a0ba89d-93f1-4f72-a668-dae862521850" alt="Claim Management"></td>
    </tr>
</table>

## Project Structure

The project follows a modular structure for better organization and maintainability:

```plaintext
src/
├── com/
    └── healthinsurancemanagement/
        ├── dao/
        │   ├── PolicyDAO.java
        │   ├── MemberDAO.java
        │   ├── ClaimDAO.java
        ├── model/
        │   ├── Policy.java
        │   ├── Member.java
        │   └── Claim.java
        └── main/
        │    └── HealthInsuranceManagementSystem.java
        └── util/
             └── DatabaseConnection.java
```

# Running the application
Compile the Java Files:- Before running the application, you need to compile the Java source files. Use the following command to compile the files
```java 
javac -d bin src/com/HealthInsuranceManagementSystem/*.java
```
Run the Application:- Once the compilation is successful, you can run the application using the following command
```java
java -cp bin com.healthinsurancemanagementsystem.main/HealthInsuranceManagementSystem.java
```

