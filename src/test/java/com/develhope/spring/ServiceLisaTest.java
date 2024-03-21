package com.develhope.spring;

import com.develhope.spring.User.Services.AdminService;
import com.develhope.spring.Vehicle.DTO.ScooterDTO;
import com.develhope.spring.Vehicle.Entities.Enums.EmissionTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.FuelTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.VehiclesTypeEnum;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Entities.VehicleService;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

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
		vehicle.setVehiclesTypeEnum(VehiclesTypeEnum.SCOOTER);
		vehicle.setBrand("banana");
		vehicle.setModel("fdsgdrfsg");
		vehicle.setColour("fews");
		vehicle.setCubiCapacity(123.0);
		vehicle.setHP(324);
		vehicle.setKW(123.44);
		vehicle.setRegistrationYear(LocalDate.ofEpochDay(2024/4/4));
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
		vehicle.setPassengerBackrest(false);
		return vehicle;
	}

	private Vehicle fakeVehicle2(){
		Vehicle vehicle = new Vehicle();
		vehicle.setId(2l);
		vehicle.setVehiclesTypeEnum(VehiclesTypeEnum.SCOOTER);
		vehicle.setBrand("banana");
		vehicle.setModel("fdsgdrfsg");
		vehicle.setColour("fews");
		vehicle.setCubiCapacity(123.0);
		vehicle.setHP(324);
		vehicle.setKW(123.44);
		vehicle.setRegistrationYear(LocalDate.ofEpochDay(2024/4/4));
		vehicle.setFuelTypeEnum(FuelTypeEnum.GASOLINE);
		vehicle.setPrice(BigDecimal.valueOf(4888));
		vehicle.setTradeDiscount(5.0);
		vehicle.setNewVehicle(false);
		vehicle.setMileage(1000.90);
		vehicle.setAgeLimit(17);
		vehicle.setStatusTypeEnum(StatusTypeEnum.PURCHASABLE);
		vehicle.setCurrentLocation(null);
		vehicle.setAvailableRental(true);
		vehicle.setEmissionTypeEnum(EmissionTypeEnum.EURO4);
		vehicle.setPassengerNumber(2);
		vehicle.setWindShield(false);
		vehicle.setTailBag(false);
		vehicle.setPassengerBackrest(false);
		return vehicle;
	}

	@Transactional
	@Test
	public void createVehicle() throws Exception{
		Vehicle vehicle = fakeVehicle();
		Vehicle newVehicle = adminService.newVehicle(vehicle);

		assertThat(vehicleRepository).isNotNull();
		assertThat(newVehicle.getId()).isEqualTo(vehicle.getId());
	}

	@Transactional
	@Test
	public void deleteVehicle(){
		Vehicle vehicle = fakeVehicle();
		adminService.newVehicle(vehicle);

		assertThat(vehicleRepository).isNotNull();

		Boolean result = adminService.deleteVehicle(vehicle.getId());
		assertThat(result).isTrue();
	}

	@Transactional
	@Test
	public void updateVehicle() throws Exception{
		Vehicle vehicleNotUpdated = fakeVehicle();
		vehicleRepository.save(vehicleNotUpdated);

		Vehicle vehicle2 = fakeVehicle2();

		Vehicle vehicleUpdated = adminService.updateVehicle(vehicleNotUpdated.getId(), vehicle2);

		assertThat(vehicleUpdated.getPassengerNumber()).isEqualTo(vehicle2.getPassengerNumber());
	}

	@Transactional
	@Test
	public void updateStatusTypeEnumOfVehicle(){
		Vehicle vehicleNotUpdated = fakeVehicle();
		Vehicle vehicleToUpdate = vehicleRepository.save(vehicleNotUpdated);

		Vehicle vehicleUpdated = adminService.updateStatusType(vehicleToUpdate.getId(), StatusTypeEnum.SOLD);
		assertThat(vehicleUpdated.getStatusTypeEnum()).isEqualTo(StatusTypeEnum.SOLD);
	}

	@Transactional
	@Test
	public void updatePurchaseById(){}

	@Transactional
	@Test
	public void deletePurchaseById(){}

	@Transactional
	@Test
	public void getVehiclesByStatusTypeEnum(){
		Vehicle vehicle1 = fakeVehicle();
		Vehicle vehicle2 = fakeVehicle2();
		adminService.newVehicle(vehicle1);
		adminService.newVehicle(vehicle2);

		List<Vehicle> vehiclesByStatusTypeEnum = adminService.vehiclesByStatusType(StatusTypeEnum.PURCHASABLE);
		assertThat(vehiclesByStatusTypeEnum).contains(vehicle1,vehicle2);
	}

	@Transactional
	@Test
	public void createVehicleDTO() throws Exception{
		List<Vehicle> allFullVehicles = new ArrayList<>();
		Vehicle fullVehicle = fakeVehicle();

		allFullVehicles.add(fullVehicle);

		ScooterDTO scooter = new ScooterDTO(1l, "rfgsrf", "fdsgdrfsg", "fews", 123.0,
				324, 123.44, LocalDate.ofEpochDay(2024/4/4), FuelTypeEnum.GASOLINE, BigDecimal.valueOf(4888),
				false, 1000.90, StatusTypeEnum.PURCHASABLE, "Palermo", EmissionTypeEnum.EURO4,
				1, false, false, false, true);

		List<Object> result = vehicleService.allVehiclesDTO(allFullVehicles);

		assertThat(result).toString().equals(scooter.toString());
	}

}
