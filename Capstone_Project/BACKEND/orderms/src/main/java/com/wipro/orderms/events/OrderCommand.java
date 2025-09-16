package com.wipro.orderms.events;

import lombok.*;
import java.util.Map;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderCommand {
  public enum Type { DEDUCT, RESTORE }  // send to Product-MS
  private Type type;
  private Integer orderId;
  private Integer userId;
  private Map<Integer,Integer> productQuantityMap; // productId -> qty
}
