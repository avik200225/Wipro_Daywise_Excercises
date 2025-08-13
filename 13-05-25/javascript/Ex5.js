var x = 10; // global scope variable 
const z = 20; //constant variable

 
function f() {
  x = 9;
  let y = 8; // block scope variable
  console.log("x in function is " + x); //updates the value
  console.log("y in function is " + y);//can be accesed
 
  if (true) {
    let z = 18;
    console.log("y in if block is " + y); // can be accesed
  }
  console.log("z in function is " + z); // z is accessible here as it is a constant
}
f(); // function call

console.log("y outside  function is " + y);// cannot be accesed here since it is block scope variable