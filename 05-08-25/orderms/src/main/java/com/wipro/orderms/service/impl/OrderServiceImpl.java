package com.wipro.orderms.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.wipro.orderms.dto.Payment;
import com.wipro.orderms.entity.Order;
import com.wipro.orderms.repo.OrderRepository;
import com.wipro.orderms.service.OrderService;
import com.wipro.orderms.service.PaymentConnectService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    PaymentConnectService paymentConnectService;

    @Override
    @CircuitBreaker(name = "order-cb", fallbackMethod = "handleFallBack")
    public void save(Order order) {
        order.setOrderStatus("I");
        order = orderRepo.save(order);  // Save and get generated ID + orderNumber

        Payment payment = new Payment();
        payment.setOrderId(order.getOrderNumber());  // <-- Pass order_number as orderId
        payment.setPaymentAmount(order.getOrderValue());
        payment.setPaymentStatus(true);

        try {
            ResponseEntity<Payment> response = paymentConnectService.savePaymentData(payment);

            if (response.getStatusCode() == HttpStatusCode.valueOf(200)) {
                order.setOrderStatus("P");
            } else {
                order.setOrderStatus("C");
            }

        } catch (Exception ex) {
            System.out.println("Exception during payment call: " + ex.getMessage());
            order.setOrderStatus("C");
        }

        orderRepo.save(order);  // Update status
    }


    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    public void handleFallBack(Order order, Throwable t) {
        System.out.println("--Fallback: System is down--");
        order.setOrderStatus("C");
        orderRepo.save(order);
    }
}
