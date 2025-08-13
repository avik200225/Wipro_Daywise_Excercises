let persons = [
    { name: "Avik", age: 23, city: "Kolkata" },
    { name: "Ram", age: 17, city: "Chennai" },
    { name: "Rahul", age: 40, city: "Delhi" },
    { name: "Rohan", age: 15, city: "Mumbai" },
    { name: "Raj", age: 30, city: "Hyderabad" }
];

for(let i=0;i<persons.length;i++){
   if (persons[i].age>=18){
    persons[i].status="ADULT";
   }
   else{
    persons[i].status="MINOR";
   }
}

console.log(persons);