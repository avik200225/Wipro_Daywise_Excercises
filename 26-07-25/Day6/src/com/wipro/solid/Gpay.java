package com.wipro.solid;

public class Gpay implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Google Pay.");
    }
}
