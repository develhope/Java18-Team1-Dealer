package com.develhope.spring.Vehicle.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jdk.jfr.Description;
import jdk.jshell.Snippet;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
public class Vehicle {
    @Column(nullable = false, columnDefinition = "Tipo di veicolo")
    private VehiclesType vehiclesType;
    @Column(nullable = false, columnDefinition = "Brand del veicolo")
    private String brand;
    @Column(nullable = false, columnDefinition = "Modello del veicolo")
    private String model;
    @Column(nullable = false, columnDefinition = "Cilindrata del veicolo")
    private Double cubiCapacity;
    @Column(nullable = false, columnDefinition = "Colore del veicolo")
    private String colour;
    @Column(nullable = false, columnDefinition = "Cavalli del veicolo")
    private Integer hP;
    @Column(nullable = false, columnDefinition = "Kilowat del veicolo")
    private Double kW;
    @Column(nullable = false, columnDefinition = "Trasmissione del veicolo")
    private String transmission;
    @Column(nullable = false, columnDefinition = "Anno di registrazione del veicolo")
    private LocalDate registrationYear;
    @Column(nullable = false, columnDefinition = "Alimentazione del veicolo")
    private String powerSupply;
    @Column(nullable = false, columnDefinition = "Prezzo del veicolo")
    private BigDecimal price;
    @Column(nullable = true, columnDefinition = "Sconto sul prezzo del veicolo")
    private Double tradeDiscount;
    @Column(nullable = false, columnDefinition = "Il veicolo è nuovo o usato")
    private Boolean newVehicle;
    @Column(nullable = true, columnDefinition = "Kilometri percorsi")
    private Double mileage;
    @Column(nullable = false, columnDefinition = "Età minima per acquistare/prenotare il veicolo")
    private Integer ageLimit;
    @Column(nullable = false, columnDefinition = "Flag 'ordinabile,acquistabile,non disponibile' del veicolo")
    private StatusType statusType;
    @Column(nullable = false, columnDefinition = "Locazione attuale del veicolo")
    private String currentLocation;
    @Column(nullable = false, columnDefinition = "Disponibilità al noleggio del veicolo")
    private Boolean availableRental;

    public VehiclesType getVehiclesType() {
        return vehiclesType;
    }

    public void setVehiclesType(VehiclesType vehiclesType) {
        this.vehiclesType = vehiclesType;
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

    public Double getCubiCapacity() {
        return cubiCapacity;
    }

    public void setCubiCapacity(Double cubiCapacity) {
        this.cubiCapacity = cubiCapacity;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public LocalDate getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(LocalDate registrationYear) {
        this.registrationYear = registrationYear;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getTradeDiscount() {
        return tradeDiscount;
    }

    public void setTradeDiscount(Double tradeDiscount) {
        this.tradeDiscount = tradeDiscount;
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

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
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

    public Vehicle(VehiclesType vehiclesType, String brand, String model, Double cubiCapacity, String colour, Integer hP, Double kW, String transmission, LocalDate registrationYear, String powerSupply, BigDecimal price, Double tradeDiscount, Boolean newVehicle, Double mileage, Integer ageLimit, StatusType statusType, String currentLocation, Boolean availableRental) {
        this.vehiclesType = vehiclesType;
        this.brand = brand;
        this.model = model;
        this.cubiCapacity = cubiCapacity;
        this.colour = colour;
        this.hP = hP;
        this.kW = kW;
        this.transmission = transmission;
        this.registrationYear = registrationYear;
        this.powerSupply = powerSupply;
        this.price = price;
        this.tradeDiscount = tradeDiscount;
        this.newVehicle = newVehicle;
        this.mileage = mileage;
        this.ageLimit = ageLimit;
        this.statusType = statusType;
        this.currentLocation = currentLocation;
        this.availableRental = availableRental;
    }

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehiclesType=" + vehiclesType +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", cubiCapacity=" + cubiCapacity +
                ", colour='" + colour + '\'' +
                ", hP=" + hP +
                ", kW=" + kW +
                ", transmission='" + transmission + '\'' +
                ", registrationYear=" + registrationYear +
                ", powerSupply='" + powerSupply + '\'' +
                ", price=" + price +
                ", tradeDiscount=" + tradeDiscount +
                ", newVehicle=" + newVehicle +
                ", mileage=" + mileage +
                ", ageLimit=" + ageLimit +
                ", statusType=" + statusType +
                ", currentLocation='" + currentLocation + '\'' +
                ", availableRental=" + availableRental +
                '}';
    }
}
