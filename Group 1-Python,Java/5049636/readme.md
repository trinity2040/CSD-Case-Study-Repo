# Shopping Application

## Overview

The Shopping Application is a Java-based project that provides users with a comprehensive shopping experience. It includes features for browsing products, managing a shopping cart, and placing orders. This application is designed to demonstrate fundamental Java programming practices and provide a user-friendly interface for managing shopping tasks.

## How to Run the Application

### Using an IDE

1. Ensure that all Java files are in the same package within your IDE.
2. Execute the `ShoppingApp.java` file as a Java project to compile and run the application.

### Using Command Line

1. Compile all Java files to generate the necessary class files.
2. Run the main class `ShoppingApp` to start the application. Make sure that all class files have been successfully compiled before running the application.

## Features

### Browsing Products

Users can view a list of available products. Products are stored in a static `ArrayList` and displayed using a formatted output that includes the product name, price, and description. The browsing functionality allows users to see all products in a readable format.

### Adding Items to the Cart

Users can add items to their shopping cart. If an item with a specific product ID already exists in the cart, its quantity will be updated. If the item is not already in the cart, a new entry will be created. This feature helps manage the items users wish to purchase.

### Removing Items from the Cart

Items can be removed from the shopping cart. The system checks if the item exists in the cart and verifies the product ID against the available products. If the item or product is not found, appropriate feedback is provided to the user.

### Placing Orders

Users can place orders for the items in their cart. When an order is placed, it includes details such as the order date, status, and total price. The items from the cart are transferred to the order, and the order is added to the list of orders maintained by the application.

## Exception Handling

The application handles various exceptions to ensure robustness:

1. **ProductNotFoundException**: This exception is thrown when a product with the specified ID cannot be found in the list of products. This ensures that operations requiring the presence of a product are handled correctly.
2. **InputMismatchException**: This exception is thrown when invalid input is provided by the user, such as entering a non-numeric value where a number is expected. This helps in maintaining the integrity of user input.

## Contributing

Contributions to the project are welcome. To contribute, please fork the repository, make your changes, and submit a pull request with a description of the modifications.

## Contact

For any questions or feedback, please contact this github account.
