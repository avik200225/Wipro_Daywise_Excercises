const employees = [
    { name: "Avik", role: "Manager", empId: 101, salary: 80000 },
    { name: "Rahul", role: "QA", empId: 102, salary: 50000 },
    { name: "Akash", role: "Manager", empId: 103, salary: 40000 },
    { name: "Ram", role: "QA", empId: 104, salary: 30000 },
    { name: "Jack", role: "Developer", empId: 105, salary: 62000 }
];

const totalManagerSalary = employees
    .filter(emp => emp.role == "Manager")
    .reduce((total, emp) => total + emp.salary, 0);

console.log("Total salary of all Managers is:", totalManagerSalary);