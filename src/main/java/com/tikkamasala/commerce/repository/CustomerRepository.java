package com.tikkamasala.commerce.repository;

import com.tikkamasala.commerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
