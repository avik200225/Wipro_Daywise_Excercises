package com.wipro.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeDemo {
    public static void main(String[] args) {
      
        Employee e1 = new Employee("E001", "Alice", 30, 50000);
        Employee e2 = new Employee("E002", "Charlie", 28, 75000);
        Employee e3 = new Employee("E003", "Bob", 35, 60000);
        Employee e4 = new Employee("E004", "Javid", 25, 40000);
        
        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        Comparator<Employee> sortBySalaryDesc = (emp1, emp2) ->
        Double.compare(emp2.getEmpSalary(), emp1.getEmpSalary());
        Collections.sort(empList, sortBySalaryDesc);

        
    System.out.println("Employees sorted by descending salary:");
    for (Employee e : empList) {
        System.out.println(e);   	
        }

    empList.sort((emp1, emp2) -> emp1.getEmpId().compareTo(emp2.getEmpId()));
    System.out.println("\nSorted by Employee ID:");
    empList.forEach(System.out::println);

    empList.sort((emp1, emp2) -> emp1.getEmpName().compareToIgnoreCase(emp2.getEmpName()));
    System.out.println("\nSorted by Employee Name:");
    empList.forEach(System.out::println);

    empList.sort((emp1, emp2) -> Integer.compare(emp1.getEmpAge(), emp2.getEmpAge()));
    System.out.println("\nSorted by Employee Age:");
    empList.forEach(System.out::println);
       }
    }
