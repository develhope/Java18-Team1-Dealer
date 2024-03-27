package com.develhope.spring;

import com.develhope.spring.Purchase.Entities.DTO.AdminPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Enums.VehicleStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
import com.develhope.spring.User.Controllers.AdminController;
import com.develhope.spring.User.Controllers.CustomerController;
import com.develhope.spring.User.Controllers.SalesmanController;
import com.develhope.spring.Vehicle.Entities.Enums.EmissionTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.FuelTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import com.develhope.spring.Vehicle.Entities.Enums.VehiclesTypeEnum;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
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
        vehicle.setVehiclesTypeEnum(VehiclesTypeEnum.SCOOTER);
        vehicle.setBrand("Audi");
        vehicle.setModel("A8");
        vehicle.setColour("Red");
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

    private Salesman createASalesman() {
        Salesman salesman = new Salesman();
        salesman.setPhone("12111313");
        salesman.setAddress("99393");
        salesman.setSalesNumber(1);
        salesman.setFirstName("Paolo");
        salesman.setLastName("Bianchi");
        salesman.setEmail(getRandomString());
        salesman.setPassword("9181");
        return salesmanRepository.save(salesman);
    }

    private Customer createACustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Giulio");
        customer.setLastName("Marciante");
        customer.setEmail(getRandomString());
        customer.setPassword("129391239");
        customer.setPhone("81839813");
        customer.setAddress("0100101");
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
        adminPurchase.setSalesman(createASalesman());
        adminPurchase.setCustomer(createACustomer());
        adminPurchase.setVehicleStatus(VehicleStatusEnum.PURCHASED);


        mockMvc.perform(post("/motorworld/admin/newpurchase")
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

        mockMvc.perform(get("/motorworld/customer/info-vehicle/" + vehicle.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehicle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.vehiclesTypeEnum").value(vehicle.getVehiclesTypeEnum().toString()))
                .andExpect(jsonPath("$.brand").value(vehicle.getBrand()))
                .andExpect(jsonPath("$.model").value(vehicle.getModel()))
                .andExpect(jsonPath("$.colour").value(vehicle.getColour()))
                .andExpect(jsonPath("$.cubiCapacity").value(vehicle.getCubiCapacity()))
                .andExpect(jsonPath("$.hp").value(vehicle.getHP()))
                .andExpect(jsonPath("$.kw").value(vehicle.getKW()))
                .andExpect(jsonPath("$.registrationYear").value(vehicle.getRegistrationYear().toString()))
                .andExpect(jsonPath("$.fuelTypeEnum").value(vehicle.getFuelTypeEnum().toString()))
                .andExpect(jsonPath("$.price").value(vehicle.getPrice()))
                .andExpect(jsonPath("$.tradeDiscount").value(vehicle.getTradeDiscount()))
                .andExpect(jsonPath("$.newVehicle").value(vehicle.getNewVehicle()))
                .andExpect(jsonPath("$.mileage").value(vehicle.getMileage()))
                .andExpect(jsonPath("$.ageLimit").value(vehicle.getAgeLimit()))
                .andExpect(jsonPath("$.statusTypeEnum").value(vehicle.getStatusTypeEnum().toString()))
                .andExpect(jsonPath("$.currentLocation").value(vehicle.getCurrentLocation()))
                .andExpect(jsonPath("$.availableRental").value(vehicle.getAvailableRental()))
                .andExpect(jsonPath("$.emissionTypeEnum").value(vehicle.getEmissionTypeEnum().toString()))
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
        adminPurchase.setCustomer(createACustomer());
        adminPurchase.setVehicleStatus(VehicleStatusEnum.PURCHASED);


        mockMvc.perform(post("/motorworld/customer/newpurchase")
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

        mockMvc.perform(get("/motorworld/salesman/info-vehicle/" + vehicle.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehicle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.vehiclesTypeEnum").value(vehicle.getVehiclesTypeEnum().toString()))
                .andExpect(jsonPath("$.brand").value(vehicle.getBrand()))
                .andExpect(jsonPath("$.model").value(vehicle.getModel()))
                .andExpect(jsonPath("$.colour").value(vehicle.getColour()))
                .andExpect(jsonPath("$.cubiCapacity").value(vehicle.getCubiCapacity()))
                .andExpect(jsonPath("$.hp").value(vehicle.getHP()))
                .andExpect(jsonPath("$.kw").value(vehicle.getKW()))
                .andExpect(jsonPath("$.registrationYear").value(vehicle.getRegistrationYear().toString()))
                .andExpect(jsonPath("$.fuelTypeEnum").value(vehicle.getFuelTypeEnum().toString()))
                .andExpect(jsonPath("$.price").value(vehicle.getPrice()))
                .andExpect(jsonPath("$.tradeDiscount").value(vehicle.getTradeDiscount()))
                .andExpect(jsonPath("$.newVehicle").value(vehicle.getNewVehicle()))
                .andExpect(jsonPath("$.mileage").value(vehicle.getMileage()))
                .andExpect(jsonPath("$.ageLimit").value(vehicle.getAgeLimit()))
                .andExpect(jsonPath("$.statusTypeEnum").value(vehicle.getStatusTypeEnum().toString()))
                .andExpect(jsonPath("$.currentLocation").value(vehicle.getCurrentLocation()))
                .andExpect(jsonPath("$.availableRental").value(vehicle.getAvailableRental()))
                .andExpect(jsonPath("$.emissionTypeEnum").value(vehicle.getEmissionTypeEnum().toString()))
                .andExpect(jsonPath("$.passengerNumber").value(vehicle.getPassengerNumber()))
                .andExpect(jsonPath("$.windShield").value(vehicle.getWindShield()))
                .andExpect(jsonPath("$.tailBag").value(vehicle.getTailBag()));

    }

    @Transactional
    @Test
    void checkIfOrderStatusIsCorrect() throws Exception {
        Purchase purchase = createAPurchase();

        MvcResult result = mockMvc.perform(get("/motorworld/salesman/status-purchase/" + purchase.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(purchase.getOrderStatusEnum())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(purchase.getOrderStatusEnum().toString()))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        System.out.println("Response content: " + responseContent);
    }

    @Transactional
    @Test
    void checkIfOrderListIsPopulated() throws Exception {
        Purchase purchase = createAPurchase();
        Purchase purchase1 = createAPurchase();
        purchase1.setOrderStatusEnum(OrderStatusEnum.SHIPPED);
        List<Purchase> purchaseList = new ArrayList<>();
        purchaseList.add(purchase);
        purchaseList.add(purchase1);
        purchaseRepository.saveAll(purchaseList);

        OrderStatusEnum orderStatus = OrderStatusEnum.COMPLETED;

        MvcResult result = mockMvc.perform(get("/motorworld/salesman/purchases-status/" + orderStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(purchaseList)))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result .getResponse().getContentAsString();
        List<Purchase> responsePurchaseList = objectMapper.readValue(jsonResponse, List.class);

        assertThat(responsePurchaseList).isNotNull();
        assertThat(responsePurchaseList).isNotEmpty();
        assertThat(responsePurchaseList.size()).isEqualTo(1);
    }

    @Transactional
    @Test
    void checkIfOrderStatusIsUpdated() throws Exception{
        Purchase purchase = createAPurchase();
        OrderStatusEnum orderStatusUpdated = OrderStatusEnum.FAILED;

        MvcResult result = mockMvc.perform(patch("/motorworld/salesman/update-orderstatus/" + purchase.getId() + "?orderStatus=" + orderStatusUpdated)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(purchase.getOrderStatusEnum())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(orderStatusUpdated.toString()))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        System.out.println("Response content: " + responseContent);
    }

    @Transactional
    @Test
    public void adminDeleteASalesmanTest() throws Exception {

        Salesman fakeSalesman = createASalesman();

        mockMvc.perform(delete("/motorworld/admin/delete-salesman/" + fakeSalesman.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Salesman deleted"));

    }

    @Transactional
    @Test
    public void adminDeleteACustomerTest() throws Exception {

        Customer fakeCustomer = createACustomer();

        mockMvc.perform(delete("/motorworld/admin/delete-customer/" + fakeCustomer.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Customer deleted"));

    }
}
