package com.tikkamasala.commerce.service;

import com.tikkamasala.commerce.entity.Vendor;

import java.util.List;

public interface VendorService {
    Vendor save(Vendor vendor);
    List<Vendor> getAll();
}
