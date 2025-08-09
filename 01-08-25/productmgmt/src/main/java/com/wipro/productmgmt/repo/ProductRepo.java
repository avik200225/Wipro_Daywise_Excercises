package com.wipro.productmgmt.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.productmgmt.enity.ProductList;

@Repository
public interface ProductRepo extends JpaRepository<ProductList, Integer> {
	List<ProductList> findByProductMake(String productMake);
	List<ProductList> findByProductNameAndProductMakeOrderByProductNameDesc(String productName, String productMake);
	Page<ProductList>  findAll(Pageable p); 
}

