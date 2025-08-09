package com.wipro.day3;

public interface BankOps {
	void deposit(double amount, String accNum); //abstract methods
	double withdraw(double amount, String accNum);
}
