package com.develhope.spring.Vehicle.DTO;

import com.develhope.spring.Vehicle.Entities.Enums.*;

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
    private FuelTypeEnum fuelTypeEnum;
    private BigDecimal price;
    private Boolean newVehicle;
    private Double mileage;
    private EmissionTypeEnum emissionTypeEnum;
    private Integer passengerNumber;
    private TransmissionTypeEnum transmissionTypeEnum;
    private CarTypeEnum carTypeEnum;
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
    private StatusTypeEnum statusTypeEnum;
    private String currentLocation;
    private Boolean availableRental;

    public CarDTO(Long id, String brand, String model, String colour, Double cubiCapacity, Integer hP, Double kW, LocalDate registrationYear, FuelTypeEnum fuelTypeEnum, BigDecimal price, Boolean newVehicle, Double mileage, EmissionTypeEnum emissionTypeEnum, Integer passengerNumber, TransmissionTypeEnum transmissionTypeEnum, CarTypeEnum carTypeEnum, TractionTypeEnum tractionTypeEnum, Boolean optionFullTraction, Integer doors, Boolean centralizedClosing, Boolean airConditioning, Boolean bluetooth, Boolean satNav, Boolean electricRoof, Boolean parkAssist, Boolean spareTire, Boolean antiTheft, StatusTypeEnum statusTypeEnum, String currentLocation, Boolean availableRental) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.cubiCapacity = cubiCapacity;
        this.hP = hP;
        this.kW = kW;
        this.registrationYear = registrationYear;
        this.fuelTypeEnum = fuelTypeEnum;
        this.price = price;
        this.newVehicle = newVehicle;
        this.mileage = mileage;
        this.emissionTypeEnum = emissionTypeEnum;
        this.passengerNumber = passengerNumber;
        this.transmissionTypeEnum = transmissionTypeEnum;
        this.carTypeEnum = carTypeEnum;
        this.tractionTypeEnum = tractionTypeEnum;
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
        this.statusTypeEnum = statusTypeEnum;
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

    public FuelTypeEnum getFuelType() {
        return fuelTypeEnum;
    }

    public void setFuelType(FuelTypeEnum fuelTypeEnum) {
        this.fuelTypeEnum = fuelTypeEnum;
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

    public EmissionTypeEnum getEmissionType() {
        return emissionTypeEnum;
    }

    public void setEmissionType(EmissionTypeEnum emissionTypeEnum) {
        this.emissionTypeEnum = emissionTypeEnum;
    }

    public Integer getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(Integer passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public TransmissionTypeEnum getTransmissionType() {
        return transmissionTypeEnum;
    }

    public void setTransmissionType(TransmissionTypeEnum transmissionTypeEnum) {
        this.transmissionTypeEnum = transmissionTypeEnum;
    }

    public CarTypeEnum getCarType() {
        return carTypeEnum;
    }

    public void setCarType(CarTypeEnum carTypeEnum) {
        this.carTypeEnum = carTypeEnum;
    }

    public TractionTypeEnum getTractionType() {
        return tractionTypeEnum;
    }

    public void setTractionType(TractionTypeEnum tractionTypeEnum) {
        this.tractionTypeEnum = tractionTypeEnum;
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

    public StatusTypeEnum getStatusType() {
        return statusTypeEnum;
    }

    public void setStatusType(StatusTypeEnum statusTypeEnum) {
        this.statusTypeEnum = statusTypeEnum;
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
                ", fuelType=" + fuelTypeEnum +
                ", price=" + price +
                ", newVehicle=" + newVehicle +
                ", mileage=" + mileage +
                ", emissionType=" + emissionTypeEnum +
                ", passengerNumber=" + passengerNumber +
                ", transmissionType=" + transmissionTypeEnum +
                ", carType=" + carTypeEnum +
                ", tractionType=" + tractionTypeEnum +
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
                ", statusType=" + statusTypeEnum +
                ", currentLocation='" + currentLocation + '\'' +
                ", availableRental=" + availableRental +
                '}';
    }
}
