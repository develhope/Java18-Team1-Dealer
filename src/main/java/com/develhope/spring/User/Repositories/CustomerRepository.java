package com.develhope.spring.User.Repositories;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.User.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM PURCHASE WHERE ID=(//ID DI ACCESSO DEL CLIENTE) AND  VEHICLESTATUSENUM=PURCHASED", nativeQuery = true)
    List<Purchase> purchaseList();
    @Query(value = "SELECT * FROM PURCHASE WHERE ID=(//ID DI ACCESSO DEL CLIENTE) AND VEHICLESTATUSENUM=ORDERED", nativeQuery = true)
    List<Purchase> orderList();

    @Query(value = "SELECT * FROM RENT WHERE ID=(//ID DI ACCESSO DEL CLIENTE)", nativeQuery = true)
    List<Rent> rentList();
}
