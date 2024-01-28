package com.tikkamasala.commerce.rest;

import com.tikkamasala.commerce.entity.Purchase;
import com.tikkamasala.commerce.service.PurchaseService;
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
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping("/purchase")
    ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        Purchase save = purchaseService.save(purchase);
        return null != save.getId() ?
                ResponseEntity.status(HttpStatus.CREATED).body(save)
                : ResponseEntity.badRequest().body(save);
    }

    @GetMapping("/purchases")
    ResponseEntity<List<Purchase>> getAll() {
        List<Purchase> all = purchaseService.getAll();
        return all.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(all);
    }
}
