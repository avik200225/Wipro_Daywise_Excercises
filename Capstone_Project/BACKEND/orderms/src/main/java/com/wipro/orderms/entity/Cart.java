//package com.wipro.orderms.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//import java.util.*;
//
//@Entity
//@Getter @Setter
//@NoArgsConstructor @AllArgsConstructor @Builder
//public class Cart {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Integer id;
//
//  @Column(nullable = false, unique = true)
//  private Integer userId;
//
//  // productId (Long) -> qty
//  @ElementCollection
//  @CollectionTable(name = "cart_items", joinColumns = @JoinColumn(name = "cart_id"))
//  @MapKeyColumn(name = "product_id")
//  @Column(name = "qty")
//  private Map<Long, Integer> prodDetails = new HashMap<>();
//
//  private Integer totalQty = 0;
//  private Double totalPrice = 0.0; // OK to keep Double; totals are computed with BigDecimal then converted
//}
//

package com.wipro.orderms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;
    
    @Column(name = "product_id", nullable = false)
    private Long productId;
    
    @Column(nullable = false)
    private Integer quantity;
    
    @Column(nullable = false)
    private Double price;
    
    @Column(name = "product_name", nullable = false)
    private String productName;


}
