package com.develhope.spring.User.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Salesman extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
