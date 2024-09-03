# Library Management System

The Library Management System is a console-based Java application that allows librarians to manage book records and library members efficiently. It utilizes object-oriented programming principles and Java Collections for managing book and member data, with features such as searching for books, checking out and returning books, fine calculation, and generating reports of popular books.

# How to Run the Application

### Prerequisites:
1. Ensure that Java Development Kit (JDK) is installed on your system.
2. Use any Java IDE (e.g., Eclipse, IntelliJ IDEA, NetBeans) or a basic text editor and command line.
Steps to Run:
Compile the Java Program:

### Steps to Run:

1. ## Compile the Java Program: <br>

    (i). Open any terminal or command prompt.<br>
   (ii). Navigate to the directory where the source code is saved.<br>
   (iii). Compile the Java program using the following command: <br><br>
             javac LibraryManagementSystem.java

2. ## Run the program: <br>

    java LibraryManagementSystem

3. ### The application will start, and you will see a text-based menu to choose options for performing various library management tasks. <br>

  ## Main Menu
  
  Once you run the program, you will see the following menu:

  Library Management System
  1. Search Books
  2. Checkout Book
  3. Return Book
  4. Calculate Fine
  5. Popular Books Report
  6. Exit <br><br>
  Enter your choice:


# Features

1. Search Books
Functionality: This option allows you to search for books by title, author, or category.
How to Use:
After selecting this option, you will be prompted to enter a search keyword.
Enter part or all of the book's title, author's name, or category.
The application will display a list of matching books with details such as ID, Title, Author, Category, and Available Copies.

2. Checkout Book
Functionality: Allows librarians to check out a book for a library member.
How to Use:
Enter the Member ID and Book ID when prompted.
If the book is available, it will be successfully checked out, and the number of available copies will be reduced.
The book will be added to the member’s list of borrowed books.

3. Return Book
Functionality: Allows librarians to return a book borrowed by a member.
How to Use:
Enter the Member ID and Book ID when prompted.
The book will be marked as returned, and the number of available copies will increase.
The book will be removed from the member’s list of borrowed books.

4. Calculate Fine
Functionality: Calculates and displays the overdue fine for a library member.
How to Use:
Enter the Member ID when prompted.
The fine is calculated based on the number of books the member has borrowed. For this simple example, each borrowed book incurs a ₹200/- fine.
The total fine will be displayed, and the fine will be added to the member's account.

5. Popular Books Report
Functionality: Generates a report of the most borrowed books in the library.
How to Use:
This option will display a sorted list of books based on how many times they have been borrowed.
The report lists the title of the book and the number of times it has been borrowed.

#  Exception Handling

Exception handling is implemented in various parts of the application to ensure smooth operation and proper error handling. Below is an explanation of the key exception handling mechanisms:

1. Handling No Available Copies for Checkout
Location: Book.borrowBook() method.
Purpose: Ensures that a book cannot be checked out if there are no available copies.
Implementation:
When a member attempts to check out a book with no available copies, an IllegalStateException is thrown with the message: "No copies available for borrowing."

2. Invalid Member or Book ID
Location: LibraryManager.checkoutBook() and LibraryManager.returnBook() methods.
Purpose: Ensures that invalid member or book IDs are handled gracefully.
Implementation:
Before attempting to check out or return a book, the application checks if the provided Member ID and Book ID are valid.
If the IDs are invalid, a message is displayed: "Invalid member or book ID."

3. Invalid Return Request
Location: LibraryManager.returnBook() method.
Purpose: Ensures that a book can only be returned if it has been previously borrowed by the member.
Implementation:
Before processing the return, the application checks if the book is currently borrowed by the member.
If not, an error message is displayed: "Invalid return request."

4. Input Handling in the Main Menu
Location: LibraryManagementSystem.main() method.
Purpose: Ensures that invalid inputs in the main menu (such as non-integer values) do not crash the program.
Implementation:
The program prompts the user to enter an integer. If the input is invalid, the program will show "Invalid choice." and prompt the user again.

# Application of Object-Oriented Principles

1. Encapsulation
Encapsulation is achieved by using private fields in the Book and LibraryMember classes, which are accessed and modified only through public getter and setter methods.
This encapsulates the internal state of objects and allows controlled access and modifications.

2. Abstraction
Abstraction is used to hide the internal complexity and expose only the relevant functionality to the user. For example, methods like checkoutBook, returnBook, and calculateFine in the LibraryManager class abstract away the underlying details of how these operations are performed.

3. Inheritance
Although inheritance is not explicitly demonstrated in this small-scale design, the system could be extended to include it. For example, a SpecialBook class could inherit from the Book class to include additional fields or behaviors (e.g., rare books that have special checkout policies).

4. Polymorphism
Polymorphism is demonstrated in the way the same action (such as displaying details of books and members) is handled differently. The toString() method is overridden in both Book and LibraryMember classes to provide customized string representations when printing objects.
