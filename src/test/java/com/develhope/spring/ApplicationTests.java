package com.develhope.spring;

import com.develhope.spring.Purchase.Entities.DTO.AdminPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.DTO.CustomerPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Enums.VehicleStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Entities.Salesman;
import com.develhope.spring.User.Repositories.AdminRepository;
import com.develhope.spring.User.Repositories.CustomerRepository;
import com.develhope.spring.User.Repositories.SalesmanRepository;
import com.develhope.spring.User.Services.AdminService;
import com.develhope.spring.User.Services.CustomerService;
import com.develhope.spring.User.Services.SalesmanService;
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
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = "testing")
class ApplicationTests {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private SalesmanService salesmanService;
    @Autowired
    private SalesmanRepository salesmanRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;
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
    void createVehicle() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
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

        Vehicle newVehicle = vehicleService.newVehicle(vehicle);

        assertThat(newVehicle.getId()).isEqualTo(vehicle.getId());
    }

    @Transactional
    @Test
    void checkIfVehicleExistForSalesman() throws Exception {
        Vehicle vehicle = createAVehicle();

        Vehicle vehicleFromService = salesmanService.getVehicleInfoByid(vehicle.getId());
        assertThat(vehicleFromService).isNotNull();
        assertEquals(vehicleFromService.getId(), vehicle.getId());
        assertEquals(vehicleFromService.getVehiclesType(), vehicle.getVehiclesType());
        assertEquals(vehicleFromService.getBrand(), vehicle.getBrand());
        assertEquals(vehicleFromService.getModel(), vehicle.getModel());
        assertEquals(vehicleFromService.getColour(), vehicle.getColour());
        assertEquals(vehicleFromService.getCubiCapacity(), vehicle.getCubiCapacity());
        assertEquals(vehicleFromService.getHP(), vehicle.getHP());
        assertEquals(vehicleFromService.getKW(), vehicle.getKW());
        assertEquals(vehicleFromService.getRegistrationYear(), vehicle.getRegistrationYear());
        assertEquals(vehicleFromService.getFuelType(), vehicle.getFuelType());
        assertEquals(0, vehicleFromService.getPrice().compareTo(vehicle.getPrice()));
        assertEquals(vehicleFromService.getTradeDiscount(), vehicle.getTradeDiscount());
        assertEquals(vehicleFromService.getNewVehicle(), vehicle.getNewVehicle());
        assertEquals(vehicleFromService.getMileage(), vehicle.getMileage());
        assertEquals(vehicleFromService.getAgeLimit(), vehicle.getAgeLimit());
        assertEquals(vehicleFromService.getStatusType(), vehicle.getStatusType());
        assertEquals(vehicleFromService.getCurrentLocation(), vehicle.getCurrentLocation());
        assertEquals(vehicleFromService.getAvailableRental(), vehicle.getAvailableRental());
        assertEquals(vehicleFromService.getEmissionType(), vehicle.getEmissionType());
        assertEquals(vehicleFromService.getPassengerNumber(), vehicle.getPassengerNumber());
        assertEquals(vehicleFromService.getWindShield(), vehicle.getWindShield());
        assertEquals(vehicleFromService.getTailBag(), vehicle.getTailBag());
    }

    @Transactional
    @Test
    void checkIfVehicleIdIsWrongForSalesman() throws Exception {
        Vehicle vehicle = createAVehicle();
        assertThat(vehicle).isNotNull();
        Long id = 2L;
        assertThrows(NoSuchElementException.class, () -> {
            salesmanService.getVehicleInfoByid(id);
        });
    }

    @Transactional
    @Test
    void checkIfOrderStatusIsCorrect() throws Exception {
        Purchase purchase = createAPurchase();
        assertThat(purchase).isNotNull();
        assertThat(purchase.getOrderStatusEnum()).isEqualTo(salesmanService.checkOrderStatus(purchase.getId()));

    }

    @Transactional
    @Test
    void checkIfOrderIdIsWrong() throws Exception {
        Purchase purchase = createAPurchase();
        assertThat(purchase).isNotNull();
        Long id = 2L;
        assertThrows(NoSuchElementException.class, () -> {
            salesmanService.checkOrderStatus(id);
        });
    }

    @Transactional
    @Test
    void checkIfUpdatedOrderStatusIsCorrect() throws Exception {
        Purchase purchase = createAPurchase();
        assertThat(purchase).isNotNull();
        OrderStatusEnum updateStatus = salesmanService.updateOrderStatus(purchase.getId(), OrderStatusEnum.IN_PROGRESS);
        assertThat(updateStatus).isEqualTo(OrderStatusEnum.IN_PROGRESS);
        Purchase updatedPurchase = purchaseRepository.findById(purchase.getId()).orElseThrow(() -> new NoSuchElementException("Ordine con id " + purchase.getId() + " non trovato"));
        assertThat(updatedPurchase.getOrderStatusEnum()).isEqualTo(OrderStatusEnum.IN_PROGRESS);
    }
    @Transactional
    @Test
    void checkIfUpdatedOrderIdIsWrong() throws Exception{
        Purchase purchase = createAPurchase();
        assertThat(purchase).isNotNull();
        Long id = 3L;
        assertThrows(NoSuchElementException.class, () -> {
            salesmanService.updateOrderStatus(id,OrderStatusEnum.IN_PROGRESS);
        });
    }
    @Transactional
    @Test
    void checkIfTheListContainsCorrectOrdersByStatus() throws Exception {
        Purchase purchaseCompleted = createAPurchase();
        Purchase purchase1 = createAPurchase();
        Purchase purchase2 = createAPurchase();
        Purchase purchase3 = createAPurchase();
        Purchase purchaseCompleted2 = createAPurchase();
        Purchase purchaseCompleted3 = createAPurchase();
        purchase1.setOrderStatusEnum(OrderStatusEnum.SHIPPED);
        purchaseRepository.save(purchase1);
        purchase2.setOrderStatusEnum(OrderStatusEnum.IN_PROGRESS);
        purchaseRepository.save(purchase2);
        purchase3.setOrderStatusEnum(OrderStatusEnum.FAILED);
        purchaseRepository.save(purchase3);
        List<Purchase> shippedOrders = salesmanService.checkOrdersListByStatus(OrderStatusEnum.SHIPPED);
        assertThat(shippedOrders).size().isEqualTo(1);
        List<Purchase> completedOrders = salesmanService.checkOrdersListByStatus(OrderStatusEnum.COMPLETED);
        assertThat(completedOrders).size().isEqualTo(3);
        List<Purchase> inProgressOrders = salesmanService.checkOrdersListByStatus(OrderStatusEnum.IN_PROGRESS);
        assertThat(inProgressOrders).size().isEqualTo(1);
        List<Purchase> failedOrders = salesmanService.checkOrdersListByStatus(OrderStatusEnum.FAILED);
        assertThat(failedOrders).size().isEqualTo(1);
    }
    @Transactional
    @Test
    void checkIfOrdersListWithSpecifyStatusIsEmpty() {
        List<Purchase> orders = salesmanService.checkOrdersListByStatus(OrderStatusEnum.IN_PROGRESS);
        assertTrue(orders.isEmpty());
    }

    @Transactional
    @Test
    void checkIfChangeSalesman() throws Exception {
        Salesman salesman = createASalesman();
        assertThat(salesman).isNotNull();
        salesman.setPhone("1731639");
        salesman.setAddress("183jdhkjasdja");
        salesman.setSalesNumber(4);
        salesman.setFirstName("jsdjkscb");
        salesman.setLastName("bubu");
        salesman.setEmail("jakjdasdlsa");
        salesman.setPassword("aaalallsjkk");
        Salesman updateSalesman = salesmanService.updateSalesmanInfo(salesman.getId(), salesman);
        assertThat(updateSalesman.getFirstName()).isEqualTo("jsdjkscb");
        assertThat(updateSalesman.getLastName()).isEqualTo("bubu");
        assertThat(updateSalesman.getPhone()).isEqualTo("1731639");
        assertThat(updateSalesman.getAddress()).isEqualTo("183jdhkjasdja");
        assertThat(updateSalesman.getSalesNumber()).isEqualTo(4);
        assertThat(updateSalesman.getEmail()).isEqualTo("jakjdasdlsa");
        assertThat(updateSalesman.getPassword()).isEqualTo("aaalallsjkk");
    }

    @Transactional
    @Test
    void checkIfSalesmanIdIsWrong() throws Exception {
        Salesman salesman = createASalesman();
        assertThat(salesman).isNotNull();
        Long id = 2L;
        assertThrows(NoSuchElementException.class, () -> {
            salesmanService.updateSalesmanInfo(id, salesman);
        });
    }
    @Transactional
    @Test
    void checkIfPurchaseIsCreatedByAdmin() throws Exception {
        Vehicle vehicle = createAVehicle();
        AdminPurchaseCreationDTO adminPurchase = new AdminPurchaseCreationDTO();
        adminPurchase.setIdVehicle(vehicle.getId());
        adminPurchase.setSalesman(createASalesman());
        adminPurchase.setCustomer(createACustomer());
        adminPurchase.setVehicleStatus(VehicleStatusEnum.PURCHASED);
        Purchase purchase = adminService.createNewPurchase(adminPurchase);
        assertThat(purchase).isNotNull();
        assertThat(purchase.getVehicle()).isEqualTo(vehicle);
        assertThat(purchase.getSalesman()).isEqualTo(adminPurchase.getSalesman());
        assertThat(purchase.getCustomer()).isEqualTo(adminPurchase.getCustomer());
        assertThat(purchase.getIsPaid()).isFalse();
        assertThat(purchase.getVehicleStatusEnum()).isEqualTo(adminPurchase.getVehicleStatus());
    }
    @Transactional
    @Test
    void checkIfPurchaseIsCreatedByAdminForNotExistingVehicle() throws Exception {
        Long id = 2L;
        AdminPurchaseCreationDTO adminPurchase = new AdminPurchaseCreationDTO();
        adminPurchase.setIdVehicle(id);
        adminPurchase.setSalesman(createASalesman());
        adminPurchase.setCustomer(createACustomer());
        adminPurchase.setVehicleStatus(VehicleStatusEnum.PURCHASED);
        assertThrows(NoSuchElementException.class, () -> {
            adminService.createNewPurchase(adminPurchase);
        });
    }
    @Transactional
    @Test
    void checkIfPurchaseIsCreatedByAdminForExistingVehicleButNotPurchasable() throws Exception {
        Vehicle vehicle = createAVehicle();
        vehicle.setStatusType(StatusType.NOTAVAILABLE);
        vehicleRepository.save(vehicle);
        AdminPurchaseCreationDTO adminPurchase = new AdminPurchaseCreationDTO();
        adminPurchase.setIdVehicle(vehicle.getId());
        adminPurchase.setSalesman(createASalesman());
        adminPurchase.setCustomer(createACustomer());
        adminPurchase.setVehicleStatus(VehicleStatusEnum.PURCHASED);
        assertThrows(IllegalStateException.class, () -> {
            adminService.createNewPurchase(adminPurchase);
        });
    }
    @Transactional
    @Test
    void checkIfVehicleExistForCustomer() throws Exception {
        Vehicle vehicle = createAVehicle();

        Vehicle vehicleFromService = customerService.getVehicleInfoByid(vehicle.getId());
        assertThat(vehicleFromService).isNotNull();
        assertEquals(vehicleFromService.getId(), vehicle.getId());
        assertEquals(vehicleFromService.getVehiclesType(), vehicle.getVehiclesType());
        assertEquals(vehicleFromService.getBrand(), vehicle.getBrand());
        assertEquals(vehicleFromService.getModel(), vehicle.getModel());
        assertEquals(vehicleFromService.getColour(), vehicle.getColour());
        assertEquals(vehicleFromService.getCubiCapacity(), vehicle.getCubiCapacity());
        assertEquals(vehicleFromService.getHP(), vehicle.getHP());
        assertEquals(vehicleFromService.getKW(), vehicle.getKW());
        assertEquals(vehicleFromService.getRegistrationYear(), vehicle.getRegistrationYear());
        assertEquals(vehicleFromService.getFuelType(), vehicle.getFuelType());
        assertEquals(0, vehicleFromService.getPrice().compareTo(vehicle.getPrice()));
        assertEquals(vehicleFromService.getTradeDiscount(), vehicle.getTradeDiscount());
        assertEquals(vehicleFromService.getNewVehicle(), vehicle.getNewVehicle());
        assertEquals(vehicleFromService.getMileage(), vehicle.getMileage());
        assertEquals(vehicleFromService.getAgeLimit(), vehicle.getAgeLimit());
        assertEquals(vehicleFromService.getStatusType(), vehicle.getStatusType());
        assertEquals(vehicleFromService.getCurrentLocation(), vehicle.getCurrentLocation());
        assertEquals(vehicleFromService.getAvailableRental(), vehicle.getAvailableRental());
        assertEquals(vehicleFromService.getEmissionType(), vehicle.getEmissionType());
        assertEquals(vehicleFromService.getPassengerNumber(), vehicle.getPassengerNumber());
        assertEquals(vehicleFromService.getWindShield(), vehicle.getWindShield());
        assertEquals(vehicleFromService.getTailBag(), vehicle.getTailBag());
    }
    @Transactional
    @Test
    void checkIfVehicleIdIsWrongForCustomer() throws Exception {
        Vehicle vehicle = createAVehicle();
        assertThat(vehicle).isNotNull();
        Long id = 2L;
        assertThrows(NoSuchElementException.class, () -> {
            customerService.getVehicleInfoByid(id);
        });
    }
    @Transactional
    @Test
    void checkIfPurchaseIsCreatedByCustomer() throws Exception {
        Vehicle vehicle = createAVehicle();
        CustomerPurchaseCreationDTO customerPurchase = new CustomerPurchaseCreationDTO();
        customerPurchase.setIdVehicle(vehicle.getId());
        customerPurchase.setCustomer(createACustomer());
        customerPurchase.setVehicleStatus(VehicleStatusEnum.PURCHASED);
        Purchase purchase = customerService.createNewPurchase(customerPurchase);
        assertThat(purchase).isNotNull();
        assertThat(purchase.getVehicle()).isEqualTo(vehicle);
        assertThat(purchase.getCustomer()).isEqualTo(customerPurchase.getCustomer());
        assertThat(purchase.getIsPaid()).isFalse();
        assertThat(purchase.getVehicleStatusEnum()).isEqualTo(customerPurchase.getVehicleStatus());
    }
    @Transactional
    @Test
    void checkIfPurchaseIsCreatedByCustomerForNotExistingVehicle() throws Exception {
        Long id = 2L;
        CustomerPurchaseCreationDTO customerPurchase = new CustomerPurchaseCreationDTO();
        customerPurchase.setIdVehicle(id);
        customerPurchase.setCustomer(createACustomer());
        customerPurchase.setVehicleStatus(VehicleStatusEnum.PURCHASED);
        assertThrows(NoSuchElementException.class, () -> {
            customerService.createNewPurchase(customerPurchase);
        });
    }
    @Transactional
    @Test
    void checkIfPurchaseIsCreatedByCustomerForExistingVehicleButNotPurchasable() throws Exception {
        Vehicle vehicle = createAVehicle();
        vehicle.setStatusType(StatusType.NOTAVAILABLE);
        vehicleRepository.save(vehicle);
        CustomerPurchaseCreationDTO customerPurchase = new CustomerPurchaseCreationDTO();
        customerPurchase.setIdVehicle(vehicle.getId());
        customerPurchase.setCustomer(createACustomer());
        customerPurchase.setVehicleStatus(VehicleStatusEnum.PURCHASED);
        assertThrows(IllegalStateException.class, () -> {
            customerService.createNewPurchase(customerPurchase);
        });
    }
}
