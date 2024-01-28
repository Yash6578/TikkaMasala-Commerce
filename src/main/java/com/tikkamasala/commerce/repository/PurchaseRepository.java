package com.tikkamasala.commerce.repository;

import com.tikkamasala.commerce.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
