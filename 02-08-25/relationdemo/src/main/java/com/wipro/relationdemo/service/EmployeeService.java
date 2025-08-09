package com.wipro.relationdemo.service;

import java.util.List;

import com.wipro.relationdemo.entity.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
}
