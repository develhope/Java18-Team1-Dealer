package com.develhope.spring.User.Repositories;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.User.Entities.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesmanRepository extends JpaRepository<Salesman,Long> {
    @Query( value = "SELECT p FROM purchase p WHERE p.orderStatus = ?1", nativeQuery = true)
    List<Purchase> findOrdersByOrderStatus(String orderStatus);
}
