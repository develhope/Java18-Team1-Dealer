package com.develhope.spring;

import com.develhope.spring.Vehicle.Entities.Enums.EmissionType;
import com.develhope.spring.Vehicle.Entities.Enums.FuelType;
import com.develhope.spring.Vehicle.Entities.Enums.StatusType;
import com.develhope.spring.Vehicle.Entities.Enums.VehiclesType;
import com.develhope.spring.Vehicle.Entities.Scooter;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Entities.VehicleService;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles(value = "test")
class ApplicationTests {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private VehicleService vehicleService;

	@Test
	void createVehicle() throws Exception{
		Scooter scooter = new Scooter();
		scooter.setId(2l);
		scooter.setVehiclesType(VehiclesType.SCOOTER);
		scooter.setBrand("rfgsrf");
		scooter.setModel("fdsgdrfsg");
		scooter.setColour("fews");
		scooter.setHP(324);
		scooter.setKW(123.44);
		scooter.setRegistrationYear(LocalDate.ofEpochDay(2024/4/4));
		scooter.setFuelType(FuelType.GASOLINE);
		scooter.setPrice(BigDecimal.valueOf(4888));
		scooter.setTradeDiscount(5.0);
		scooter.setNewVehicle(false);
		scooter.setMileage(1000.90);
		scooter.setAgeLimit(17);
		scooter.setStatusType(StatusType.PURCHASABLE);
		scooter.setCurrentLocation("Palermo");
		scooter.setAvailableRental(true);
		scooter.setEmissionType(EmissionType.EURO4);
		scooter.setPassengerNumber(1);
		scooter.setWindShield(false);
		scooter.setTailBag(false);
		scooter.setPassengerBackrest(false);
		scooter.setHeatedGrips(true);

		Vehicle vehicleDB = vehicleService.createVehicle(VehiclesType.SCOOTER, scooter);
		assertThat(vehicleDB.getId()).isEqualTo(scooter.getId());
	}

}
