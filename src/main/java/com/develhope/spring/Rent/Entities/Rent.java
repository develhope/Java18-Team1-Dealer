package com.develhope.spring.Rent.Entities;

import com.develhope.spring.ShowroomProfit.ShowroomProfit;
import com.develhope.spring.User.Entities.Users;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


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

    @ManyToOne
    @JoinColumn(name = "salesman_id")
    private Users salesman;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Users customer;

    @OneToOne
    private Vehicle vehicle;
    @OneToOne
    private ShowroomProfit showroomProfit;
}
