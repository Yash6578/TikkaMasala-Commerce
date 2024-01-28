package com.tikkamasala.commerce.service.impl;

import com.tikkamasala.commerce.entity.Customer;
import com.tikkamasala.commerce.repository.CustomerRepository;
import com.tikkamasala.commerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
