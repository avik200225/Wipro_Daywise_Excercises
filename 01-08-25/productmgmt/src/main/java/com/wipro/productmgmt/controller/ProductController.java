package com.wipro.productmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import com.wipro.productmgmt.enity.ProductList;
import com.wipro.productmgmt.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@PostMapping
	@Operation(summary = "Save a tourist place")
	  @ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Saved successfully"),
	    @ApiResponse(responseCode = "404", description = "Not found")
	  })
	public void save(@RequestBody ProductList product) {
		productService.save(product);
		System.out.println("PRODUCT ADDED");
	}
	@GetMapping
	@Operation(summary = "Get all products", description = "Returns a list of all available products")//Swagger Operation
	public List<ProductList> findAll() {
		return productService.findAll();
	}
	@GetMapping("/{id}")
	public ProductList findById(@PathVariable int id) {
		return productService.findById(id);
	}
	@PutMapping
	public void update(@RequestBody ProductList product) {
		productService.save(product);
	}
	@GetMapping("/make/{productMake}")
	public List<ProductList> findByProductMake(@PathVariable String productMake) {
	    return productService.findByProductMake(productMake);
	}
	@GetMapping("/search")
	public List<ProductList> findByProductNameAndProductMakeSorted(
	        @RequestParam String productName,
	        @RequestParam String productMake) {
	    return productService.findByProductNameAndProductMakeSorted(productName, productMake);
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		productService.deleteById(id);
	}
	@GetMapping("/page/{pageNum}/{pageSize}/{sortOrder}")
	public Page<ProductList> findAllPage(@PathVariable int  pageNum,@PathVariable int  pageSize,@PathVariable int  sortOrder) {
		Pageable p=null;
	  if(sortOrder==0)
	  {
		  p=PageRequest.of(pageNum, pageSize,Sort.by("productPrice").descending());
	  }
	  else
	  {
		    p=PageRequest.of(pageNum, pageSize,Sort.by("productPrice").ascending());
	  }
		
		return productService.findAll(p);
	}
}

