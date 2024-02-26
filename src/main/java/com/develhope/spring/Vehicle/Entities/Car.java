package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.Entities.Enums.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Car")
@Table(name= "car")
public class Car extends Vehicle{
    @Column(nullable = false)
    private CarType carType;
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

    public Car(Long id, VehiclesType vehiclesType, String brand, String model, Double cubiCapacity, String colour, Integer hP, Double kW, TransmissionType transmissionType, LocalDate registrationYear, FuelType fuelType, BigDecimal price, Double tradeDiscount, Boolean newVehicle, Double mileage, Integer ageLimit, StatusType statusType, String currentLocation, Boolean availableRental, EmissionType emissionType, Integer passengerNumber, CarType carType, TractionType tractionType, Boolean optionFullTraction, Integer doors, Boolean centralizedClosing, Boolean airConditioning, Boolean bluetooth, Boolean satNav, Boolean eletricRoof, Boolean parkAssist, Boolean spareTire, Boolean antiTheft) {
        super(id, vehiclesType, brand, model, cubiCapacity, colour, hP, kW, transmissionType, registrationYear, fuelType, price, tradeDiscount, newVehicle, mileage, ageLimit, statusType, currentLocation, availableRental, emissionType, passengerNumber);
        this.carType = carType;
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

    public Car() {
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

    public Boolean getEletricRoof() {
        return eletricRoof;
    }

    public void setEletricRoof(Boolean eletricRoof) {
        this.eletricRoof = eletricRoof;
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

    @Override
    public String toString() {
        return "Car{" +
                "carType=" + carType +
                ", tractionType=" + tractionType +
                ", optionFullTraction=" + optionFullTraction +
                ", doors=" + doors +
                ", centralizedClosing=" + centralizedClosing +
                ", airConditioning=" + airConditioning +
                ", bluetooth=" + bluetooth +
                ", satNav=" + satNav +
                ", eletricRoof=" + eletricRoof +
                ", parkAssist=" + parkAssist +
                ", spareTire=" + spareTire +
                ", antiTheft=" + antiTheft +
                '}';
    }
}
