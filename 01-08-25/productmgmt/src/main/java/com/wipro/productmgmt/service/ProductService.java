package com.wipro.productmgmt.service;
//import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.productmgmt.enity.ProductList;

public interface ProductService {

	void save(ProductList product);
	List<ProductList> findAll();
	ProductList findById(int id);
	void deleteById(int id);
	List<ProductList> findByProductMake(String productMake);
	List<ProductList> findByProductNameAndProductMakeSorted(String productName, String productMake);
	Page<ProductList> findAll(Pageable pageable);
}

