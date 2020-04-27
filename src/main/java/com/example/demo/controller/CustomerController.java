package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/")
    public List<Customer> getAll() {
        return customerService.findAll();
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> save(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete")
    public Long deleteCustomerByEmail(@RequestBody Customer customer) {
        return customerService.deleteCustomerByEmail(customer.getEmail());
    }

    
}