package com.wipro.productms.service;

import com.wipro.productms.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product create(Product p);
    Product update(Long id, Product p);
    void delete(Long id);
    Page<Product> search(String field, String query, Pageable pageable);
}

