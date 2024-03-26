package com.develhope.spring.ShowroomProfit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ShowroomProfitRepository extends JpaRepository<ShowroomProfit, Long> {
    //Verificare un venditore quante vendite ha fatto in un determinato periodo di tempo
    @Query(value = "SELECT COUNT * FROM showroom_profit WHERE purchase.salesman_id = :idsalesman AND profit_type_enum LIKE PURCHASE " +
            "AND pay_date BETWEEN :paydate1 AND :paydate2", nativeQuery = true)
    Long countPurchaseForSalesman(Long idsalesman, LocalDate paydate1, LocalDate paydate2);

    //Verificare un venditore quanti soldi ha generato in un determinato periodo di tempo
    @Query(value = "SELECT SUM(profit) FROM showroom_profit WHERE purchase.salesman_id = :idsalesman " +
            "AND pay_date BETWEEN :paydate1 AND :paydate2", nativeQuery = true)
    Double profitBySalesman(Long idsalesman,LocalDate paydate1, LocalDate paydate2);

    //Verificare il guadagno del salone in un determinato periodo
    @Query(value = "SELECT SUM(profit) FROM showroom_profit WHERE pay_date BETWEEN :paydate1 AND :paydate2", nativeQuery = true)
    Double profitShowroom(LocalDate paydate1, LocalDate paydate2);

}
