package com.develhope.spring.Purchase.Repositories;

import com.develhope.spring.Purchase.Entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query(value = "SELECT * FROM PURCHASE INNER JOIN CUSTOMER WHERE CUSTOMER.ID = :idCustomer", nativeQuery = true)
    List<Purchase> purchasesByCustomer(Long idCustomer);
}
