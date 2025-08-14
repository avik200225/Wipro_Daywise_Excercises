class BankAccount {
    constructor(accountNumber, balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    deposit(amount) {
            this.balance += amount;
            console.log(`Deposited ₹${amount}. Current Available balance is: ₹${this.balance}`);
        } 

    withdraw(amount) {
            if (amount <= this.balance) {
                this.balance -= amount;
                console.log(`Withdrawn ₹${amount}. Remaining balance is: ₹${this.balance}`);
            } else {
                console.log("Insufficient balance.");
            }
        } 
}


const myAccount = new BankAccount("INDB154862", 20000);
myAccount.deposit(2000);   
myAccount.withdraw(100000);  
myAccount.withdraw(6000);  
