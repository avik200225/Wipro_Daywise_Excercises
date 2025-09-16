package com.wipro.orderms.service;

import com.wipro.orderms.dto.OrderCreateRequest;
import com.wipro.orderms.entity.Order;

import java.util.List;

public interface OrderService {
  Order create(OrderCreateRequest req);
  Order cancel(Integer orderId, Integer userId);
  List<Order> listAll();
  List<Order> listByUser(Integer userId);
  Order details(Integer orderId);
}
