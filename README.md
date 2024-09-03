DIGITAL MARKETPLACE CONSOLE APPLICATION

Overview

This project is a Java-based console application simulating a digital marketplace. It includes functionalities for managing products, sellers, and transactions. The application uses MySQL for the database and JDBC for database connectivity.

PROJECT STRUCTURE

marketplace/
├── src/
│   ├── app/
│   │   └── MarketplaceApp.java
│   ├── dao/
│   │   ├── ProductDAO.java
│   │   ├── SellerDAO.java
│   │   └── TransactionDAO.java
│   ├── model/
│   │   ├── Product.java
│   │   ├── Seller.java
│   │   └── Transaction.java
│   ├── util/
│   │   └── DatabaseConnection.java
│   └── setup.sql
├── lib/
│   └── mysql-connector-java-8.0.33.jar
└── 

SETUP INSTRUCTIONS
1. Database Setup
To set up the database, execute the SQL statements provided in the setup.sql file. This file includes all necessary SQL commands to create the database schema and sample data.
-Download the setup.sql file from this repository.
-Open your MySQL client (e.g., MySQL Workbench, command line).
-Execute the SQL statements in the setup.sql file.

2. Database Configuration
Update the DatabaseConnection.java file with your MySQL database credentials:
-private static final String URL = "jdbc:mysql://localhost:3306/marketplace_db";
-private static final String USER = "root"; // Replace with your MySQL username
-private static final String PASSWORD = "password@123"; // Replace with your MySQL password

3. Running the Application
Compile the Java code
Run the application

FUNCTIONALITY
1.Product Management
-Add, update, delete, and retrieve products.
-View product details.
2.Seller Management
-Add, update, delete, and retrieve sellers.
-View seller details.
3.Transaction Management
-Process transactions and update product quantities.
-Retrieve transaction details.
-Update transaction status.
-Refund transactions.

ADDITIONAL INFORMATION
-MySQL JDBC Driver: Ensure that the MySQL JDBC driver (mysql-connector-java-8.0.33.jar) is included in the lib/ directory.
-Java Version: The application is developed using Java 8. Ensure you have JDK 8 or later installed.

