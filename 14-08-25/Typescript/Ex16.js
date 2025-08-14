function printEmployees(employees) {
    console.log("Employee List:");
    employees.forEach(function (emp) {
        console.log("ID: ".concat(emp.empId, ", Name: ").concat(emp.empName, ", Salary: ").concat(emp.salary));
    });
    return employees.length;
}
var empList = [
    { empId: 1, empName: "Avik", salary: 50000 },
    { empId: 2, empName: "Rohan", salary: 60000 },
    { empId: 3, empName: "Harry", salary: 55000 }
];
var count = printEmployees(empList);
console.log("Total Employees: ".concat(count));
