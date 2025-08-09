package com.wipro.day3;

public class HDFC implements BankOps{

	@Override
	public void deposit(double amount, String accNum) {
		System.out.println("Depositing in hdfc");
	}

	@Override
	public double withdraw(double amount, String accNum) {
		System.out.println("Withdrawing from hdfc");
		return 0;
	}
}
