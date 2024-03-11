package com.develhope.spring.Vehicle.DTO;

import com.develhope.spring.Vehicle.Entities.Enums.*;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CarDTO {
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
    private EmissionType emissionType;
    private Integer passengerNumber;
    private TransmissionType transmissionType;
    private CarType carType;
    private TractionType tractionType;
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
    private StatusType statusType;
    private String currentLocation;
    private Boolean availableRental;

    public CarDTO(Long id, String brand, String model, String colour, Double cubiCapacity, Integer hP, Double kW, LocalDate registrationYear, FuelType fuelType, BigDecimal price, Boolean newVehicle, Double mileage, EmissionType emissionType, Integer passengerNumber, TransmissionType transmissionType, CarType carType, TractionType tractionType, Boolean optionFullTraction, Integer doors, Boolean centralizedClosing, Boolean airConditioning, Boolean bluetooth, Boolean satNav, Boolean electricRoof, Boolean parkAssist, Boolean spareTire, Boolean antiTheft, StatusType statusType, String currentLocation, Boolean availableRental) {
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
        this.emissionType = emissionType;
        this.passengerNumber = passengerNumber;
        this.transmissionType = transmissionType;
        this.carType = carType;
        this.tractionType = tractionType;
        this.optionFullTraction = optionFullTraction;
        this.doors = doors;
        this.centralizedClosing = centralizedClosing;
        this.airConditioning = airConditioning;
        this.bluetooth = bluetooth;
        this.satNav = satNav;
        this.electricRoof = electricRoof;
        this.parkAssist = parkAssist;
        this.spareTire = spareTire;
        this.antiTheft = antiTheft;
        this.statusType = statusType;
        this.currentLocation = currentLocation;
        this.availableRental = availableRental;
    }

    public CarDTO() {
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

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public TractionType getTractionType() {
        return tractionType;
    }

    public void setTractionType(TractionType tractionType) {
        this.tractionType = tractionType;
    }

    public Boolean getOptionFullTraction() {
        return optionFullTraction;
    }

    public void setOptionFullTraction(Boolean optionFullTraction) {
        this.optionFullTraction = optionFullTraction;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Boolean getCentralizedClosing() {
        return centralizedClosing;
    }

    public void setCentralizedClosing(Boolean centralizedClosing) {
        this.centralizedClosing = centralizedClosing;
    }

    public Boolean getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(Boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getSatNav() {
        return satNav;
    }

    public void setSatNav(Boolean satNav) {
        this.satNav = satNav;
    }

    public Boolean getElectricRoof() {
        return electricRoof;
    }

    public void setElectricRoof(Boolean electricRoof) {
        this.electricRoof = electricRoof;
    }

    public Boolean getParkAssist() {
        return parkAssist;
    }

    public void setParkAssist(Boolean parkAssist) {
        this.parkAssist = parkAssist;
    }

    public Boolean getSpareTire() {
        return spareTire;
    }

    public void setSpareTire(Boolean spareTire) {
        this.spareTire = spareTire;
    }

    public Boolean getAntiTheft() {
        return antiTheft;
    }

    public void setAntiTheft(Boolean antiTheft) {
        this.antiTheft = antiTheft;
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

    public Boolean getAvailableRental() {
        return availableRental;
    }

    public void setAvailableRental(Boolean availableRental) {
        this.availableRental = availableRental;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
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
                ", emissionType=" + emissionType +
                ", passengerNumber=" + passengerNumber +
                ", transmissionType=" + transmissionType +
                ", carType=" + carType +
                ", tractionType=" + tractionType +
                ", optionFullTraction=" + optionFullTraction +
                ", doors=" + doors +
                ", centralizedClosing=" + centralizedClosing +
                ", airConditioning=" + airConditioning +
                ", bluetooth=" + bluetooth +
                ", satNav=" + satNav +
                ", electricRoof=" + electricRoof +
                ", parkAssist=" + parkAssist +
                ", spareTire=" + spareTire +
                ", antiTheft=" + antiTheft +
                ", statusType=" + statusType +
                ", currentLocation='" + currentLocation + '\'' +
                ", availableRental=" + availableRental +
                '}';
    }
}
