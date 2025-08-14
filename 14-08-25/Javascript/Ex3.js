class Util {
    getDate() {
        const today = new Date();
        const dd = today.getDate();
        const mm = today.getMonth() + 1;
        const yyyy = today.getFullYear();
        return `${dd}-${mm}-${yyyy}`;
    }

    getPIValue() {
        return Math.PI;
    }

    convertC2F(celsius) {
        return (celsius * 9 / 5) + 32;
    }

    getFibonacci(n) {
        const fib = [0, 1];
        for (let i = 2; i < n; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }
        return fib;
    }
}

const util = new Util();

console.log("Today's Date:", util.getDate()); 
console.log("PI Value:", util.getPIValue());  
console.log("25 C in Fahrenheit:", util.convertC2F(25)); 
console.log("First 5 Fibonacci Numbers:", util.getFibonacci(5)); 
