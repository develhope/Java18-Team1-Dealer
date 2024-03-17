package com.develhope.spring;

import com.develhope.spring.Purchase.Entities.DTO.AdminPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Enums.VehicleStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.User.Controllers.AdminController;
import com.develhope.spring.User.Controllers.CustomerController;
import com.develhope.spring.User.Controllers.SalesmanController;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Entities.Salesman;
import com.develhope.spring.Vehicle.Entities.Enums.EmissionType;
import com.develhope.spring.Vehicle.Entities.Enums.FuelType;
import com.develhope.spring.Vehicle.Entities.Enums.StatusType;
import com.develhope.spring.Vehicle.Entities.Enums.VehiclesType;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = "testing")
class ControllerTests {
    @Autowired
    private AdminController adminController;
    @Autowired
    private CustomerController customerController;
    @Autowired
    private SalesmanController salesmanController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private VehicleRepository vehicleRepository;
    private Vehicle createAVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehiclesType(VehiclesType.SCOOTER);
        vehicle.setBrand("rfgsrf");
        vehicle.setModel("fdsgdrfsg");
        vehicle.setColour("fews");
        vehicle.setCubiCapacity(123.0);
        vehicle.setHP(324);
        vehicle.setKW(123.44);
        vehicle.setRegistrationYear(LocalDate.ofEpochDay(2024 / 4 / 4));
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
        return vehicleRepository.save(vehicle);
    }

    @Transactional
    @Test
    void checkAdminControllerIsNotNull() throws Exception {
        assertThat(adminController).isNotNull();
    }
    @Transactional
    @Test
    void checkCustomerControllerIsNotNull() throws Exception {
        assertThat(customerController).isNotNull();
    }
    @Transactional
    @Test
    void checkSalesmanControllerIsNotNull() throws Exception {
        assertThat(salesmanController).isNotNull();
    }

    @Transactional
    @Test
    void testCreateNewAdminPurchase() throws Exception {
        Vehicle vehicle = createAVehicle();
        AdminPurchaseCreationDTO adminPurchase = new AdminPurchaseCreationDTO();
        adminPurchase.setIdVehicle(vehicle.getId());
        adminPurchase.setSalesman(new Salesman(1L,"euqeuquuqw","fghfgwhjgf",2,null,null));
        adminPurchase.setCustomer(new Customer(1L,"ufuegfugfe","ksdfksfks","264298","273823394",null,null));
        adminPurchase.setVehicleStatus(VehicleStatusEnum.PURCHASED);


        mockMvc.perform(post("/admin/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(adminPurchase)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vehicle").exists())
                .andExpect(jsonPath("$.salesman").value(adminPurchase.getSalesman()))
                .andExpect(jsonPath("$.customer").value(adminPurchase.getCustomer()))
                .andExpect(jsonPath("$.vehicleStatusEnum").value(adminPurchase.getVehicleStatus()));
    }
}
