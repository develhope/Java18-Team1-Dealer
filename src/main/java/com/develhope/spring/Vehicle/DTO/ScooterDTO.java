package com.develhope.spring.Vehicle.DTO;

import com.develhope.spring.Vehicle.Entities.Enums.EmissionType;
import com.develhope.spring.Vehicle.Entities.Enums.FuelType;
import com.develhope.spring.Vehicle.Entities.Enums.StatusType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ScooterDTO {
    private Long id;
    private String brand;
    private String model;
    private String colour;
    private Double cubiCapacity;
    private Integer hP;
    private Double kW;
    private LocalDate registrationYear;
    private FuelType fuelType;
    private BigDecimal price;
    private Boolean newVehicle;
    private Double mileage;
    private StatusType statusType;
    private String currentLocation;
    private EmissionType emissionType;
    private Integer passengerNumber;
    private Boolean windShield;
    private Boolean tailBag;
    private Boolean passengerBackrest;
    private Boolean availableRental;

    public ScooterDTO(Long id, String brand, String model, String colour, Double cubiCapacity, Integer hP, Double kW, LocalDate registrationYear, FuelType fuelType, BigDecimal price, Boolean newVehicle, Double mileage, StatusType statusType, String currentLocation, EmissionType emissionType, Integer passengerNumber, Boolean windShield, Boolean tailBag, Boolean passengerBackrest, Boolean availableRental) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.cubiCapacity = cubiCapacity;
        this.hP = hP;
        this.kW = kW;
        this.registrationYear = registrationYear;
        this.fuelType = fuelType;
        this.price = price;
        this.newVehicle = newVehicle;
        this.mileage = mileage;
        this.statusType = statusType;
        this.currentLocation = currentLocation;
        this.emissionType = emissionType;
        this.passengerNumber = passengerNumber;
        this.windShield = windShield;
        this.tailBag = tailBag;
        this.passengerBackrest = passengerBackrest;
        this.availableRental = availableRental;
    }

    public ScooterDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getCubiCapacity() {
        return cubiCapacity;
    }

    public void setCubiCapacity(Double cubiCapacity) {
        this.cubiCapacity = cubiCapacity;
    }

    public Integer gethP() {
        return hP;
    }

    public void sethP(Integer hP) {
        this.hP = hP;
    }

    public Double getkW() {
        return kW;
    }

    public void setkW(Double kW) {
        this.kW = kW;
    }

    public LocalDate getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(LocalDate registrationYear) {
        this.registrationYear = registrationYear;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getNewVehicle() {
        return newVehicle;
    }

    public void setNewVehicle(Boolean newVehicle) {
        this.newVehicle = newVehicle;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public EmissionType getEmissionType() {
        return emissionType;
    }

    public void setEmissionType(EmissionType emissionType) {
        this.emissionType = emissionType;
    }

    public Integer getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(Integer passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public Boolean getWindShield() {
        return windShield;
    }

    public void setWindShield(Boolean windShield) {
        this.windShield = windShield;
    }

    public Boolean getTailBag() {
        return tailBag;
    }

    public void setTailBag(Boolean tailBag) {
        this.tailBag = tailBag;
    }

    public Boolean getPassengerBackrest() {
        return passengerBackrest;
    }

    public void setPassengerBackrest(Boolean passengerBackrest) {
        this.passengerBackrest = passengerBackrest;
    }

    public Boolean getAvailableRental() {
        return availableRental;
    }

    public void setAvailableRental(Boolean availableRental) {
        this.availableRental = availableRental;
    }

    @Override
    public String toString() {
        return "ScooterDTO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", cubiCapacity=" + cubiCapacity +
                ", hP=" + hP +
                ", kW=" + kW +
                ", registrationYear=" + registrationYear +
                ", fuelType=" + fuelType +
                ", price=" + price +
                ", newVehicle=" + newVehicle +
                ", mileage=" + mileage +
                ", statusType=" + statusType +
                ", currentLocation='" + currentLocation + '\'' +
                ", emissionType=" + emissionType +
                ", passengerNumber=" + passengerNumber +
                ", windShield=" + windShield +
                ", tailBag=" + tailBag +
                ", passengerBackrest=" + passengerBackrest +
                ", availableRental=" + availableRental +
                '}';
    }
}
