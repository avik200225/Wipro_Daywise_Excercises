let persons = [
    { name: "Avik", age: 23, city: "Kolkata" },
    { name: "Ram", age: 17, city: "Chennai" },
    { name: "Rahul", age: 40, city: "Delhi" },
    { name: "Rohan", age: 15, city: "Mumbai" },
    { name: "Raj", age: 30, city: "Hyderabad" }
];
persons.map(p => {
    if (p.age >= 18) {
        p.status = "ADULT";
    } else {
        p.status = "MINOR";
    }
});

console.log(persons);