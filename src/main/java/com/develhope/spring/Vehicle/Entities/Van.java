package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.Entities.Enums.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Van")
@Table(name = "van")
public class Van extends Vehicle{
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
    @Column(nullable = false, columnDefinition = "Presenza ruota di scorta")
    private Boolean spareTire;
    @Column(nullable = false, columnDefinition = "Presenza del sistema antifurto")
    private Boolean antiTheft;
    @Column(nullable = false, columnDefinition = "Presenza porta posteriore finestrata")
    private Boolean windowedBackDoor;
    @Column(nullable = false, columnDefinition = "Presenza porta laterale scorrevole")
    private Boolean slideSideDoor;
    @Column(nullable = false, columnDefinition = "Presenza navigatore con retrocamera")
    private Boolean reversingCam;
    @Column(nullable = false, columnDefinition = "Presenza del sistema anticollisione")
    private Boolean antiCollisionSystem;

    public Van(Long id, VehiclesType vehiclesType, String brand, String model, Double cubiCapacity, String colour, Integer hP, Double kW, TransmissionType transmissionType, LocalDate registrationYear, FuelType fuelType, BigDecimal price, Double tradeDiscount, Boolean newVehicle, Double mileage, Integer ageLimit, StatusType statusType, String currentLocation, Boolean availableRental, EmissionType emissionType, Integer passengerNumber, TractionType tractionType, Boolean optionFullTraction, Integer doors, Boolean centralizedClosing, Boolean airConditioning, Boolean bluetooth, Boolean satNav, Boolean spareTire, Boolean antiTheft, Boolean windowedBackDoor, Boolean slideSideDoor, Boolean reversingCam, Boolean antiCollisionSystem) {
        super(id, vehiclesType, brand, model, cubiCapacity, colour, hP, kW, transmissionType, registrationYear, fuelType, price, tradeDiscount, newVehicle, mileage, ageLimit, statusType, currentLocation, availableRental, emissionType, passengerNumber);
        this.tractionType = tractionType;
        this.optionFullTraction = optionFullTraction;
        this.doors = doors;
        this.centralizedClosing = centralizedClosing;
        this.airConditioning = airConditioning;
        this.bluetooth = bluetooth;
        this.satNav = satNav;
        this.spareTire = spareTire;
        this.antiTheft = antiTheft;
        this.windowedBackDoor = windowedBackDoor;
        this.slideSideDoor = slideSideDoor;
        this.reversingCam = reversingCam;
        this.antiCollisionSystem = antiCollisionSystem;
    }

    public Van() {
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

    public Boolean getWindowedBackDoor() {
        return windowedBackDoor;
    }

    public void setWindowedBackDoor(Boolean windowedBackDoor) {
        this.windowedBackDoor = windowedBackDoor;
    }

    public Boolean getSlideSideDoor() {
        return slideSideDoor;
    }

    public void setSlideSideDoor(Boolean slideSideDoor) {
        this.slideSideDoor = slideSideDoor;
    }

    public Boolean getReversingCam() {
        return reversingCam;
    }

    public void setReversingCam(Boolean reversingCam) {
        this.reversingCam = reversingCam;
    }

    public Boolean getAntiCollisionSystem() {
        return antiCollisionSystem;
    }

    public void setAntiCollisionSystem(Boolean antiCollisionSystem) {
        this.antiCollisionSystem = antiCollisionSystem;
    }

    @Override
    public String toString() {
        return "Van{" +
                "tractionType=" + tractionType +
                ", optionFullTraction=" + optionFullTraction +
                ", doors=" + doors +
                ", centralizedClosing=" + centralizedClosing +
                ", airConditioning=" + airConditioning +
                ", bluetooth=" + bluetooth +
                ", satNav=" + satNav +
                ", spareTire=" + spareTire +
                ", antiTheft=" + antiTheft +
                ", windowedBackDoor=" + windowedBackDoor +
                ", slideSideDoor=" + slideSideDoor +
                ", reversingCam=" + reversingCam +
                ", antiCollisionSystem=" + antiCollisionSystem +
                '}';
    }
}
