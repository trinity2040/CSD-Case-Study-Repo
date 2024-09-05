package com.cts.dao;

import com.cts.model.Customer;
import com.cts.util.ConnectDB;

import java.sql.*;

public class CustomerDAO {
    ConnectDB connectDB = new ConnectDB();

    public void addCustomer(Customer customer) throws SQLException {
        String addRoomSql = "INSERT INTO customers (name, email, phone_number) VALUES (?, ?, ?)";

        try(Connection conn = connectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(addRoomSql)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhoneNumber());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("\nCustomer added successfully!");
            } else {
                System.out.println("\nAdd customer failed!");
            }
        }
    } // End of addCustomer method

    public void viewAllCustomers() throws SQLException {
        String viewAllRoomsSql = "SELECT customer_id, name, email, phone_number FROM customers";

        try(Connection conn = connectDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(viewAllRoomsSql)) {
            System.out.println("\nCustomer Details:");
            System.out.println("+-------------+----------------------------+-----------------------------+--------------+");
            System.out.println("| Customer ID | Name                       | Email                       | Phone Number |");
            System.out.println("+-------------+----------------------------+-----------------------------+--------------+");

            while (rset.next()) {
                int customerId = rset.getInt("customer_id");
                String name = rset.getString("name");
                String emailId = rset.getString("email");
                String phoneNumber = rset.getString("phone_number");

                System.out.printf("| %-11d | %-26s | %-27s | %-12s |\n", customerId, name, emailId, phoneNumber);
            }

            System.out.println("+-------------+----------------------------+-----------------------------+--------------+");
        }
    } // End of viewAllCustomers method

    public void viewCustomerDetails(int customerID) throws SQLException {
        String viewRoomsSql = "SELECT customer_id, name, email, phone_number FROM customers WHERE customer_id = " + customerID;

        try(Connection conn = connectDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(viewRoomsSql)) {
            System.out.println("\nCustomer Details:");
            System.out.println("+-------------+----------------------------+-----------------------------+--------------+");
            System.out.println("| Customer ID | Name                       | Email                       | Phone Number |");
            System.out.println("+-------------+----------------------------+-----------------------------+--------------+");

            while (rset.next()) {
                int customerId = rset.getInt("customer_id");
                String name = rset.getString("name");
                String emailId = rset.getString("email");
                String phoneNumber = rset.getString("phone_number");

                System.out.printf("| %-11d | %-26s | %-27s | %-12s |\n", customerId, name, emailId, phoneNumber);
            }

            System.out.println("+-------------+----------------------------+-----------------------------+--------------+");
        }
    } // End of viewCustomerDetails method

    public void updateCustomer(Customer customer, int customerId) throws SQLException {
        String addRoomSql = "UPDATE customers SET name = ?, email = ?, phone_number = ? WHERE customer_id = " + customerId;

        try(Connection conn = connectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(addRoomSql)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhoneNumber());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("\nCustomer details updated successfully!");
            } else {
                System.out.println("\nUpdating customer details failed!");
            }
        }
    } // End of updateCustomer method

    public void deleteCustomer(int customerId) throws SQLException {
        String deleteRoomSql = "DELETE FROM customers WHERE customer_id = " + customerId;

        try(Connection conn = connectDB.getConnection();
            Statement stmt = conn.createStatement()) {

            int affectedRows = stmt.executeUpdate(deleteRoomSql);

            if (affectedRows > 0) {
                System.out.println("\nCustomer removed Successfully!");
            } else {
                System.out.println("\nRemoving customer failed!");
            }
        }
    } // End of deleteCustomer method
}