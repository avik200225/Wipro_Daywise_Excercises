package com.wipro.orderms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CartUpdateRequest {
  @NotNull private Integer userId;
  @NotNull private Integer productId;
  @NotNull @Min(0) private Integer qty;
}
