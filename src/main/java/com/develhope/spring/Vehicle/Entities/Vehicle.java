package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.Vehicle.Entities.Enums.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private VehiclesType vehiclesType;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String colour;
    @Column(nullable = false)
    private Double cubiCapacity;
    @Column(nullable = false)
    private Integer hP;
    @Column(nullable = false)
    private Double kW;
    @Column(nullable = false)
    private LocalDate registrationYear;
    @Column(nullable = false)
    private FuelType fuelType;
    @Column(nullable = false)
    private BigDecimal price;
    @Column
    private Double tradeDiscount;
    @Column(nullable = false)
    private Boolean newVehicle;
    @Column
    private Double mileage;
    @Column(nullable = false)
    private Integer ageLimit;
    @Column(nullable = false)
    private StatusType statusType;
    @Column(nullable = false)
    private String currentLocation;
    @Column(nullable = false)
    private Boolean availableRental;
    @Column(nullable = false)
    private EmissionType emissionType;
    @Column(nullable = false)
    private Integer passengerNumber;

    //solo scooter e moto
    @Column
    private Boolean windShield;
    @Column
    private Boolean tailBag;
    @Column
    private Boolean passengerBackrest;

    //motor, car e van
    @Column
    private TransmissionType transmissionType;

    //solo car
    @Column
    private CarType carType;

    //car e van
    @Column
    private TractionType tractionType;
    @Column
    private Boolean optionFullTraction;
    @Column
    private Integer doors;
    @Column
    private Boolean centralizedClosing;
    @Column
    private Boolean airConditioning;
    @Column
    private Boolean bluetooth;
    @Column
    private Boolean satNav;
    @Column
    private Boolean electricRoof;
    @Column
    private Boolean parkAssist;
    @Column
    private Boolean spareTire;
    @Column
    private Boolean antiTheft;

    //solo van
    @Column
    private Boolean passengerTransport;
    @Column
    private Boolean windowedBackDoor;
    @Column
    private Boolean slideSideDoor;
    @Column
    private Boolean antiCollisionSystem;




    @OneToOne
    private Purchase purchase;
    @OneToOne
    private  Rent rent;

    public Vehicle(Long id, VehiclesType vehiclesType, String brand, String model, String colour, Double cubiCapacity, Integer hP, Double kW, LocalDate registrationYear, FuelType fuelType, BigDecimal price, Double tradeDiscount, Boolean newVehicle, Double mileage, Integer ageLimit, StatusType statusType, String currentLocation, Boolean availableRental, EmissionType emissionType, Integer passengerNumber, Boolean windShield, Boolean tailBag, Boolean passengerBackrest, TransmissionType transmissionType, CarType carType, TractionType tractionType, Boolean optionFullTraction, Integer doors, Boolean centralizedClosing, Boolean airConditioning, Boolean bluetooth, Boolean satNav, Boolean electricRoof, Boolean parkAssist, Boolean spareTire, Boolean antiTheft, Boolean passengerTransport, Boolean windowedBackDoor, Boolean slideSideDoor, Boolean antiCollisionSystem, Purchase purchase, Rent rent) {
        this.id = id;
        this.vehiclesType = vehiclesType;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.cubiCapacity = cubiCapacity;
        this.hP = hP;
        this.kW = kW;
        this.registrationYear = registrationYear;
        this.fuelType = fuelType;
        this.price = price;
        this.tradeDiscount = tradeDiscount;
        this.newVehicle = newVehicle;
        this.mileage = mileage;
        this.ageLimit = ageLimit;
        this.statusType = statusType;
        this.currentLocation = currentLocation;
        this.availableRental = availableRental;
        this.emissionType = emissionType;
        this.passengerNumber = passengerNumber;
        this.windShield = windShield;
        this.tailBag = tailBag;
        this.passengerBackrest = passengerBackrest;
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
        this.passengerTransport = passengerTransport;
        this.windowedBackDoor = windowedBackDoor;
        this.slideSideDoor = slideSideDoor;
        this.antiCollisionSystem = antiCollisionSystem;
        this.purchase = purchase;
        this.rent = rent;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Boolean getPassengerTransport() {
        return passengerTransport;
    }

    public void setPassengerTransport(Boolean passengerTransport) {
        this.passengerTransport = passengerTransport;
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

    public Boolean getAntiCollisionSystem() {
        return antiCollisionSystem;
    }

    public void setAntiCollisionSystem(Boolean antiCollisionSystem) {
        this.antiCollisionSystem = antiCollisionSystem;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehiclesType=" + vehiclesType +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", cubiCapacity=" + cubiCapacity +
                ", hP=" + hP +
                ", kW=" + kW +
                ", registrationYear=" + registrationYear +
                ", fuelType=" + fuelType +
                ", price=" + price +
                ", tradeDiscount=" + tradeDiscount +
                ", newVehicle=" + newVehicle +
                ", mileage=" + mileage +
                ", ageLimit=" + ageLimit +
                ", statusType=" + statusType +
                ", currentLocation='" + currentLocation + '\'' +
                ", availableRental=" + availableRental +
                ", emissionType=" + emissionType +
                ", passengerNumber=" + passengerNumber +
                ", windShield=" + windShield +
                ", tailBag=" + tailBag +
                ", passengerBackrest=" + passengerBackrest +
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
                ", passengerTransport=" + passengerTransport +
                ", windowedBackDoor=" + windowedBackDoor +
                ", slideSideDoor=" + slideSideDoor +
                ", antiCollisionSystem=" + antiCollisionSystem +
                ", purchase=" + purchase +
                ", rent=" + rent +
                '}';
    }
}