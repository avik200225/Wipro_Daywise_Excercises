function pair<T, U>(first: T, second: U): [T, U] {
    return [first, second];
}

const numberStringPair = pair<string, number >("HELLO", 100);
console.log(numberStringPair); 

