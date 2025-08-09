package com.wipro.payment_ms.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.payment_ms.entity.Payment;
import com.wipro.payment_ms.service.PaymentService;
import com.wipro.payment_ms.entity.Payment;
import com.wipro.payment_ms.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping
	void save(@RequestBody Payment payment)
	{
		paymentService.save(payment);	
	}

	@GetMapping
	List<Payment> findAll()
	{
		return paymentService.findAll();
	}
	
}


//@RestController
//@RequestMapping("/api/payments")
//public class PaymentController {
//    private final PaymentService paymentService;
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
//        Payment createdPayment = paymentService.createPayment(payment);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("created-date", LocalDate.now().toString());  
//        return new ResponseEntity<>(createdPayment, headers, HttpStatus.CREATED);  // 201
//    }
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
//        paymentService.updatePayment(id, payment);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("modified-date", LocalDate.now().toString());  
//        return new ResponseEntity<>("Data modified successfully", headers, HttpStatus.OK);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
//        paymentService.deletePayment(id);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("deleted-date", LocalDate.now().toString());  
//        return new ResponseEntity<>("Data deleted successfully", headers, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
//        try {
//            Payment payment = paymentService.getPaymentById(id);
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("search-date", LocalDate.now().toString());
//            return new ResponseEntity<>(payment, headers, HttpStatus.OK);
//
//        } catch (RuntimeException e) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("search-date", LocalDate.now().toString());
//            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Payment>> getAllPayments() {
//        List<Payment> payments = paymentService.getAllPayments();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("search-date", LocalDate.now().toString());
//
//        if (payments.isEmpty()) {
//            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(payments, headers, HttpStatus.OK);
//    }
//}


