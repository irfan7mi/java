package com.ecom.customerOrder.Repository;
import com.ecom.customerorder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }