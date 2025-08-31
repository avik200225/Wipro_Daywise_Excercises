package com.wipro.productms.service.impl;

import com.wipro.productms.entity.Product;
import com.wipro.productms.repo.ProductRepo;
import com.wipro.productms.service.ProductService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productrepo;

    public ProductServiceImpl(ProductRepo productrepo) {
        this.productrepo = productrepo;
    }

    @Override
    public List<Product> findAll() {
        return productrepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productrepo.findById(id).orElseThrow(() ->
            new EntityNotFoundException("Product not found: " + id));
    }

    @Override
    public Product create(Product p) {
        p.setProductId(null);
        return productrepo.save(p);
    }

    @Override
    public Product update(Long id, Product p) {
        Product db = findById(id);

        if (p.getProductName() != null) db.setProductName(p.getProductName());
        if (p.getProductCat() != null) db.setProductCat(p.getProductCat());
        if (p.getProductDesc() != null) db.setProductDesc(p.getProductDesc());
        if (p.getMake() != null) db.setMake(p.getMake());
        if (p.getProductAvailableQty() != null) db.setProductAvailableQty(p.getProductAvailableQty());
        if (p.getProductPrice() != null) db.setProductPrice(p.getProductPrice());
        if (p.getProductImgUrl() != null) db.setProductImgUrl(p.getProductImgUrl());
        if (p.getDateOfManufacture() != null) db.setDateOfManufacture(p.getDateOfManufacture());
        return productrepo.save(db);
    }

    @Override
    public void delete(Long id) {
        if (!productrepo.existsById(id)) throw new EntityNotFoundException("Product not found: " + id);
        productrepo.deleteById(id);
    }

    
    @Override
    public Page<Product> search(String field, String query, org.springframework.data.domain.Pageable pageable) {
        String f = (field == null ? "" : field.trim().toLowerCase());
        String q = (query == null ? "" : query.trim());

        if (q.isEmpty()) {
            return productrepo.findAll(pageable);
        }

        switch (f) {
            case "name":
                return productrepo.findByProductNameContainingIgnoreCase(q, pageable);
            case "category":
                return productrepo.findByProductCatContainingIgnoreCase(q, pageable);
            case "description":
                return productrepo.findByProductDescContainingIgnoreCase(q, pageable);
            case "make":
                return productrepo.findByMakeContainingIgnoreCase(q, pageable);
            case "price":
                try {
                    java.math.BigDecimal price = new java.math.BigDecimal(q);
                    return productrepo.findByProductPrice(price, pageable);
                } catch (NumberFormatException ex) {

                    return org.springframework.data.domain.Page.empty(pageable);
                }
            default:
                return productrepo.findByProductNameContainingIgnoreCase(q, pageable);
        }
    }

}


