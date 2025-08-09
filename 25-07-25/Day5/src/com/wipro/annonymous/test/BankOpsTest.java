package com.wipro.annonymous.test;
import com.wipro.annonymous.BankOps;

public class BankOpsTest {

	public static void main(String[] args) {
		BankOps savingAcc = new BankOps() {
			@Override
			public void deposit(double amount) {
				System.out.println(amount+ " Depositing in Savings Acc");		
			}
		};		
		BankOps currAcc = new BankOps() {
			public void deposit(double amount) {
				System.out.println(amount+ " Depositing in Current Account");
			}
		};
		savingAcc.deposit(2000.50);
		currAcc.deposit(6000.30);	
	}
}
