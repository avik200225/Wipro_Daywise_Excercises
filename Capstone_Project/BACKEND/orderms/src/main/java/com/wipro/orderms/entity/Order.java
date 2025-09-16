package com.wipro.orderms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "orders")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Order {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderId;

  private Integer userId;

  @ElementCollection
  @CollectionTable(name="order_items", joinColumns=@JoinColumn(name="order_id"))
  @MapKeyColumn(name="product_id")
  @Column(name="qty")
  private Map<Integer,Integer> productQuantityMap = new HashMap<>();

  private Integer totalQty = 0;
  private Double totalPrice = 0.0;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus = OrderStatus.PENDING;

  private Instant placedAt = Instant.now();
}
