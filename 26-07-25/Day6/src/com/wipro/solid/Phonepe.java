package com.wipro.solid;

public class Phonepe implements Payment {
	 public void pay(double amount) {
	        System.out.println("Paid ₹" + amount + " using PhonePe.");
	    }
}
