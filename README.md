# Banking System Application
Group4 Java Cluster :- CaseStudy_No_2
## Overview
This project simulates a simple banking system, allowing users to manage accounts and perform transactions. The application is built using Core Java and interacts with a MySQL database using JDBC. The functionalities include creating accounts, viewing account details, updating account information, closing accounts, and handling deposits, withdrawals, and fund transfers.

## Project Structure

- **AccountManagement.java**: Handles all account-related operations such as creating a new account, viewing account details, updating account information, and closing an account.
  
- **TransactionManagement.java**: Manages transaction-related operations including deposits, withdrawals, and fund transfers. It ensures that transactions are properly recorded and account balances are updated.

- **Main.java**: The entry point of the application. It provides a menu-driven interface for the user to interact with the banking system.

```bash
BankingSystemProject/
│
├── src/
│   └── com/
│       └── CaseStudy_2/
│           ├── Main.java
│           ├── AccountManagement.java
│           ├── TransactionManagement.java
│
├── lib/
│   └── mysql-connector-java-8.0.27.jar
│
├── bin/
│   └── (Compiled .class files will be here)
│
└── README.md
```

## Dependencies

- **JDK**: Ensure that you have JDK installed (preferably version 8 or higher).
- **MySQL Database**: You need MySQL installed and running. The database schema for this project consists of two tables: `Account` and `Transaction`.
- **JDBC Driver**: Ensure that the MySQL JDBC driver (mysql-connector-java) is included in your project classpath.

## Database Setup

1. **Create Database and Tables**:
   - Create a database named `BankingSystem`.
   - Create the `Account` and `Transaction` tables using the SQL scripts provided below:

```sql
CREATE DATABASE BankingSystem;

USE BankingSystem;

CREATE TABLE Account (
    account_number INT AUTO_INCREMENT PRIMARY KEY,
    account_holder_name VARCHAR(255) NOT NULL,
    balance DOUBLE DEFAULT 0.0
);

CREATE TABLE Transaction (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_number INT,
    transaction_type ENUM('Deposit', 'Withdrawal', 'Transfer') NOT NULL,
    amount DOUBLE NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_number) REFERENCES Account(account_number) ON DELETE CASCADE
);
```

## Execution Instructions

1. **Compile the Java Files**:
   - Open a terminal and navigate to the directory containing the Java files.
   - Compile the files using:
     ```bash
     javac -cp .:mysql-connector-java-8.0.28.jar AccountManagement.java TransactionManagement.java Main.java
     ```

2. **Run the Application**:
   - After compilation, run the application with:
     ```bash
     java -cp .:mysql-connector-java-8.0.28.jar Main
     ```

3. **Interact with the Application**:
   - The application will present a menu with various options. Follow the prompts to create accounts, view details, update information, and perform transactions.

## Handling Errors

- The application has built-in exception handling to manage common errors such as insufficient balance during withdrawals or foreign key constraints during account closure.

## Future Enhancements

- Implement user authentication for added security.
- Add more detailed logging for transaction history.
- Develop a graphical user interface (GUI) to enhance user interaction.

---

