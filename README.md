This e-commerce platform is a console-based application designed to manage products, orders, and customers. 
Built using Core Java, MySQL, and JDBC, it facilitates efficient management of e-commerce operations, 
with functionalities grouped into modules for product management, order management, and customer management.

Table of Contents
->Components
Customer.java
CustomerDAO.java
DatabaseConnection.java
Main.java
Order.java
OrderDAO.java
Product.java
ProductDAO.java
ModuleInfo.java
Referenced Libraries

->Database Schema
Table Definitions
Relationships Between Tables

->Summary
->Implementation in Java
->Encapsulation and Exception Handling

Components
->Customer.java
Purpose: Represents a customer in the e-commerce system.
Attributes: customerId, name, email, address, phoneNumber.
Constructors: Two constructors are provided�one for creating a new customer without an ID (ID is auto-generated) and one for creating a customer with a specified ID (typically for retrieval from the database).
Methods: Includes getters and setters for all attributes and a toString() method to represent the customer as a string.

->CustomerDAO.java
Purpose: Handles database operations related to customers.
Methods:
> addCustomer(Customer customer): Inserts a new customer into the database and returns the generated ID.
> getCustomerById(int id): Retrieves a customer�s details from the database using the customer ID.
> Database Connection: Uses JDBC to connect to the MySQL database with predefined credentials.

->DatabaseConnection.java
Purpose: Manages the database connection.
Method: getConnection(): Establishes and returns a connection to the MySQL database using the JDBC driver.

->Main.java
Purpose: The entry point of the application. Manages user interactions and navigation between different functionalities (product management, order management, and customer management).
Structure: Contains a loop that presents a menu to the user and processes input to call appropriate methods for managing products, orders, or customers.
Methods:
> Manage Products, Orders, and Customers: Each section has its own set of operations (e.g., add, view, update, delete) 
facilitated by respective DAOs (Data Access Objects).
> Utility Methods: Includes methods for safely reading integer and double inputs from the user.

->Order.java
Purpose: Represents an order in the system.
Attributes: orderId, customerId, productId, quantity, orderDate, status.
Constructors: Includes a constructor for new orders and one for orders retrieved from the database.
Methods: Includes getters and setters for all attributes and a toString() method to represent the order as a string.

->OrderDAO.java
Purpose: Handles database operations related to orders.
Methods:
> placeOrder(Order order): Inserts a new order into the database and returns the generated order ID.
> getOrderById(int id): Retrieves order details from the database using the order ID.
> updateOrderStatus(int orderId, String status): Updates the status of an existing order.
> cancelOrder(int orderId): Deletes an order from the database.
> Database Connection: Uses JDBC for connecting to the MySQL database.

->Product.java
Purpose: Represents a product in the e-commerce system.
Attributes: productId, name, description, price, quantityAvailable, category.
Constructors: Includes constructors for creating new products and for products retrieved from the database.
Methods: Getters, setters, and a toString() method for representing the product as a string.

->ProductDAO.java
Purpose: Handles database operations related to products.
Methods:
> addProduct(Product product): Inserts a new product into the database and returns the generated ID.
> getProductById(int id): Retrieves product details from the database using the product ID.
> updateProduct(Product product): Updates the details of an existing product.
> deleteProduct(int productId): Deletes a product from the database.
> Database Connection: Uses JDBC for connecting to the MySQL database.

->ModuleInfo.java
Purpose: Defines module dependencies.
Content: Indicates that the module requires the java.sql module for database operations.

->Referenced Libraries
> Library: MySQL Connector/J (mysql-connector-j-9.0.0.jar).
> Purpose: Provides the JDBC driver necessary for Java to communicate with MySQL databases.

--- Database Schema ---
Table Definitions

> products Table
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    quantity_available INT NOT NULL,
    category VARCHAR(255)
);
product_id: Unique identifier for each product, automatically increments with each new entry.
name: The name of the product (required).
description: Textual description of the product.
price: The price of the product (with two decimal places for currency).
quantity_available: Number of items available in stock.
category: Category to which the product belongs.

>customers Table
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    address TEXT,
    phone_number VARCHAR(20)
);
customer_id: Unique identifier for each customer, automatically increments.
name: The name of the customer (required).
email: Email address of the customer (unique and required).
address: Residential address of the customer.
phone_number: Contact phone number of the customer.

>orders Table
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(255) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
order_id: Unique identifier for each order, automatically increments.
customer_id: Foreign key that references customer_id in the customers table.
product_id: Foreign key that references product_id in the products table.
quantity: Number of items ordered.
order_date: Timestamp for when the order was placed (defaults to the current time).
status: Status of the order (e.g., "pending", "shipped").

--- Relationships Between Tables ---
Foreign Key Constraints:
The orders table has foreign key constraints:
-> customer_id references customer_id in the customers table.
-> product_id references product_id in the products table.
These constraints ensure that any customer_id in the orders table must exist in the customers table and 
any product_id must exist in the products table, maintaining referential integrity between the tables.

This platform is built using Java and MySQL, leveraging JDBC for database interactions. 
It provides a command-line interface for managing products, orders, and customers. 
The DAO (Data Access Object) pattern is used to separate the database logic from the business logic, 
making the code more modular and maintainable. This structure allows users to perform CRUD (Create, Read, Update, Delete) 
operations on products, orders, and customers efficiently.

-> Encapsulation and Exception Handling
Encapsulation: Classes like Product, Customer, and Order encapsulate their data and provide public methods 
(getters and setters) to interact with it.
Exception Handling: The project uses try-catch blocks to handle SQLExceptions and other runtime exceptions gracefully, 
providing meaningful messages to the user.
