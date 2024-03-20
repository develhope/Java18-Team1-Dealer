package com.develhope.spring.Vehicle.DTO;

import com.develhope.spring.Vehicle.Entities.Enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VanDTO {
    private Long id;
    private String brand;
    private String model;
    private String colour;
    private Double cubiCapacity;
    private Integer hP;
    private Double kW;
    private TransmissionTypeEnum transmissionTypeEnum;
    private LocalDate registrationYear;
    private FuelTypeEnum fuelTypeEnum;
    private BigDecimal price;
    private Boolean newVehicle;
    private Double mileage;
    private EmissionTypeEnum emissionTypeEnum;
    private Integer passengerNumber;
    private TractionTypeEnum tractionTypeEnum;
    private Boolean optionFullTraction;
    private Integer doors;
    private Boolean centralizedClosing;
    private Boolean airConditioning;
    private Boolean bluetooth;
    private Boolean satNav;
    private Boolean electricRoof;
    private Boolean parkAssist;
    private Boolean spareTire;
    private Boolean antiTheft;
    private Boolean passengerTransport;
    private Boolean windowedBackDoor;
    private Boolean slideSideDoor;
    private Boolean antiCollisionSystem;
    private StatusTypeEnum statusTypeEnum;
    private String currentLocation;
    private Boolean availableRental;
}
