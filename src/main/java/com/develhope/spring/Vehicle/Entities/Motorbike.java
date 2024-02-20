package com.develhope.spring.Vehicle.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Motorbike extends Vehicle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
