Transportation Management System:
    	
  This project is a console-based application for managing vehicles, routes, and cargo in a logistics company. The application is developed in Java and uses MySQL for database management.

Getting Started:)

Prerequisites:

  •	Java Development Kit (JDK): Ensure you have JDK 8 or later installed on your system.
  
  •	MySQL: Install MySQL server on your system and set up a root user with the necessary password.
  
  •	IDE: Use an IDE Eclipse to manage and run the project.
  
  •	MySQL JDBC Driver: Download the MySQL JDBC Connector and add it to your project’s classpath.

Setting Up the Database:
1.	Create the Database:
o	Open your MySQL command line or any MySQL client (like MySQL Workbench).
o	Run the SQL commands in the database_setup. sql file to create the necessary database and tables. These include Vehicle, Route, and Cargo tables.
2.	Configure Database Credentials:
o	In the DatabaseConnection.java file, update the database URL, username, and password to match your MySQL configuration.

Running the Project:
1.	Open the Project in Your IDE:
o	Import the project into your preferred IDE.
2.	Add MySQL JDBC Connector:
o	Ensure the MySQL JDBC connector is added to your project’s classpath.
3.	Compile and Run:
o	Compile the project to ensure there are no errors.
o	Run the TransportationManagementSystem class to start the application.

Using the Application:

  •	Vehicle Management: Add, view, update, and delete vehicles.
  
  •	Route Management: Add, view, update, and delete routes.
  
  •	Cargo Management: Add, view, update, and delete cargo.
  
  •	Choose the "Exit" option from the main menu to safely close the application.

Summary:

  This project helps manage a transportation system by organizing vehicle, route, and cargo data using a MySQL database. It’s designed to be user-friendly and simple to operate via a console menu.
