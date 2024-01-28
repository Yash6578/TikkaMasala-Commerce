package com.tikkamasala.commerce.service;

import com.tikkamasala.commerce.entity.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase save(Purchase purchase);
    List<Purchase> getAll();
}
