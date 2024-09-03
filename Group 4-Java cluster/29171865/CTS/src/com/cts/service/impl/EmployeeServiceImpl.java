package com.cts.service.impl;


import com.cts.dao.EmployeeDAO;
import com.cts.dao.impl.EmployeeDAOImpl;
import com.cts.model.Employee;
import com.cts.service.EmployeeService;
import com.cts.exception.EmployeeNotFoundException;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {
        this.employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (employeeDAO.getEmployeeById(employee.getEmployeeId()) == null) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + employee.getEmployeeId());
        }
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        if (employeeDAO.getEmployeeById(employeeId) == null) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
        }
        employeeDAO.deleteEmployee(employeeId);
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee employee = employeeDAO.getEmployeeById(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
}

