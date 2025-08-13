let persons = [
    { name: "Avik", age: 23, city: "Kolkata" },
    { name: "Ram", age: 17, city: "Chennai" },
    { name: "Rahul", age: 40, city: "Delhi" },
    { name: "Rohan", age: 15, city: "Mumbai" },
    { name: "Raj", age: 30, city: "Hyderabad" }
];

let eligibleVoters = persons.filter(person => person.age >= 18);

console.log(eligibleVoters);