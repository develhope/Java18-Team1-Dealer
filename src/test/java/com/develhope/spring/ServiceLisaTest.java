package com.develhope.spring;

import com.develhope.spring.User.Services.AdminService;
import com.develhope.spring.Vehicle.DTO.ScooterDTO;
import com.develhope.spring.Vehicle.Entities.Enums.EmissionType;
import com.develhope.spring.Vehicle.Entities.Enums.FuelType;
import com.develhope.spring.Vehicle.Entities.Enums.StatusType;
import com.develhope.spring.Vehicle.Entities.Enums.VehiclesType;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Entities.VehicleService;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = "testing")
class ServiceLisaTest {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private AdminService adminService;
	private Vehicle fakeVehicle(){
		Vehicle vehicle = new Vehicle();
		vehicle.setId(1l);
		vehicle.setVehiclesType(VehiclesType.SCOOTER);
		vehicle.setBrand("rfgsrf");
		vehicle.setModel("fdsgdrfsg");
		vehicle.setColour("fews");
		vehicle.setCubiCapacity(123.0);
		vehicle.setHP(324);
		vehicle.setKW(123.44);
		vehicle.setRegistrationYear(LocalDate.ofEpochDay(2024/4/4));
		vehicle.setFuelType(FuelType.GASOLINE);
		vehicle.setPrice(BigDecimal.valueOf(4888));
		vehicle.setTradeDiscount(5.0);
		vehicle.setNewVehicle(false);
		vehicle.setMileage(1000.90);
		vehicle.setAgeLimit(17);
		vehicle.setStatusType(StatusType.PURCHASABLE);
		vehicle.setCurrentLocation("Palermo");
		vehicle.setAvailableRental(true);
		vehicle.setEmissionType(EmissionType.EURO4);
		vehicle.setPassengerNumber(1);
		vehicle.setWindShield(false);
		vehicle.setTailBag(false);
		vehicle.setPassengerBackrest(false);
		return vehicle;
	}
	private Vehicle fakeVehicle2(){
		Vehicle vehicle = new Vehicle();
		vehicle.setId(2l);
		vehicle.setVehiclesType(VehiclesType.SCOOTER);
		vehicle.setBrand("rfgsrf");
		vehicle.setModel("fdsgdrfsg");
		vehicle.setColour("fews");
		vehicle.setCubiCapacity(123.0);
		vehicle.setHP(324);
		vehicle.setKW(123.44);
		vehicle.setRegistrationYear(LocalDate.ofEpochDay(2024/4/4));
		vehicle.setFuelType(FuelType.GASOLINE);
		vehicle.setPrice(BigDecimal.valueOf(4888));
		vehicle.setTradeDiscount(5.0);
		vehicle.setNewVehicle(false);
		vehicle.setMileage(1000.90);
		vehicle.setAgeLimit(17);
		vehicle.setStatusType(StatusType.PURCHASABLE);
		vehicle.setCurrentLocation("Palermo");
		vehicle.setAvailableRental(true);
		vehicle.setEmissionType(EmissionType.EURO4);
		vehicle.setPassengerNumber(1);
		vehicle.setWindShield(false);
		vehicle.setTailBag(false);
		vehicle.setPassengerBackrest(false);
		return vehicle;
	}

	@Test
	public void createVehicle() throws Exception{
		Vehicle vehicle = fakeVehicle();
		Vehicle newVehicle = adminService.newVehicle(vehicle);

		assertThat(newVehicle.getId()).isEqualTo(vehicle.getId());
	}
	@Test
	public void createVeicleDTO() throws Exception{
		//TODO: la funzione fa quel che deve, test non passa causa hashcode
		List<Vehicle> allFullVehicles = new ArrayList<>();
		Vehicle fullVehicle = fakeVehicle();
		Vehicle fullVehicle2 = fakeVehicle2();
		allFullVehicles.add(fullVehicle);
		allFullVehicles.add(fullVehicle2);

		ScooterDTO scooter = new ScooterDTO(1l, "rfgsrf", "fdsgdrfsg", "fews", 123.0,
				324, 123.44, LocalDate.ofEpochDay(2024/4/4), FuelType.GASOLINE, BigDecimal.valueOf(4888),
				false, 1000.90, StatusType.PURCHASABLE, "Palermo", EmissionType.EURO4,
				1, false, false, false, true);
		List<Object> result = vehicleService.allVehiclesDTO(allFullVehicles);

		assertThat(result).contains(scooter);
	}

}
