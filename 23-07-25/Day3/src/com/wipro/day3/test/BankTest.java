package com.wipro.day3.test;

import com.wipro.day3.Citi;
import com.wipro.day3.HDFC;

public class BankTest {

	public static void main(String[] args) {
		HDFC h = new HDFC();
		h.deposit(1000, "HDFC4563214");
		h.withdraw(5000, "HDFC4563214");
		
		Citi c = new Citi();
		c.deposit(10000,"CITI4569823");
		c.withdraw(2000,"CITI4569823");
	
	}
}
