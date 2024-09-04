Transportation Management System

Overview:

  This Transportation Management System is a console-based application designed to help a logistics company manage its operations efficiently. The system allows users to manage vehicles, routes, and cargo by performing essential operations such as adding, viewing, updating, and deleting records.

Features:

1) Vehicle Management: Manage the company's fleet by adding, viewing, updating, and deleting vehicle records.
   
2) Route Management: Define and manage routes for transporting goods, including details like origin, destination, and distance.
   
3) Cargo Management: Keep track of the cargo being transported, including information like cargo type, weight, and associated vehicle.

Technologies Used:

  1) Java: The application is built using Core Java, ensuring a robust and object-oriented approach.
     
  2) MySQL: The data is stored in a MySQL database, which offers reliable data storage and retrieval.
  
  3) JDBC: Java Database Connectivity (JDBC) is used to interact with the MySQL database, enabling smooth data operations.

Setup Instructions:

  1) Install Java: Ensure you have Java installed on your system. This project is compatible with Java 8 or higher.

  2) Install MySQL: Set up MySQL on your system and create a database for the application.
    
  3) Database Configuration: Update the database connection details in the application to match your MySQL setup (e.g., database URL, username, password).

Run the Application:

  Compile and run the application through your preferred IDE or command line. The application will start in the console, where you can interact with the menu-based system.

How It Works
  Upon launching, the application presents a menu with options to manage vehicles, routes, and cargo.
  Users select an option, and the application prompts them to perform the desired action (e.g., add a new vehicle).
  The application interacts with the MySQL database using JDBC to execute the requested operation and displays the result to the user.

Error Handling
  The application includes robust error handling to manage common issues such as invalid input, database connection errors, and more. Custom exceptions are implemented to provide clear and user-friendly error messages.


