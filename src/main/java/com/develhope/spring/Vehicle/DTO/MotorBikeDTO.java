package com.develhope.spring.Vehicle.DTO;

import com.develhope.spring.Vehicle.Entities.Enums.EmissionTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.FuelTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.TransmissionTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MotorBikeDTO {
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
    private StatusTypeEnum statusTypeEnum;
    private String currentLocation;
    private EmissionTypeEnum emissionTypeEnum;
    private Integer passengerNumber;
    private Boolean windShield;
    private Boolean tailBag;
    private Boolean passengerBackrest;
    private Boolean availableRental;

    public MotorBikeDTO(Long id, String brand, String model, String colour, Double cubiCapacity, Integer hP, Double kW, TransmissionTypeEnum transmissionTypeEnum, LocalDate registrationYear, FuelTypeEnum fuelTypeEnum, BigDecimal price, Boolean newVehicle, Double mileage, StatusTypeEnum statusTypeEnum, String currentLocation, EmissionTypeEnum emissionTypeEnum, Integer passengerNumber, Boolean windShield, Boolean tailBag, Boolean passengerBackrest, Boolean availableRental) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.cubiCapacity = cubiCapacity;
        this.hP = hP;
        this.kW = kW;
        this.transmissionTypeEnum = transmissionTypeEnum;
        this.registrationYear = registrationYear;
        this.fuelTypeEnum = fuelTypeEnum;
        this.price = price;
        this.newVehicle = newVehicle;
        this.mileage = mileage;
        this.statusTypeEnum = statusTypeEnum;
        this.currentLocation = currentLocation;
        this.emissionTypeEnum = emissionTypeEnum;
        this.passengerNumber = passengerNumber;
        this.windShield = windShield;
        this.tailBag = tailBag;
        this.passengerBackrest = passengerBackrest;
        this.availableRental = availableRental;
    }

    public MotorBikeDTO() {
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

    public TransmissionTypeEnum getTransmissionType() {
        return transmissionTypeEnum;
    }

    public void setTransmissionType(TransmissionTypeEnum transmissionTypeEnum) {
        this.transmissionTypeEnum = transmissionTypeEnum;
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
        return "MotorBikeDTO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", cubiCapacity=" + cubiCapacity +
                ", hP=" + hP +
                ", kW=" + kW +
                ", transmissionType=" + transmissionTypeEnum +
                ", registrationYear=" + registrationYear +
                ", fuelType=" + fuelTypeEnum +
                ", price=" + price +
                ", newVehicle=" + newVehicle +
                ", mileage=" + mileage +
                ", statusType=" + statusTypeEnum +
                ", currentLocation='" + currentLocation + '\'' +
                ", emissionType=" + emissionTypeEnum +
                ", passengerNumber=" + passengerNumber +
                ", windShield=" + windShield +
                ", tailBag=" + tailBag +
                ", passengerBackrest=" + passengerBackrest +
                ", availableRental=" + availableRental +
                '}';
    }
}
