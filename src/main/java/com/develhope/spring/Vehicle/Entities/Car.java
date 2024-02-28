package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.Entities.Enums.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
public class Car extends Vehicle{
    @Column(nullable = false)
    private CarType carType;
    @Column(nullable = false)
    private TransmissionType transmissionType;
    @Column(nullable = false)
    private Double cubiCapacity;
    @Column(nullable = false)
    private TractionType tractionType;
    @Column(nullable = false)
    private Boolean optionFullTraction;
    @Column(nullable = false)
    private Integer doors;
    @Column(nullable = false)
    private Boolean centralizedClosing;
    @Column(nullable = false)
    private Boolean airConditioning;
    @Column(nullable = false)
    private Boolean bluetooth;
    @Column(nullable = false)
    private Boolean satNav;
    @Column(nullable = false)
    private Boolean eletricRoof;
    @Column(nullable = false)
    private Boolean parkAssist;
    @Column(nullable = false)
    private Boolean spareTire;
    @Column(nullable = false)
    private Boolean antiTheft;

    public Car(Long id, VehiclesType vehiclesType, String brand, String model, String colour, Integer hP, Double kW, LocalDate registrationYear, FuelType fuelType, BigDecimal price, Double tradeDiscount, Boolean newVehicle, Double mileage, Integer ageLimit, StatusType statusType, String currentLocation, Boolean availableRental, EmissionType emissionType, Integer passengerNumber, CarType carType, TransmissionType transmissionType, Double cubiCapacity, TractionType tractionType, Boolean optionFullTraction, Integer doors, Boolean centralizedClosing, Boolean airConditioning, Boolean bluetooth, Boolean satNav, Boolean eletricRoof, Boolean parkAssist, Boolean spareTire, Boolean antiTheft) {
        super(id, vehiclesType, brand, model, colour, hP, kW, registrationYear, fuelType, price, tradeDiscount, newVehicle, mileage, ageLimit, statusType, currentLocation, availableRental, emissionType, passengerNumber);
        this.carType = carType;
        this.transmissionType = transmissionType;
        this.cubiCapacity = cubiCapacity;
        this.tractionType = tractionType;
        this.optionFullTraction = optionFullTraction;
        this.doors = doors;
        this.centralizedClosing = centralizedClosing;
        this.airConditioning = airConditioning;
        this.bluetooth = bluetooth;
        this.satNav = satNav;
        this.eletricRoof = eletricRoof;
        this.parkAssist = parkAssist;
        this.spareTire = spareTire;
        this.antiTheft = antiTheft;
    }
}
