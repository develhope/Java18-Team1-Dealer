package com.develhope.spring.Purchase.Repositories;

import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query( value = "SELECT * FROM purchase WHERE order_status_enum = ?1", nativeQuery = true)
    Optional<List<Purchase>> findOrdersByOrderStatus(OrderStatusEnum orderStatus);
}
