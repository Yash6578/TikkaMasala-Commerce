package com.tikkamasala.commerce.service.impl;

import com.tikkamasala.commerce.entity.Purchase;
import com.tikkamasala.commerce.repository.PurchaseRepository;
import com.tikkamasala.commerce.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Override
    public Purchase save(Purchase purchase) {
        System.out.println(purchase);
        purchase.getInventories().stream().forEach(inventory -> {
            inventory.setPurchase(purchase);
            inventory.getItem().setInventories(Collections.singletonList(inventory));
        });
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseRepository.findAll();
    }
}
