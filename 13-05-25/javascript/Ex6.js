let names=["Avik","Jayanta","Rahul","Chandra"];
let longNamesUppercase = names.filter((x)=>x.length>5)
                    .map(name => name.toUpperCase());
console.log(longNamesUppercase);


