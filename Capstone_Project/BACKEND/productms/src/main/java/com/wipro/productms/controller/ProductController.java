package com.wipro.productms.controller;

import com.wipro.productms.entity.Product;
import com.wipro.productms.service.ProductService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {

    private final ProductService productservice;

    public ProductController(ProductService productservice) {
        this.productservice = productservice;
    }

    @GetMapping
    public List<Product> getAll() {
        return productservice.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productservice.findById(id);
    }

    @PostMapping
    public Product create(@Valid @RequestBody Product p) {
        return productservice.create(p);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p) {
        return productservice.update(id, p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productservice.delete(id);
    }

    @GetMapping("/search")
    public Page<Product> search(
            @RequestParam(defaultValue = "name") String field,
            @RequestParam(defaultValue = "") String q,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(Math.max(page, 0), Math.max(size, 1));
        return productservice.search(field, q, pageable);
    }
}

