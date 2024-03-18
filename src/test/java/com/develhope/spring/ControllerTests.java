package com.develhope.spring;

import com.develhope.spring.Purchase.Entities.DTO.AdminPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Enums.VehicleStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
import com.develhope.spring.User.Controllers.AdminController;
import com.develhope.spring.User.Controllers.CustomerController;
import com.develhope.spring.User.Controllers.SalesmanController;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Entities.Salesman;
import com.develhope.spring.User.Repositories.CustomerRepository;
import com.develhope.spring.User.Repositories.SalesmanRepository;
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
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    @Autowired
    private SalesmanRepository salesmanRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

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
    private Salesman createASalesman() {
        Salesman salesman = new Salesman();
        salesman.setPhone("12111313");
        salesman.setAddress("hdadjajdjka");
        salesman.setSalesNumber(1);
        salesman.setFirstName("djdjal");
        salesman.setLastName("jhdjald");
        salesman.setEmail(getRandomString());
        salesman.setPassword("jkdkasjdkal");
        return salesmanRepository.save(salesman);
    }

    private Customer createACustomer() {
        Customer customer = new Customer();
        customer.setFirstName("kadkaskldad");
        customer.setLastName("jakdasldaslk");
        customer.setEmail(getRandomString());
        customer.setPassword("adlakdslak");
        customer.setPhone("81839813");
        customer.setAddress("jadjlkasda");
        customer.setCreditCard("198239129389");
        customer.setTaxId(getRandomString());
        return customerRepository.save(customer);
    }

    private Purchase createAPurchase() {
        Purchase purchase = new Purchase();
        purchase.setAdvancePayment(BigDecimal.valueOf(4000));
        purchase.setIsPaid(true);
        purchase.setOrderStatusEnum(OrderStatusEnum.COMPLETED);
        purchase.setVehicleStatusEnum(VehicleStatusEnum.PURCHASED);
        purchase.setVehicle(createAVehicle());
        purchase.setSalesman(createASalesman());
        purchase.setCustomer(createACustomer());
        return purchaseRepository.save(purchase);
    }
    private String getRandomString() {
        Random random = new Random();
        return random.ints(97, 122)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
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
                .andExpect(jsonPath("$.vehicleStatusEnum").value(adminPurchase.getVehicleStatus().toString()));
    }
    @Transactional
    @Test
    void customerCheckIfVehicleExist() throws Exception {
        Vehicle vehicle = createAVehicle();

        mockMvc.perform(get("/customer/get/info/" + vehicle.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehicle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.vehiclesType").value(vehicle.getVehiclesType().toString()))
                .andExpect(jsonPath("$.brand").value(vehicle.getBrand()))
                .andExpect(jsonPath("$.model").value(vehicle.getModel()))
                .andExpect(jsonPath("$.colour").value(vehicle.getColour()))
                .andExpect(jsonPath("$.cubiCapacity").value(vehicle.getCubiCapacity()))
                .andExpect(jsonPath("$.hp").value(vehicle.getHP()))
                .andExpect(jsonPath("$.kw").value(vehicle.getKW()))
                .andExpect(jsonPath("$.registrationYear").value(vehicle.getRegistrationYear().toString()))
                .andExpect(jsonPath("$.fuelType").value(vehicle.getFuelType().toString()))
                .andExpect(jsonPath("$.price").value(vehicle.getPrice()))
                .andExpect(jsonPath("$.tradeDiscount").value(vehicle.getTradeDiscount()))
                .andExpect(jsonPath("$.newVehicle").value(vehicle.getNewVehicle()))
                .andExpect(jsonPath("$.mileage").value(vehicle.getMileage()))
                .andExpect(jsonPath("$.ageLimit").value(vehicle.getAgeLimit()))
                .andExpect(jsonPath("$.statusType").value(vehicle.getStatusType().toString()))
                .andExpect(jsonPath("$.currentLocation").value(vehicle.getCurrentLocation()))
                .andExpect(jsonPath("$.availableRental").value(vehicle.getAvailableRental()))
                .andExpect(jsonPath("$.emissionType").value(vehicle.getEmissionType().toString()))
                .andExpect(jsonPath("$.passengerNumber").value(vehicle.getPassengerNumber()))
                .andExpect(jsonPath("$.windShield").value(vehicle.getWindShield()))
                .andExpect(jsonPath("$.tailBag").value(vehicle.getTailBag()));

    }
    @Transactional
    @Test
    void testCreateNewCustomerPurchase() throws Exception {
        Vehicle vehicle = createAVehicle();
        AdminPurchaseCreationDTO adminPurchase = new AdminPurchaseCreationDTO();
        adminPurchase.setIdVehicle(vehicle.getId());
        adminPurchase.setCustomer(new Customer(1L,"ufuegfugfe","ksdfksfks","264298","273823394",null,null));
        adminPurchase.setVehicleStatus(VehicleStatusEnum.PURCHASED);


        mockMvc.perform(post("/customer/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(adminPurchase)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vehicle").exists())
                .andExpect(jsonPath("$.customer").value(adminPurchase.getCustomer()))
                .andExpect(jsonPath("$.vehicleStatusEnum").value(adminPurchase.getVehicleStatus().toString()));
    }
    @Transactional
    @Test
    void salesmanCheckIfVehicleExist() throws Exception {
        Vehicle vehicle = createAVehicle();

        mockMvc.perform(get("/salesman/get/info/" + vehicle.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.vehiclesType").value(vehicle.getVehiclesType().toString()))
                .andExpect(jsonPath("$.brand").value(vehicle.getBrand()))
                .andExpect(jsonPath("$.model").value(vehicle.getModel()))
                .andExpect(jsonPath("$.colour").value(vehicle.getColour()))
                .andExpect(jsonPath("$.cubiCapacity").value(vehicle.getCubiCapacity()))
                .andExpect(jsonPath("$.hp").value(vehicle.getHP()))
                .andExpect(jsonPath("$.kw").value(vehicle.getKW()))
                .andExpect(jsonPath("$.registrationYear").value(vehicle.getRegistrationYear().toString()))
                .andExpect(jsonPath("$.fuelType").value(vehicle.getFuelType().toString()))
                .andExpect(jsonPath("$.price").value(vehicle.getPrice()))
                .andExpect(jsonPath("$.tradeDiscount").value(vehicle.getTradeDiscount()))
                .andExpect(jsonPath("$.newVehicle").value(vehicle.getNewVehicle()))
                .andExpect(jsonPath("$.mileage").value(vehicle.getMileage()))
                .andExpect(jsonPath("$.ageLimit").value(vehicle.getAgeLimit()))
                .andExpect(jsonPath("$.statusType").value(vehicle.getStatusType().toString()))
                .andExpect(jsonPath("$.currentLocation").value(vehicle.getCurrentLocation()))
                .andExpect(jsonPath("$.availableRental").value(vehicle.getAvailableRental()))
                .andExpect(jsonPath("$.emissionType").value(vehicle.getEmissionType().toString()))
                .andExpect(jsonPath("$.passengerNumber").value(vehicle.getPassengerNumber()))
                .andExpect(jsonPath("$.windShield").value(vehicle.getWindShield()))
                .andExpect(jsonPath("$.tailBag").value(vehicle.getTailBag()));

    }
    @Transactional
    @Test
    void checkIfOrderStatusIsCorrect() throws Exception {
        Purchase purchase = createAPurchase();

        MvcResult result = mockMvc.perform(get("/salesman/get/orderstatus/" + purchase.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(purchase.getOrderStatusEnum())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(purchase.getOrderStatusEnum().toString()))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        System.out.println("Response content: " + responseContent);
    }
}
