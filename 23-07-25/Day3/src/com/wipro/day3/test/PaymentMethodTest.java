package com.wipro.day3.test;

import com.wipro.day3.Gpay;
import com.wipro.day3.PaymentMethod;

public class PaymentMethodTest {
	public static void main(String args[]) {
	PaymentMethod p = new Gpay();
	p.pay(20.50);
}
}
