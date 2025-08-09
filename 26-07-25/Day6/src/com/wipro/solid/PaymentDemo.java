package com.wipro.solid;

public class PaymentDemo {
	public static void main(String[] args) {
		Payment gpay = new Gpay();
        Payment phonePe = new Phonepe();
        Payment paytm = new Paytm();

        PaymentProcessor processor1 = new PaymentProcessor(gpay);
        processor1.processPayment(500);

        PaymentProcessor processor2 = new PaymentProcessor(phonePe);
        processor2.processPayment(1000);

        PaymentProcessor processor3 = new PaymentProcessor(paytm);
        processor3.processPayment(750);		
	}
}