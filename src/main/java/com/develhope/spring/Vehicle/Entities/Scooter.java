package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.Entities.Enums.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table
@NoArgsConstructor

public class Scooter extends Vehicle{
    @Column(nullable = false)
    private Boolean windShield;
    @Column(nullable = false)
    private Boolean tailBag;
    @Column(nullable = false)
    private Boolean passengerBackrest;
    @Column(nullable = false)
    private Boolean heatedGrips;

    public Scooter(Long id, VehiclesType vehiclesType, String brand, String model, String colour, Integer hP, Double kW, LocalDate registrationYear, FuelType fuelType, BigDecimal price, Double tradeDiscount, Boolean newVehicle, Double mileage, Integer ageLimit, StatusType statusType, String currentLocation, Boolean availableRental, EmissionType emissionType, Integer passengerNumber, Boolean windShield, Boolean tailBag, Boolean passengerBackrest, Boolean heatedGrips) {
        super(id, vehiclesType, brand, model, colour, hP, kW, registrationYear, fuelType, price, tradeDiscount, newVehicle, mileage, ageLimit, statusType, currentLocation, availableRental, emissionType, passengerNumber);
        this.windShield = windShield;
        this.tailBag = tailBag;
        this.passengerBackrest = passengerBackrest;
        this.heatedGrips = heatedGrips;
    }
}
