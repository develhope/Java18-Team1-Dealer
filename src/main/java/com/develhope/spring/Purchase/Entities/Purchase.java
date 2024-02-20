package com.develhope.spring.Purchase.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private BigDecimal advancePayment;

    @Column(nullable = false)
    private Boolean isPaid;

    @Column(nullable = false)
    private String orderStatus;

}
