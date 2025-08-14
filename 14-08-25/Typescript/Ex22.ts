class Stack<T> {
    private items: T[] = [];

    push(item: T): void {
        this.items.push(item);
    }

    pop(): T | undefined {
        return this.items.pop();
    }

    peek(): T | undefined {
        return this.items[this.items.length - 1];
    }
}

const numberStack = new Stack<number>();
numberStack.push(40);
numberStack.push(50);

console.log(numberStack.peek());
console.log(numberStack.pop()); 
console.log(numberStack.pop()); 
console.log(numberStack.pop());  
