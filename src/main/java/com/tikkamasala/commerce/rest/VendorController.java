package com.tikkamasala.commerce.rest;

import com.tikkamasala.commerce.entity.Vendor;
import com.tikkamasala.commerce.service.VendorService;
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
public class VendorController {
    private final VendorService vendorService;

    @PostMapping("/vendor")
    ResponseEntity<Vendor> saveVendor(@RequestBody Vendor vendor) {
        Vendor save = vendorService.save(vendor);
        return null != save.getId() ?
                ResponseEntity.status(HttpStatus.CREATED).body(save)
                : ResponseEntity.badRequest().body(save);
    }

    @GetMapping("/vendors")
    ResponseEntity<List<Vendor>> getAll() {
        List<Vendor> all = vendorService.getAll();
        return all.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(all);
    }
}
