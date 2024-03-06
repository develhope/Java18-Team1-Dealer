package com.develhope.spring.User.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer creditCard;

    @Column(nullable = false, unique = true, updatable = false)
    private String taxId;

    //TODO: definire onetomany o manytoone.
}
