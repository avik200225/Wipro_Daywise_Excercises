package com.wipro.day3;

public class Citi implements BankOps{

	@Override
	public void deposit(double amount, String accNum) {
		System.out.println("Depositing in citi");
	}

	@Override
	public double withdraw(double amount, String accNum) {
		System.out.println("Withdrawing from citi");
		return 0;
	}
}
