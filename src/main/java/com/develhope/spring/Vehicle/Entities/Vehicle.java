package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Entities.Salesman;
import com.develhope.spring.Vehicle.Entities.Enums.FuelType;
import com.develhope.spring.Vehicle.Entities.Enums.StatusType;
import com.develhope.spring.Vehicle.Entities.Enums.VehiclesType;
import com.develhope.spring.Vehicle.Entities.Enums.TransmissionType;
import com.develhope.spring.Vehicle.Entities.Enums.EmissionType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerProperties;


import java.lang.annotation.Inherited;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private VehiclesType vehiclesType;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String colour;
    @Column(nullable = false)
    private Double cubiCapacity;
    @Column(nullable = false)
    private Integer hP;
    @Column(nullable = false)
    private Double kW;
    @Column(nullable = false)
    private LocalDate registrationYear;
    @Column(nullable = false)
    private FuelType fuelType;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = true)
    private Double tradeDiscount;
    @Column(nullable = false)
    private Boolean newVehicle;
    @Column(nullable = true)
    private Double mileage;
    @Column(nullable = false)
    private Integer ageLimit;
    @Column(nullable = false)
    private StatusType statusType;
    @Column(nullable = false)
    private String currentLocation;
    @Column(nullable = false)
    private Boolean availableRental;
    @Column(nullable = false)
    private EmissionType emissionType;
    @Column(nullable = false)
    private Integer passengerNumber;

    @OneToOne
    Customer customer;
    @OneToOne
    Salesman salesman;
    @OneToOne
    Purchase purchase;
    @OneToOne
    Rent rent;
}