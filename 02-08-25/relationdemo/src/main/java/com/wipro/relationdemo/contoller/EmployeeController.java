package com.wipro.relationdemo.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.relationdemo.entity.Department;
import com.wipro.relationdemo.entity.Employee;
import com.wipro.relationdemo.repo.DepartmentRepo;
import com.wipro.relationdemo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentRepo departmentRepository;

    public EmployeeController(EmployeeService employeeService, DepartmentRepo departmentRepository) {
        this.employeeService = employeeService;
        this.departmentRepository = departmentRepository;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        Department dept = employee.getDepartment();

        if (dept != null) {
            if (dept.getId() == null) {
                dept = departmentRepository.save(dept);
            }

            // Set bidirectional reference
            dept.setEmployee(employee);
            employee.setDepartment(dept);
        }

        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
