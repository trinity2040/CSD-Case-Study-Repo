package com.cts.service;


import com.cts.model.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();
}

