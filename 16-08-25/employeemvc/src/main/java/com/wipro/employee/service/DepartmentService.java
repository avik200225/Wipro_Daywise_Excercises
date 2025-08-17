package com.wipro.employee.service;

import com.wipro.employee.entity.Department;
import com.wipro.employee.repo.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public Department save(Department dept) {
        return repo.save(dept);
    }

    public List<Department> getAll() {
        return repo.findAll();
    }

    public Department getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}