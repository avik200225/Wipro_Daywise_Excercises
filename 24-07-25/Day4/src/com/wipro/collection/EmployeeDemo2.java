package com.wipro.collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

	public class EmployeeDemo2 {
	    public static void main(String[] args) {

	        Employee e1 = new Employee("E001", "Alice", 30, 50000);
	        Employee e2 = new Employee("E002", "Bob", 28, 75000);
	        Employee e3 = new Employee("E003", "Charlie", 35, 60000);
	        Employee e4 = new Employee("E004", "David", 25, 90000);
	        Employee e5 = new Employee("E005", "Eve", 32, 85000);  

	        CopyOnWriteArrayList<Employee> empList = new CopyOnWriteArrayList<>();
	        empList.add(e1);
	        empList.add(e2);
	        empList.add(e3);
	        empList.add(e4);
	        empList.add(e5);


	        for (Employee emp : empList) {
	            if (emp.getEmpSalary() > 80000) {
	                empList.remove(emp); 
	            }
	        }
	        System.out.println("Employees earning 80,000 or less:");
	        for (Employee emp : empList) {
	            System.out.println(emp);
	        }
	    }
	}

