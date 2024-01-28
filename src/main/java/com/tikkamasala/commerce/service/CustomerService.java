package com.tikkamasala.commerce.service;

import com.tikkamasala.commerce.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> getAll();
}
