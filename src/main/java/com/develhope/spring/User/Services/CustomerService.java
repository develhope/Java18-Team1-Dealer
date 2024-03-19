package com.develhope.spring.User.Services;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Repositories.CustomerRepository;
import com.develhope.spring.Vehicle.Entities.Enums.*;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    public List<Purchase> myPurchase(Long id) {
        return customerRepository.purchaseList(id);
    }

    public List<Purchase> myOrder(Long id) {
        return customerRepository.orderList(id);
    }

    public List<Rent> myRent(Long id) {
        return customerRepository.rentList(id);
    }

    public void deleteAccount(Long id) { //id di accesso del cliente
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer updateCustomer) {

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User con id: " + id + " non trovato!"));

        if (updateCustomer.getFirstName() != null && !updateCustomer.getFirstName().isEmpty()) {
            customer.setFirstName(updateCustomer.getFirstName());
        }
        if (updateCustomer.getLastName() != null && !updateCustomer.getLastName().isEmpty()) {
            customer.setLastName(updateCustomer.getLastName());
        }
        if (updateCustomer.getEmail() != null && !updateCustomer.getEmail().isEmpty()) {
            customer.setEmail(updateCustomer.getEmail());
        }
        if (updateCustomer.getPassword() != null && !updateCustomer.getPassword().isEmpty()) {
            customer.setPassword(updateCustomer.getPassword());
        }
        if (updateCustomer.getPhone() != null && !updateCustomer.getPhone().isEmpty()) {
            customer.setPhone(updateCustomer.getPhone());
        }
        if (updateCustomer.getAddress() != null && !updateCustomer.getAddress().isEmpty()) {
            customer.setAddress(updateCustomer.getAddress());
        }
        if (updateCustomer.getCreditCard() != null && !updateCustomer.getCreditCard().isEmpty()) {
            customer.setCreditCard(updateCustomer.getCreditCard());
        }
        if (updateCustomer.getTaxId() != null && !updateCustomer.getTaxId().isEmpty()) {
            customer.setTaxId(updateCustomer.getTaxId());
        }
        if (!customer.equals(updateCustomer)) {
            customer = customerRepository.save(customer);
        }

        return customer;

    }

    public List<Vehicle> searchVehicleByAllCriteria(BigDecimal minPrice,
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
                                                    Boolean antiCollisionSystem) {
        return vehicleRepository.findByAllCriteria(minPrice, maxPrice, brand, model, colour, cubiCapacity, hP, kW, registrationYear, fuelType, price, tradeDiscount, newVehicle, mileage, ageLimit, statusType, currentLocation, availableRental, emissionType, passengerNumber, windShield, tailBag, passengerBackrest, transmissionType, carType, tractionType, optionFullTraction, doors, centralizedClosing, airConditioning, bluetooth, satNav, electricRoof, parkAssist, spareTire, antiTheft, passengerTransport, windowedBackDoor, slideSideDoor, antiCollisionSystem);
    }
}
