package com.wipro.productms.repo;
import com.wipro.productms.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Page<Product> findByProductNameContainingIgnoreCase(String q, Pageable pageable);
    Page<Product> findByProductCatContainingIgnoreCase(String q, Pageable pageable);
    Page<Product> findByProductDescContainingIgnoreCase(String q, Pageable pageable);
    Page<Product> findByMakeContainingIgnoreCase(String q, Pageable pageable);
    Page<Product> findByProductPrice(java.math.BigDecimal price, Pageable pageable);
}

