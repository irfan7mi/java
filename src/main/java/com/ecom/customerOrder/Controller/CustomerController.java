package com.ecom.customerOrder.Controller;  // Ensure the package name is correct

import com.ecom.customerOrder.Model.Customer;  // Correct package for Customer class
import com.ecom.customerOrder.service.CustomerService;  // Correct package for CustomerService class
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Customer API", description = "Operations related to customers")
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        Customer customer = service.getCustomerById(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found with id: " + id); // Handle not found
        }
        return customer;
    }

    // Add new customer
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    // Delete customer by ID
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}
