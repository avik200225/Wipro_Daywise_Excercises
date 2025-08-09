package com.wipro.methodref;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Employee {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
	public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 25, 40000),
                new Employee("Alice", 35, 60000),
                new Employee("Bob", 40, 70000),
                new Employee("Charlie", 20, 30000),
                new Employee("David", 38, 55000)
            );
        OptionalDouble averageSalary = employees.stream()
                .filter(e -> e.age > 30 && e.salary > 50000)
                .mapToDouble(e -> e.salary)
                .average();

            if (averageSalary.isPresent()) {
                System.out.println("Average Salary: " + String.format("%.2f", averageSalary.getAsDouble()));
            } else {
                System.out.println("No employees");
            }
	}
}
