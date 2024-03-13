package com.develhope.spring.User.Repositories;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.User.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM PURCHASE WHERE ID= :id AND  VEHICLESTATUSENUM='PURCHASED'")
    List<Purchase> purchaseList(@Param("id")Long id);
    @Query(value = "SELECT * FROM PURCHASE WHERE ID= :id AND VEHICLESTATUSENUM='ORDERED'")
    List<Purchase> orderList(@Param("id")Long id);

    @Query(value = "SELECT * FROM RENT WHERE ID= :id")
    List<Rent> rentList(@Param("id")Long id);
}
