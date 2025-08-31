package com.wipro.orderms.repo;

import com.wipro.orderms.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart, Integer> {
  Optional<Cart> findByUserId(Integer userId);
}

