package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.Entities.Enums.FuelType;
import com.develhope.spring.Vehicle.Entities.Enums.StatusType;
import com.develhope.spring.Vehicle.Entities.Enums.TransmissionType;
import com.develhope.spring.Vehicle.Entities.Enums.VehiclesType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Scooter")
@Table(name = "scooter")
public class Scooter extends Vehicle{
    @Column(nullable = false, columnDefinition = "Presenza di paravento")
    private Boolean windShield;
    @Column(nullable = false, columnDefinition = "Presenza borsa posteriore")
    private Boolean tailBag;
    @Column(nullable = false, columnDefinition = "Presenza schienale passeggero")
    private Boolean passengerBackrest;
    @Column(nullable = false, columnDefinition = "Presenza maniglie riscaldate")
    private Boolean heatedGrips;

    public Scooter(Long id, VehiclesType vehiclesType, String brand, String model, Double cubiCapacity, String colour, Integer hP, Double kW, TransmissionType transmissionType, LocalDate registrationYear, FuelType fuelType, BigDecimal price, Double tradeDiscount, Boolean newVehicle, Double mileage, Integer ageLimit, StatusType statusType, String currentLocation, Boolean availableRental, Boolean windShield, Boolean tailBag, Boolean passengerBackrest, Boolean heatedGrips) {
        super(id, vehiclesType, brand, model, cubiCapacity, colour, hP, kW, transmissionType, registrationYear, fuelType, price, tradeDiscount, newVehicle, mileage, ageLimit, statusType, currentLocation, availableRental);
        this.windShield = windShield;
        this.tailBag = tailBag;
        this.passengerBackrest = passengerBackrest;
        this.heatedGrips = heatedGrips;
    }

    public Scooter() {
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

    public Boolean getHeatedGrips() {
        return heatedGrips;
    }

    public void setHeatedGrips(Boolean heatedGrips) {
        this.heatedGrips = heatedGrips;
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "windShield=" + windShield +
                ", tailBag=" + tailBag +
                ", passengerBackrest=" + passengerBackrest +
                ", heatedGrips=" + heatedGrips +
                '}';
    }
}
