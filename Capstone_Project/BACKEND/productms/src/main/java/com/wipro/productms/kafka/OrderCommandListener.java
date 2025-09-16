package com.wipro.productms.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.wipro.orderms.events.InventoryEvent;
import com.wipro.orderms.events.OrderCommand;
import com.wipro.orderms.events.Topics;
import com.wipro.productms.repo.ProductRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderCommandListener {
  private final ProductRepo repo;
  private final KafkaTemplate<String,Object> kafka;

  @KafkaListener(topics = Topics.T1_ORDER_COMMANDS, groupId = "productms-group")
  public void onCommand(OrderCommand cmd) {
    if (cmd.getType() == OrderCommand.Type.DEDUCT) {

      boolean allOk = cmd.getProductQuantityMap().entrySet().stream().allMatch(e ->
          repo.findById(e.getKey().longValue())
              .map(p -> p.getProductAvailableQty() != null && p.getProductAvailableQty() >= e.getValue())
              .orElse(false));

      if (allOk) {

        cmd.getProductQuantityMap().forEach((pid, q) ->
          repo.findById(pid.longValue()).ifPresent(p -> {
            p.setProductAvailableQty(p.getProductAvailableQty() - q);
            repo.save(p);
          })
        );
        kafka.send(Topics.T2_INVENTORY_EVENTS, String.valueOf(cmd.getOrderId()),
            InventoryEvent.builder().type(InventoryEvent.Type.DEDUCTED)
              .orderId(cmd.getOrderId()).userId(cmd.getUserId()).message("Stock deducted").build());
      } else {
        kafka.send(Topics.T2_INVENTORY_EVENTS, String.valueOf(cmd.getOrderId()),
            InventoryEvent.builder().type(InventoryEvent.Type.REJECTED)
              .orderId(cmd.getOrderId()).userId(cmd.getUserId()).message("Insufficient stock").build());
      }
    } else if (cmd.getType() == OrderCommand.Type.RESTORE) {
      cmd.getProductQuantityMap().forEach((pid, q) ->
        repo.findById(pid.longValue()).ifPresent(p -> {
          p.setProductAvailableQty(p.getProductAvailableQty() + q);
          repo.save(p);
        })
      );
      kafka.send(Topics.T2_INVENTORY_EVENTS, String.valueOf(cmd.getOrderId()),
          InventoryEvent.builder().type(InventoryEvent.Type.RESTORED)
            .orderId(cmd.getOrderId()).userId(cmd.getUserId()).message("Stock restored").build());
    }
  }
}
