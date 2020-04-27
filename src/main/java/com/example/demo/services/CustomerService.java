package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Long deleteCustomerByEmail(String email);

}