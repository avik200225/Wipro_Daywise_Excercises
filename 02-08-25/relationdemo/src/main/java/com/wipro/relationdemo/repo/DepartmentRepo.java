package com.wipro.relationdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.relationdemo.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
	
}