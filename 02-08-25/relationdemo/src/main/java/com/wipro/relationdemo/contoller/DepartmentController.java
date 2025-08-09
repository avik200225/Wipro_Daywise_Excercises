package com.wipro.relationdemo.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.relationdemo.entity.Department;
import com.wipro.relationdemo.repo.DepartmentRepo;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentRepo departmentRepository;

    public DepartmentController(DepartmentRepo departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentRepository.findById(id).orElse(null);
    }
}