package com.wipro.orderms.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.orderms.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
