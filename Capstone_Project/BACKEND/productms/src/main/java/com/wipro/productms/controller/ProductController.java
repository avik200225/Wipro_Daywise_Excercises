package com.wipro.productms.controller;

import com.wipro.productms.entity.Product;
import com.wipro.productms.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productservice;

  @PostMapping
  public Product create(@Valid @RequestBody Product p) {
    return productservice.create(p);
  }

  @PutMapping
  public Product update(@RequestParam Long id, @Valid @RequestBody Product p) {
    return productservice.update(id, p);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    productservice.delete(id);
  }

  @GetMapping
  public List<Product> list() {
    return productservice.findAll();
  }

  @GetMapping("/{id}")
  public Product detail(@PathVariable Long id) {
    return productservice.findById(id);
  }

  // /product/search?field=name|category|desc|make|price&q=...&page=0&size=10
  @GetMapping("/search")
  public Page<Product> search(
      @RequestParam(defaultValue = "name") String field,
      @RequestParam(defaultValue = "") String q,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    Pageable pageable = PageRequest.of(Math.max(page, 0), Math.max(size, 1));
    return productservice.search(field, q, pageable);
  }
}
