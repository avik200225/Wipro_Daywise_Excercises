package com.wipro.orderms.service.impl;

import com.wipro.orderms.client.ProductClient;
import com.wipro.orderms.dto.OrderCreateRequest;
import com.wipro.orderms.dto.ProductDTO;
import com.wipro.orderms.entity.Cart;
import com.wipro.orderms.entity.Order;
import com.wipro.orderms.entity.OrderStatus;
import com.wipro.orderms.events.OrderCommand;
import com.wipro.orderms.events.Topics;
import com.wipro.orderms.repo.CartRepo;
import com.wipro.orderms.repo.OrderRepo;
import com.wipro.orderms.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final CartRepo cartRepo;
  private final OrderRepo orderRepo;
  private final ProductClient productClient;
  private final KafkaTemplate<String,Object> kafka;

  @Override @Transactional
  public Order create(OrderCreateRequest req) {
    Cart cart = cartRepo.findByUserId(req.getUserId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cart not found"));

    if (cart.getProdDetails()==null || cart.getProdDetails().isEmpty())
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cart is empty");

     int tq = 0; double tp = 0.0;
    Map<Integer,Integer> items = new HashMap<>(cart.getProdDetails());
    for (var e : items.entrySet()) {
      ProductDTO p = productClient.getById(e.getKey());
      double price = p.getProductPrice()==null?0.0:p.getProductPrice();
      tq += e.getValue();
      tp += price * e.getValue();
    }

    Order ord = Order.builder()
        .userId(req.getUserId())
        .productQuantityMap(items)
        .totalQty(tq)
        .totalPrice(tp)
        .orderStatus(OrderStatus.PENDING)
        .build();
    orderRepo.save(ord);

    OrderCommand cmd = OrderCommand.builder()
        .type(OrderCommand.Type.DEDUCT)
        .orderId(ord.getOrderId())
        .userId(ord.getUserId())
        .productQuantityMap(ord.getProductQuantityMap())
        .build();
    kafka.send(Topics.T1_ORDER_COMMANDS, String.valueOf(ord.getOrderId()), cmd);

    cart.getProdDetails().clear();
    cart.setTotalQty(0); cart.setTotalPrice(0.0);
    cartRepo.save(cart);

    return ord;
  }

  @Override @Transactional
  public Order cancel(Integer orderId, Integer userId) {
    Order ord = orderRepo.findById(orderId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    if (!ord.getUserId().equals(userId))
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not your order");

    OrderCommand cmd = OrderCommand.builder()
        .type(OrderCommand.Type.RESTORE)
        .orderId(ord.getOrderId())
        .userId(userId)
        .productQuantityMap(ord.getProductQuantityMap())
        .build();
    kafka.send(Topics.T1_ORDER_COMMANDS, String.valueOf(ord.getOrderId()), cmd);

    return ord;
  }

  @Override public List<Order> listAll() { return orderRepo.findAll(); }
  @Override public List<Order> listByUser(Integer userId) { return orderRepo.findByUserId(userId); }
  @Override public Order details(Integer orderId) {
    return orderRepo.findById(orderId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
  }
}
