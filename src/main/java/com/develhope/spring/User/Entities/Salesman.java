package com.develhope.spring.User.Entities;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salesman extends Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long phone;

    @Column(nullable = false)
    private  String address;

    @Column(nullable = false)
    private Integer salesNumber;

    @OneToMany
    private List<Rent> rent;

    @OneToMany
    private List<Purchase> purchase;

}
