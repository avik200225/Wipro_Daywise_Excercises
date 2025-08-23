package com.wipro.productmgmtv2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.productmgmtv2.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}