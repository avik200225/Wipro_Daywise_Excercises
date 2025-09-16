package com.wipro.orderms.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductDTO {
  private Integer productId;
  private String productName;
  private Double productPrice;
  private Integer productAvailableQty;
  private String productImgUrl;
}

