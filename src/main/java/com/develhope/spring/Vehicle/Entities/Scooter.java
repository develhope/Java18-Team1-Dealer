package com.develhope.spring.Vehicle.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Scooter extends Vehicle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
