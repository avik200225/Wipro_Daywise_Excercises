package com.wipro.productms.controller;

import com.wipro.productms.entity.Product;
import com.wipro.productms.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product Management", description = "CRUD and search for products")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productservice;

    public ProductController(ProductService productservice) {
        this.productservice = productservice;
    }

    @Operation(summary = "Get all products")
    @ApiResponse(responseCode = "200", description = "List returned")
    @GetMapping
    public List<Product> getAll() {
        return productservice.findAll();
    }

    @Operation(summary = "Get product by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product found"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productservice.findById(id);
    }

    @Operation(summary = "Create a new product")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product created"),
        @ApiResponse(responseCode = "400", description = "Invalid product data")
    })
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping
    public Product create(@Valid @RequestBody Product p) {
        return productservice.create(p);
    }

    @Operation(summary = "Update a product")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product updated"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @SecurityRequirement(name = "bearerAuth")
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p) {
        return productservice.update(id, p);
    }

    @Operation(summary = "Delete a product")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product deleted"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productservice.delete(id);
    }

    @Operation(summary = "Search products with pagination")
    @ApiResponse(responseCode = "200", description = "Paged results")
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
