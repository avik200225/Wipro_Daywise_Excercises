package com.wipro.employee.controller;

import com.wipro.employee.entity.Employee;
import com.wipro.employee.service.EmployeeService;
import com.wipro.employee.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService empService;
    private final DepartmentService deptService;

    public EmployeeController(EmployeeService empService, DepartmentService deptService) {
        this.empService = empService;
        this.deptService = deptService;
    }

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", empService.getAll());
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", deptService.getAll());
        return "employees";
    }

    @PostMapping
    public String addEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employees", empService.getAll());
            model.addAttribute("departments", deptService.getAll());
            return "employees";
        }
        empService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", empService.getById(id));
        model.addAttribute("departments", deptService.getAll());
        return "edit-employee";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("departments", deptService.getAll());
            return "edit-employee";
        }
        employee.setId(id);
        empService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        empService.delete(id);
        return "redirect:/employees";
    }
}
