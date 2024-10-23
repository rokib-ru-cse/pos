package com.bitspondon.pos.presentation.controller;

import com.bitspondon.pos.application.service.CustomerService;
import com.bitspondon.pos.domain.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/20/24
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping
    public ResponseEntity<Customer> getCustomerById(@RequestParam Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);

        return customer != null ? ResponseEntity.ok(customer) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);

        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestParam Long customerId, @RequestBody Customer customerDetails) {
        Customer updatedCustomer = customerService.updateCustomer(customerId, customerDetails);

        return updatedCustomer != null ? ResponseEntity.ok(updatedCustomer) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteCustomer(@RequestParam Long customerId) {
        customerService.deleteCustomer(customerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}