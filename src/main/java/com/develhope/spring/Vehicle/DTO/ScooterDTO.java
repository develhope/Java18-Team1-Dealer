package com.develhope.spring.Vehicle.DTO;

import com.develhope.spring.Vehicle.Entities.Enums.EmissionTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.FuelTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScooterDTO {
    private Long id;
    private String brand;
    private String model;
    private String colour;
    private Double cubiCapacity;
    private Integer hP;
    private Double kW;
    private LocalDate registrationYear;
    private FuelTypeEnum fuelTypeEnum;
    private BigDecimal price;
    private Boolean newVehicle;
    private Double mileage;
    private StatusTypeEnum statusTypeEnum;
    private String currentLocation;
    private EmissionTypeEnum emissionTypeEnum;
    private Integer passengerNumber;
    private Boolean windShield;
    private Boolean tailBag;
    private Boolean passengerBackrest;
    private Boolean availableRental;
}
