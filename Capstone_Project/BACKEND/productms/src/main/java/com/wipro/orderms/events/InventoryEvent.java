package com.wipro.orderms.events;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class InventoryEvent {
  public enum Type { DEDUCTED, RESTORED, REJECTED }
  private Type type;
  private Integer orderId;
  private Integer userId;
  private String message;
}
