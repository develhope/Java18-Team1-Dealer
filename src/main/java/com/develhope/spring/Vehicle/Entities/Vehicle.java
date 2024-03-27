package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.Vehicle.Entities.Enums.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private VehiclesTypeEnum vehiclesTypeEnum;
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
    private FuelTypeEnum fuelTypeEnum;
    @Column(nullable = false)
    private BigDecimal price;
    @Column
    private Double tradeDiscount;
    @Column(nullable = false)
    private Boolean newVehicle;
    @Column
    private Double mileage;
    @Column(nullable = false)
    private Integer ageLimit;
    @Column(nullable = false)
    private StatusTypeEnum statusTypeEnum;
    @Column
    private String currentLocation;
    @Column(nullable = false)
    private Boolean availableRental;
    @Column(nullable = false)
    private EmissionTypeEnum emissionTypeEnum;
    @Column(nullable = false)
    private Integer passengerNumber;

    //solo scooter e moto
    @Column
    private Boolean windShield;
    @Column
    private Boolean tailBag;
    @Column
    private Boolean passengerBackrest;

    //motor, car e van
    @Column
    private TransmissionTypeEnum transmissionTypeEnum;

    //solo car
    @Column
    private CarTypeEnum carTypeEnum;

    //car e van
    @Column
    private TractionTypeEnum tractionTypeEnum;
    @Column
    private Boolean optionFullTraction;
    @Column
    private Integer doors;
    @Column
    private Boolean centralizedClosing;
    @Column
    private Boolean airConditioning;
    @Column
    private Boolean bluetooth;
    @Column
    private Boolean satNav;
    @Column
    private Boolean electricRoof;
    @Column
    private Boolean parkAssist;
    @Column
    private Boolean spareTire;
    @Column
    private Boolean antiTheft;

    //solo van
    @Column
    private Boolean passengerTransport;
    @Column
    private Boolean windowedBackDoor;
    @Column
    private Boolean slideSideDoor;
    @Column
    private Boolean antiCollisionSystem;

//    @OneToOne
//    private Purchase purchase;
//    @OneToOne
//    private  Rent rent;
}