package com.develhope.spring.Rent.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private BigDecimal advancePayment;
    @Column(nullable = false)
    private LocalDate dateStart;
    @Column(nullable = false)
    private LocalDate dateEnd;
    @Column(nullable = false)
    private BigDecimal dailyRate;
    @Column(nullable = false)
    private BigDecimal totalPrice;
    @Column(nullable = false)
    private String pickUpLocation;
    @Column(nullable = false)
    private String deliveryPlace;
    @Column(nullable = false)
    private Boolean isPaid;
}
