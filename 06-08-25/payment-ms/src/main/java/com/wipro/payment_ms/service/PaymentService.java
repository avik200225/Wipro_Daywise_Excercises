package com.wipro.payment_ms.service;
import java.util.List;
import com.wipro.payment_ms.entity.Payment;

public interface PaymentService {
	void save(Payment payment);
	List<Payment> findAll();
}



//public interface PaymentService {
//    Payment createPayment(Payment payment);
//    Payment getPaymentById(Long id);
//    List<Payment> getAllPayments();
//    Payment updatePayment(Long id, Payment payment);
//    void deletePayment(Long id);
//}
