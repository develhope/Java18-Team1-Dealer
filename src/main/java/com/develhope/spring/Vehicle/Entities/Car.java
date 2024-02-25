package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.Entities.Enums.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Car")
@Table(name= "car")
public class Car extends Vehicle{
    @Column(nullable = false, columnDefinition = "Tipo di auto")
    private CarType carType;
    @Column(nullable = false, columnDefinition = "Tipo di trazione")
    private TractionType tractionType;
    @Column(nullable = false, columnDefinition = "4x4 inseribile")
    private Boolean optionFullTraction;
    @Column(nullable = false, columnDefinition = "Numero di porte")
    private Integer doors;
    @Column(nullable = false, columnDefinition = "Presenza di chiusura centralizzata")
    private Boolean centralizedClosing;
    @Column(nullable = false, columnDefinition = "Presenza di aria condizionata")
    private Boolean airConditioning;
    @Column(nullable = false, columnDefinition = "Presenza del bluetooth")
    private Boolean bluetooth;
    @Column(nullable = false, columnDefinition = "Presenza del navigatore satellitare")
    private Boolean satNav;
    @Column(nullable = false, columnDefinition = "Presenza del tettuccio apribile")
    private Boolean eletricRoof;
    @Column(nullable = false, columnDefinition = "Presenza dell'assistenza al parcheggio")
    private Boolean parkAssist;
    @Column(nullable = false, columnDefinition = "Presenza ruota di scorta")
    private Boolean spareTire;
    @Column(nullable = false, columnDefinition = "Presenza del sistema antifurto")
    private Boolean antiTheft;

    public Car(Long id, VehiclesType vehiclesType, String brand, String model, Double cubiCapacity, String colour, Integer hP, Double kW, TransmissionType transmissionType, LocalDate registrationYear, FuelType fuelType, BigDecimal price, Double tradeDiscount, Boolean newVehicle, Double mileage, Integer ageLimit, StatusType statusType, String currentLocation, Boolean availableRental, CarType carType, TractionType tractionType, Boolean optionFullTraction, Integer doors, Boolean centralizedClosing, Boolean airConditioning, Boolean bluetooth, Boolean satNav, Boolean eletricRoof, Boolean parkAssist, Boolean spareTire, Boolean antiTheft) {
        super(id, vehiclesType, brand, model, cubiCapacity, colour, hP, kW, transmissionType, registrationYear, fuelType, price, tradeDiscount, newVehicle, mileage, ageLimit, statusType, currentLocation, availableRental);
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
