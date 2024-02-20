package com.develhope.spring.Vehicle.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Car extends Vehicle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
