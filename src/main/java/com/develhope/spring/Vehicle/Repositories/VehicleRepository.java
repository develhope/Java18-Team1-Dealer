package com.develhope.spring.Vehicle.Repositories;

import com.develhope.spring.Vehicle.Entities.Enums.*;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE " +
            "(:minPrice IS NULL OR v.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR v.price <= :maxPrice) AND " +
            "(:brand IS NULL OR v.brand = :brand) AND " +
            "(:model IS NULL OR v.model = :model) AND " +
            "(:colour IS NULL OR v.colour = :colour) AND " +
            "(:cubiCapacity IS NULL OR v.cubiCapacity = :cubiCapacity) AND " +
            "(:hP IS NULL OR v.hP = :hP) AND " +
            "(:kW IS NULL OR v.kW = :kW) AND " +
            "(:registrationYear IS NULL OR v.registrationYear = :registrationYear) AND " +
            "(:fuelType IS NULL OR v.fuelType = :fuelType) AND " +
            "(:price IS NULL OR v.price = :price) AND " +
            "(:tradeDiscount IS NULL OR v.tradeDiscount = :tradeDiscount) AND " +
            "(:newVehicle IS NULL OR v.newVehicle = :newVehicle) AND " +
            "(:mileage IS NULL OR v.mileage = :mileage) AND " +
            "(:ageLimit IS NULL OR v.ageLimit = :ageLimit) AND " +
            "(:statusType IS NULL OR v.statusType = :statusType) AND " +
            "(:currentLocation IS NULL OR v.currentLocation = :currentLocation) AND " +
            "(:availableRental IS NULL OR v.availableRental = :availableRental) AND " +
            "(:emissionType IS NULL OR v.emissionType = :emissionType) AND " +
            "(:passengerNumber IS NULL OR v.passengerNumber = :passengerNumber) AND " +
            "(:windShield IS NULL OR v.windShield = :windShield) AND " +
            "(:tailBag IS NULL OR v.tailBag = :tailBag) AND " +
            "(:passengerBackrest IS NULL OR v.passengerBackrest = :passengerBackrest) AND " +
            "(:transmissionType IS NULL OR v.transmissionType = :transmissionType) AND " +
            "(:carType IS NULL OR v.carType = :carType) AND " +
            "(:tractionType IS NULL OR v.tractionType = :tractionType) AND " +
            "(:optionFullTraction IS NULL OR v.optionFullTraction = :optionFullTraction) AND " +
            "(:doors IS NULL OR v.doors = :doors) AND " +
            "(:centralizedClosing IS NULL OR v.centralizedClosing = :centralizedClosing) AND " +
            "(:airConditioning IS NULL OR v.airConditioning = :airConditioning) AND " +
            "(:bluetooth IS NULL OR v.bluetooth = :bluetooth) AND " +
            "(:satNav IS NULL OR v.satNav = :satNav) AND " +
            "(:electricRoof IS NULL OR v.electricRoof = :electricRoof) AND " +
            "(:parkAssist IS NULL OR v.parkAssist = :parkAssist) AND " +
            "(:spareTire IS NULL OR v.spareTire = :spareTire) AND " +
            "(:antiTheft IS NULL OR v.antiTheft = :antiTheft) AND " +
            "(:passengerTransport IS NULL OR v.passengerTransport = :passengerTransport) AND " +
            "(:windowedBackDoor IS NULL OR v.windowedBackDoor = :windowedBackDoor) AND " +
            "(:slideSideDoor IS NULL OR v.slideSideDoor = :slideSideDoor) AND " +
            "(:antiCollisionSystem IS NULL OR v.antiCollisionSystem = :antiCollisionSystem)")
    List<Vehicle> findByAllCriteria(BigDecimal minPrice,
                                    BigDecimal maxPrice,
                                    String brand,
                                    String model,
                                    String colour,
                                    Double cubiCapacity,
                                    Integer hP,
                                    Double kW,
                                    LocalDate registrationYear,
                                    FuelType fuelType,
                                    BigDecimal price,
                                    Double tradeDiscount,
                                    Boolean newVehicle,
                                    Double mileage,
                                    Integer ageLimit,
                                    StatusType statusType,
                                    String currentLocation,
                                    Boolean availableRental,
                                    EmissionType emissionType,
                                    Integer passengerNumber,
                                    Boolean windShield,
                                    Boolean tailBag,
                                    Boolean passengerBackrest,
                                    TransmissionType transmissionType,
                                    CarType carType,
                                    TractionType tractionType,
                                    Boolean optionFullTraction,
                                    Integer doors,
                                    Boolean centralizedClosing,
                                    Boolean airConditioning,
                                    Boolean bluetooth,
                                    Boolean satNav,
                                    Boolean electricRoof,
                                    Boolean parkAssist,
                                    Boolean spareTire,
                                    Boolean antiTheft,
                                    Boolean passengerTransport,
                                    Boolean windowedBackDoor,
                                    Boolean slideSideDoor,
                                    Boolean antiCollisionSystem);
}
