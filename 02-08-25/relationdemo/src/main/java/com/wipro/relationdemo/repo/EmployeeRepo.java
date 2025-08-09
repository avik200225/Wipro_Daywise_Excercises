package com.wipro.relationdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.relationdemo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
}