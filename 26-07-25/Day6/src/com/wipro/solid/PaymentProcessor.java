package com.wipro.solid;

class PaymentProcessor {
 private Payment paymentGateway;

 public PaymentProcessor(Payment paymentGateway) {
     this.paymentGateway = paymentGateway;
 }

 public void processPayment(double amount) {
     paymentGateway.pay(amount);
 }
}
