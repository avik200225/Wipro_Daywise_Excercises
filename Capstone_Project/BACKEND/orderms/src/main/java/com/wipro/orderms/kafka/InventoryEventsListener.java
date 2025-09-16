package com.wipro.orderms.kafka;

import com.wipro.orderms.entity.OrderStatus;
import com.wipro.orderms.events.InventoryEvent;
import com.wipro.orderms.events.Topics;
import com.wipro.orderms.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryEventsListener {
  private final OrderRepo orderRepo;

  @KafkaListener(topics = Topics.T2_INVENTORY_EVENTS, groupId = "orderms-group")
  public void onEvent(InventoryEvent evt) {
    orderRepo.findById(evt.getOrderId()).ifPresent(order -> {
      switch (evt.getType()) {
        case DEDUCTED -> order.setOrderStatus(OrderStatus.COMPLETED);
        case RESTORED, REJECTED -> order.setOrderStatus(OrderStatus.CANCELLED);
      }
      orderRepo.save(order);
    });
  }
}
