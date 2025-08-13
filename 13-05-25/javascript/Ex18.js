function calculate(operation) {
    let n1 = parseFloat(document.getElementById("num1").value);
    let n2 = parseFloat(document.getElementById("num2").value);
    let result;

    if (isNaN(n1) || isNaN(n2)) {
        result = "Please enter both numbers!";
    } else {
        if (operation === '+') result = n1 + n2;
        else if (operation === '-') result = n1 - n2;
        else if (operation === '*') result = n1 * n2;
        else if (operation === '/') {
            result = (n2 !== 0) ? (n1 / n2) : "Cannot divide by zero!";
        }
    }

    document.getElementById("result").innerText = "Result: " + result;
}
