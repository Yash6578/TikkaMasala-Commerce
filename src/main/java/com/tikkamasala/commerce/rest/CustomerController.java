package com.tikkamasala.commerce.rest;

import com.tikkamasala.commerce.entity.Customer;
import com.tikkamasala.commerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer save = customerService.save(customer);
        return null != save.getId() ?
                ResponseEntity.status(HttpStatus.CREATED).body(save)
                : ResponseEntity.badRequest().body(save);
    }

    @GetMapping("/customers")
    ResponseEntity<List<Customer>> getAll() {
        List<Customer> all = customerService.getAll();
        return all.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(all);
    }
}
