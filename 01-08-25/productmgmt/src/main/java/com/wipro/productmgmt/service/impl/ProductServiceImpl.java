package com.wipro.productmgmt.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.wipro.productmgmt.enity.ProductList;
import com.wipro.productmgmt.repo.ProductRepo;
import com.wipro.productmgmt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	@Override
	public void save(ProductList productList) {
		productRepo.save(productList);
	}
	@Override
	public List<ProductList> findAll() {
		return productRepo.findAll();
	}
	@Override
	public ProductList findById(int id) {
		Optional<ProductList> product = productRepo.findById(id);
		return product.orElse(null);
	}
	@Override
	public void deleteById(int id) {
		productRepo.deleteById(id);
	}
	@Override
	public List<ProductList> findByProductMake(String productMake) {
	    return productRepo.findByProductMake(productMake);
	}
	@Override
	public List<ProductList> findByProductNameAndProductMakeSorted(String productName, String productMake) {
	    return productRepo.findByProductNameAndProductMakeOrderByProductNameDesc(productName, productMake);
	}
	@Override
	public Page<ProductList> findAll(Pageable p) {
		return productRepo.findAll(p);
	}
}
