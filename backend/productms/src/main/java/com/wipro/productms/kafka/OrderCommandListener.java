//package com.wipro.productms.kafka;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//import com.wipro.orderms.events.InventoryEvent;
//import com.wipro.orderms.events.OrderCommand;
//import com.wipro.productms.repo.ProductRepo;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class OrderCommandListener {
//private final ProductRepo repo;
//private final KafkaTemplate<String,Object> kafka;
//
//@KafkaListener(topics = "order.commands", groupId = "productms-group")
//public void onCommand(OrderCommand cmd) {
// boolean ok = true;
// if (cmd.getType() == OrderCommand.Type.DEDUCT) {
//   for (var e : cmd.getProductQuantityMap().entrySet()) {
//     var p = repo.findById(e.getKey().longValue()).orElse(null);
//     if (p == null || p.getProductAvailableQty() < e.getValue()) { ok = false; break; }
//   }
//   if (ok) {
//     for (var e : cmd.getProductQuantityMap().entrySet()) {
//       var p = repo.findById(e.getKey().longValue()).orElse(null);
//       if (p!=null) { p.setProductAvailableQty(p.getProductAvailableQty()-e.getValue()); repo.save(p); }
//     }
//     kafka.send("inventory.events", cmd.getOrderId().toString(),
//         InventoryEvent.builder().type(InventoryEvent.Type.DEDUCTED)
//             .orderId(cmd.getOrderId()).userId(cmd.getUserId()).build());
//   } else {
//     kafka.send("inventory.events", cmd.getOrderId().toString(),
//         InventoryEvent.builder().type(InventoryEvent.Type.REJECTED)
//             .orderId(cmd.getOrderId()).userId(cmd.getUserId())
//             .message("Insufficient stock").build());
//   }
// } else if (cmd.getType() == OrderCommand.Type.RESTORE) {
//   for (var e : cmd.getProductQuantityMap().entrySet()) {
//     var p = repo.findById(e.getKey().longValue()).orElse(null);
//     if (p!=null) { p.setProductAvailableQty(p.getProductAvailableQty()+e.getValue()); repo.save(p); }
//   }
//   kafka.send("inventory.events", cmd.getOrderId().toString(),
//       InventoryEvent.builder().type(InventoryEvent.Type.RESTORED)
//           .orderId(cmd.getOrderId()).userId(cmd.getUserId()).build());
// }
//}
//}
