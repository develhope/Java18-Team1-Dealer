package com.develhope.spring.Purchase.Repositories;

import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query(value = "SELECT p.* FROM PURCHASE p INNER JOIN CUSTOMER c ON p.CUSTOMER_ID = c.ID WHERE c.ID = :idCustomer", nativeQuery = true)
    List<Purchase> purchasesByCustomer(Long idCustomer);

    @Query( value = "SELECT * FROM purchase WHERE order_status_enum = ?1", nativeQuery = true)
    Optional<List<Purchase>> findOrdersByOrderStatus(OrderStatusEnum orderStatus);

    @Query(value = "SELECT * FROM PURCHASE WHERE ID= :id AND  status_type_enum='PURCHASABLE'",nativeQuery = true)
    Optional<List<Purchase>> purchaseList(@Param("id")Long id);
    @Query(value = "SELECT * FROM PURCHASE WHERE ID= :id AND status_type_enum='ORDERABLE'",nativeQuery = true)
    List<Purchase> orderList(@Param("id")Long id);
}
