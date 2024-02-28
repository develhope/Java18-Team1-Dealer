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

public class Motorbike extends Vehicle{
    @Column(nullable = false)
    private MotorbikeType motorbikeType;
    @Column(nullable = false)
    private Double cubiCapacity;
    @Column(nullable = false)
    private TransmissionType transmissionType;
    @Column(nullable = false)
    private Boolean windShield;
    @Column(nullable = false)
    private Boolean tailBag;
    @Column(nullable = false)
    private Boolean passengerBackrest;
    @Column(nullable = false)
    private Boolean heatedGrips;

    public Motorbike(Long id, VehiclesType vehiclesType, String brand, String model, String colour, Integer hP, Double kW, LocalDate registrationYear, FuelType fuelType, BigDecimal price, Double tradeDiscount, Boolean newVehicle, Double mileage, Integer ageLimit, StatusType statusType, String currentLocation, Boolean availableRental, EmissionType emissionType, Integer passengerNumber, MotorbikeType motorbikeType, Double cubiCapacity, TransmissionType transmissionType, Boolean windShield, Boolean tailBag, Boolean passengerBackrest, Boolean heatedGrips) {
        super(id, vehiclesType, brand, model, colour, hP, kW, registrationYear, fuelType, price, tradeDiscount, newVehicle, mileage, ageLimit, statusType, currentLocation, availableRental, emissionType, passengerNumber);
        this.motorbikeType = motorbikeType;
        this.cubiCapacity = cubiCapacity;
        this.transmissionType = transmissionType;
        this.windShield = windShield;
        this.tailBag = tailBag;
        this.passengerBackrest = passengerBackrest;
        this.heatedGrips = heatedGrips;
    }
}
