package com.wipro.orderms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CartAddRequest {
  @NotNull private Integer userId;
  @NotNull @Min(1) private Integer productId;
  @NotNull @Min(1) private Integer qty;
}
