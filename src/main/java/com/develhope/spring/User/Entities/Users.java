package com.develhope.spring.User.Entities;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.User.Enum.UserTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Email(message = "Email")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserTypeEnum role;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private  String address;

    @Column
    private Integer salesNumber;

    @Column
    private String creditCard;

    @Column(nullable = false, unique = true, updatable = false)
    private String taxId;


    @OneToMany
    private List<Rent> rent;

    @OneToMany
    private List<Purchase> purchase;
}

