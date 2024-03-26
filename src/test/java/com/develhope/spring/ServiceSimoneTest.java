package com.develhope.spring;

import com.develhope.spring.User.Services.CustomerService;
import com.develhope.spring.Vehicle.Entities.Enums.EmissionTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.FuelTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.VehiclesTypeEnum;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Entities.VehicleService;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ServiceSimoneTest {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private CustomerService customerService;
    private Vehicle createAVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehiclesTypeEnum(VehiclesTypeEnum.SCOOTER);
        vehicle.setBrand("Toyota");
        vehicle.setModel("yaris");
        vehicle.setColour("blue");
        vehicle.setCubiCapacity(123.0);
        vehicle.setHP(324);
        vehicle.setKW(123.44);
        vehicle.setRegistrationYear(LocalDate.ofEpochDay(2024 / 4 / 4));
        vehicle.setFuelTypeEnum(FuelTypeEnum.GASOLINE);
        vehicle.setPrice(BigDecimal.valueOf(4888));
        vehicle.setTradeDiscount(5.0);
        vehicle.setNewVehicle(false);
        vehicle.setMileage(1000.90);
        vehicle.setAgeLimit(17);
        vehicle.setStatusTypeEnum(StatusTypeEnum.PURCHASABLE);
        vehicle.setCurrentLocation("Palermo");
        vehicle.setAvailableRental(true);
        vehicle.setEmissionTypeEnum(EmissionTypeEnum.EURO4);
        vehicle.setPassengerNumber(1);
        vehicle.setWindShield(false);
        vehicle.setTailBag(false);
        return vehicleRepository.save(vehicle);
    }
    @Test
    void checkIfVehicleListForParamsKeyAndValueAreValid(){

        Vehicle vehicle = createAVehicle();

        String validKey = "model";
        Object value = "yaris";

        assertDoesNotThrow(() -> {
            List<Vehicle> result = customerService.vehicleListForParams(validKey, value);
            // Verifica che il risultato non sia vuoto
            assertThat(result).isNotEmpty();
        });
    }
    @Test
    void checkIfVehicleListForParamsKeyIsInvalid(){
        String invalidKey = "invalidKey";
        Object value = "yaris";
        //Errore copiato dall'errore che si crea
        assertThrows(InvalidDataAccessApiUsageException.class, () -> {
            customerService.vehicleListForParams(invalidKey, value);
        });
    }

    @Test
    void checkIfVehicleListForParamsValueNotExist(){

        Vehicle vehicle = createAVehicle();

        String validKey = "model";
        Object value = "banana";

        assertDoesNotThrow(() -> {
            List<Vehicle> result = customerService.vehicleListForParams(validKey, value);
            // Verifica che il risultato sia vuoto
            assertThat(result).isEmpty();
        });
    }
}
