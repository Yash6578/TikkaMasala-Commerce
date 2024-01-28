package com.tikkamasala.commerce.service.impl;

import com.tikkamasala.commerce.entity.Vendor;
import com.tikkamasala.commerce.repository.VendorRepository;
import com.tikkamasala.commerce.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    @Override
    public Vendor save(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public List<Vendor> getAll() {
        return vendorRepository.findAll();
    }
}
