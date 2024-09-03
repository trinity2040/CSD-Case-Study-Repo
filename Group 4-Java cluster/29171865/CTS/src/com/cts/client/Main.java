package com.cts.client;

import com.cts.exception.DuplicateAttendanceException;
import com.cts.model.Employee;
import com.cts.model.Attendance;
import com.cts.service.EmployeeService;
import com.cts.service.AttendanceService;
import com.cts.service.impl.EmployeeServiceImpl;
import com.cts.service.impl.AttendanceServiceImpl;
import com.cts.exception.EmployeeNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeService employeeService = new EmployeeServiceImpl();
    private static final AttendanceService attendanceService = new AttendanceServiceImpl();

    public static void main(String[] args) {
        while (true) {
            try {
                displayMenu();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        updateEmployee();
                        break;
                    case 3:
                        deleteEmployee();
                        break;
                    case 4:
                        getEmployeeById();
                        break;
                    case 5:
                        listAllEmployees();
                        break;
                    case 6:
                        addAttendance();
                        break;
                    case 7:
                        updateAttendance();
                        break;
                    case 8:
                        deleteAttendance();
                        break;
                    case 9:
                        getAttendanceById();
                        break;
                    case 10:
                        listAttendancesByEmployeeId();
                        break;
                    case 11:
                        generateMonthlyAttendanceReport();
                        break;
                    case 12:
                        generateDailyAttendanceReport();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. Get Employee By ID");
        System.out.println("5. List All Employees");
        System.out.println("6. Add Attendance");
        System.out.println("7. Update Attendance");
        System.out.println("8. Delete Attendance");
        System.out.println("9. Get Attendance By ID");
        System.out.println("10. List Attendances By Employee ID");
        System.out.println("11. Generate Monthly Attendance Report");
        System.out.println("12. Generate Daily Attendance Report");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addEmployee() {
        System.out.println("\n--- Add Employee ---");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Employee employee = new Employee(0, name, department, email, phoneNumber);
        employeeService.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private static void updateEmployee() {
        System.out.println("\n--- Update Employee ---");
        try {
            System.out.print("Enter employee ID: ");
            int employeeId = Integer.parseInt(scanner.nextLine());

            Employee employee = employeeService.getEmployeeById(employeeId);
            if (employee == null) {
                throw new EmployeeNotFoundException("Employee not found.");
            }

            System.out.print("Enter new name: ");
            employee.setName(scanner.nextLine());
            System.out.print("Enter new department: ");
            employee.setDepartment(scanner.nextLine());
            System.out.print("Enter new email: ");
            employee.setEmail(scanner.nextLine());
            System.out.print("Enter new phone number: ");
            employee.setPhoneNumber(scanner.nextLine());

            employeeService.updateEmployee(employee);
            System.out.println("Employee updated successfully.");
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteEmployee() {
        System.out.println("\n--- Delete Employee ---");
        try {
            System.out.print("Enter employee ID: ");
            int employeeId = Integer.parseInt(scanner.nextLine());

            employeeService.deleteEmployee(employeeId);
            System.out.println("Employee deleted successfully.");
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getEmployeeById() {
        System.out.println("\n--- Get Employee By ID ---");
        try {
            System.out.print("Enter employee ID: ");
            int employeeId = Integer.parseInt(scanner.nextLine());

            Employee employee = employeeService.getEmployeeById(employeeId);
            if (employee == null) {
                throw new EmployeeNotFoundException("Employee not found.");
            }

            System.out.println("\nEmployee Details:");
            System.out.println("ID: " + employee.getEmployeeId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Phone Number: " + employee.getPhoneNumber());
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listAllEmployees() {
        System.out.println("\n--- List All Employees ---");
        List<Employee> employees = employeeService.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.printf("%-10s %-20s %-20s %-30s %-15s%n", "ID", "Name", "Department", "Email", "Phone Number");
            System.out.println("-----------------------------------------------------------------------------------------------------");

            for (Employee employee : employees) {
                System.out.printf("%-10d %-20s %-20s %-30s %-15s%n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getDepartment(),
                        employee.getEmail(),
                        employee.getPhoneNumber());
            }
        }
    }


    private static void addAttendance() throws DuplicateAttendanceException {
        System.out.println("\n--- Add Attendance ---");
        System.out.print("Enter employee ID: ");
        int employeeId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter status (Present/Absent): ");
        String status = scanner.nextLine();

        Attendance attendance = new Attendance(0, employeeId, date, status);
        attendanceService.addAttendance(attendance);
        System.out.println("Attendance added successfully.");
    }



    private static void updateAttendance() {
        System.out.println("\n--- Update Attendance ---");
        System.out.print("Enter attendance ID: ");
        int attendanceId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter employee ID: ");
        int employeeId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter new status (Present/Absent): ");
        String status = scanner.nextLine();

        Attendance attendance = new Attendance(attendanceId, employeeId, date, status);
        attendanceService.updateAttendance(attendance);
        System.out.println("Attendance updated successfully.");
    }

    private static void deleteAttendance() {
        System.out.println("\n--- Delete Attendance ---");
        System.out.print("Enter attendance ID: ");
        int attendanceId = Integer.parseInt(scanner.nextLine());

        attendanceService.deleteAttendance(attendanceId);
        System.out.println("Attendance deleted successfully.");
    }

    private static void getAttendanceById() {
        System.out.println("\n--- Get Attendance By ID ---");
        System.out.print("Enter attendance ID: ");
        int attendanceId = Integer.parseInt(scanner.nextLine());

        Attendance attendance = attendanceService.getAttendanceById(attendanceId);
        if (attendance == null) {
            System.out.println("Attendance not found.");
        } else {
            System.out.println("\nAttendance Details:");
            System.out.println("ID: " + attendance.getAttendanceId());
            System.out.println("Employee ID: " + attendance.getEmployeeId());
            System.out.println("Date: " + attendance.getDate());
            System.out.println("Status: " + attendance.getStatus());
        }
    }

    private static void listAttendancesByEmployeeId() {
        System.out.println("\n--- List Attendances By Employee ID ---");
        System.out.print("Enter employee ID: ");
        int employeeId = Integer.parseInt(scanner.nextLine());

        List<Attendance> attendances = attendanceService.getAttendancesByEmployeeId(employeeId);
        if (attendances.isEmpty()) {
            System.out.println("No attendance records found for this employee.");
        } else {
            for (Attendance attendance : attendances) {
                System.out.println("\nAttendance Details:");
                System.out.println("ID: " + attendance.getAttendanceId());
                System.out.println("Employee ID: " + attendance.getEmployeeId());
                System.out.println("Date: " + attendance.getDate());
                System.out.println("Status: " + attendance.getStatus());
            }
        }
    }
    private static void generateMonthlyAttendanceReport() {
        System.out.println("\n--- Monthly Attendance Report ---");
        System.out.print("Enter employee ID: ");
        int employeeId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter month and year (YYYY-MM): ");
        String monthYear = scanner.nextLine();

        List<Attendance> attendances = attendanceService.getMonthlyAttendanceReport(employeeId, monthYear);
        if (attendances.isEmpty()) {
            System.out.println("No attendance records found for the given period.");
        } else {
            System.out.println("Attendance Report:");
            System.out.printf("%-15s %-15s %-15s %-10s%n", "ID", "Employee ID", "Date", "Status");
            System.out.println("------------------------------------------------------------");
            for (Attendance attendance : attendances) {
                System.out.printf("%-15d %-15d %-15s %-10s%n",
                        attendance.getAttendanceId(),
                        attendance.getEmployeeId(),
                        attendance.getDate(),
                        attendance.getStatus()
                );
            }
        }
    }

    private static void generateDailyAttendanceReport() {
        System.out.println("\n--- Daily Attendance Report ---");

        List<Attendance> attendances = attendanceService.getDailyAttendanceReport();

        if (attendances.isEmpty()) {
            System.out.println("No attendance records found.");
        } else {
            String currentDate = "";
            System.out.printf("%-15s %-15s %-15s %-10s%n", "Attendance ID", "Employee ID", "Date", "Status");
            System.out.println("------------------------------------------------------");

            for (Attendance attendance : attendances) {
                String attendanceDate = attendance.getDate();

                if (!attendanceDate.equals(currentDate)) {
                    if (!currentDate.isEmpty()) {
                        System.out.println("------------------------------------------------------");
                    }
                    System.out.println("Date: " + attendanceDate);
                    currentDate = attendanceDate;
                }

                System.out.printf("%-15d %-15d %-15s %-10s%n",
                        attendance.getAttendanceId(),
                        attendance.getEmployeeId(),
                        attendance.getDate(),
                        attendance.getStatus()
                );
            }
        }
    }

}
