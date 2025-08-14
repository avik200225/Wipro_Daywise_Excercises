interface Employee {
    empId: number;
    empName: string;
    salary: number;
}

function printEmployees(employees: Employee[]): number {
    console.log("Employee List:");
    employees.forEach(emp => {
        console.log(`ID: ${emp.empId}, Name: ${emp.empName}, Salary: ${emp.salary}`);
    });
    return employees.length;
}

let empList: Employee[] = [
    { empId: 1,
     empName: "Avik",
      salary: 50000 
    },
    { empId: 2, 
    empName: "Rohan",
     salary: 60000 
    },
    { empId: 3,
     empName: "Harry",
      salary: 55000 }
];

let count = printEmployees(empList);
console.log(`Total Employees: ${count}`);
