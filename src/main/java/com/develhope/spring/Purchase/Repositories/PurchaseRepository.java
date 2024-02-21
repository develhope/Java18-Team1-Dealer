package com.develhope.spring.Purchase.Repositories;

import com.develhope.spring.Purchase.Entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
