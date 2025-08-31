package com.wipro.productms.entity;

import jakarta.persistence.GenerationType;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank
    @Column(nullable = false, length = 120)
    private String productName;

    @NotBlank
    @Column(nullable = false, length = 80)
    private String productCat;

    @Column(length = 1000)
    private String productDesc;

    @Column(length = 80)
    private String make;

    @Min(0)
    private Integer productAvailableQty;

    @DecimalMin(value = "0.0", inclusive = true)
    @Column(precision = 12, scale = 2)
    private BigDecimal productPrice;

    private String productImgUrl;

    private LocalDate dateOfManufacture;


    public Long getProductId() {
    	return productId; 
    	}
    public void setProductId(Long productId) { 
    	this.productId = productId; 
    	}
    public String getProductName() { 
    	return productName;
    	}
    public void setProductName(String productName) {
    	this.productName = productName; 
    	}
    public String getProductCat() {
    	return productCat;
    	}
    public void setProductCat(String productCat) { 
    	this.productCat = productCat;
    	}
    public String getProductDesc() { 
    	return productDesc; 
    	}
    public void setProductDesc(String productDesc) {
    	this.productDesc = productDesc; 
    	}
    public String getMake() {
    	return make; 
    	}
    public void setMake(String make) {
    	this.make = make; 
    	}
    public Integer getProductAvailableQty() {
    	return productAvailableQty;
    	}
    public void setProductAvailableQty(Integer productAvailableQty) { 
    	this.productAvailableQty = productAvailableQty; 
    	}
    public BigDecimal getProductPrice() { 
    	return productPrice;
    	}
    public void setProductPrice(BigDecimal productPrice) {
    	this.productPrice = productPrice; 
    	}
    public String getProductImgUrl() {
    	return productImgUrl; 
    	}
    public void setProductImgUrl(String productImgUrl) {
    	this.productImgUrl = productImgUrl;
    	}
    public LocalDate getDateOfManufacture() { 
    	return dateOfManufacture; 
    	}
    public void setDateOfManufacture(LocalDate dateOfManufacture) { 
    	this.dateOfManufacture = dateOfManufacture; 
    	}
}
