package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

   @Autowired
   private CustomerRepository customerRepository;

   @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer student) {
        customerRepository.save(student);
    }

    @Override
    public Long deleteCustomerByEmail(String email) {
        return customerRepository.deleteCustomerByEmail(email);
    }

}