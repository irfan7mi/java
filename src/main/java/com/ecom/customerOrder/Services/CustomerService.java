package com.ecom.customerOrder.Services;  // Correct package name for services

import com.ecom.customerOrder.exception.ResourceNotFoundException;  // Corrected import for ResourceNotFoundException
import com.ecom.customerOrder.Model.Order;  // Correct import for Order class (case-sensitive)
import com.ecom.customerOrder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    // Get all orders
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    // Get order by ID
    public Order getOrderById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));  // Provide detailed error message
    }

    // Add new order
    public Order addOrder(Order order) {
        return repository.save(order);
    }

    // Delete order by ID
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
