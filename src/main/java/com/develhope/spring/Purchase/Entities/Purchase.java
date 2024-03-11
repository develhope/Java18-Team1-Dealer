package com.develhope.spring.Purchase.Entities;

import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Entities.Salesman;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    private Salesman salesman;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Vehicle vehicle;
    
}
