package com.wipro.productmgmtv2.service;


import java.util.List;
import java.util.Optional;

import com.wipro.productmgmtv2.entity.Order;
import com.wipro.productmgmtv2.entity.Product;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Integer id);

    Product save(Product product);

    void deleteById(Integer id);

    Product purchaseProduct(Integer id, Integer quantity);

    List<Order> getOrderHistory();
}
