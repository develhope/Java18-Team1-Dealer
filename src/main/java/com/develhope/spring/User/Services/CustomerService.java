package com.develhope.spring.User.Services;

import com.develhope.spring.Purchase.Entities.DTO.CustomerPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.Rent.Repositories.RentRepository;
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
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private RentRepository rentRepository;
    @Autowired
    CustomerRepository customerRepository;

    public Vehicle getVehicleInfoByid(Long idVehicle){
        return vehicleRepository.findById(idVehicle).orElseThrow(() -> new NoSuchElementException("Veicolo con id " + idVehicle + " non trovato"));
    }
//    public Purchase createNewPurchase(CustomerPurchaseCreationDTO dto){
//        Vehicle vehicle = vehicleRepository.findById(dto.getIdVehicle()).orElseThrow(() -> new NoSuchElementException("Veicolo con id " + dto.getIdVehicle() + " non trovato"));
//        if(vehicle.getStatusTypeEnum().equals(StatusTypeEnum.PURCHASABLE)){
//            Purchase purchase = new Purchase();
//            purchase.setVehicle(vehicle);
//            purchase.setCustomer(dto.getCustomer());
//            purchase.setAdvancePayment(vehicle.getPrice());
//            purchase.setIsPaid(false);
//            purchase.setVehicleStatusEnum(dto.getVehicleStatus());
//            purchase.setOrderStatusEnum(OrderStatusEnum.COMPLETED);
//
//            vehicle.setStatusTypeEnum(StatusTypeEnum.SOLD);
//            vehicleRepository.save(vehicle);
//            return purchaseRepository.save(purchase);
//        } else {
//            throw new IllegalStateException("Il veicolo non è acquistabile.");
//        }
//    }
//    public Purchase createNewOrder(Long id, Purchase Order) {
//        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Vehicle with id " + id + " not found."));
//        if (!vehicle.getStatusTypeEnum().equals(StatusTypeEnum.ORDERABLE) || !vehicle.getAvailableRental()) {
//            throw new IllegalStateException("Vehicle not orderable.");
//        }
//        Purchase newOrder = new Purchase();
//        newOrder.setVehicle(vehicle);
//        newOrder.setCustomer(Order.getCustomer());
//        newOrder.setSalesman(Order.getSalesman());
//        newOrder.setAdvancePayment(Order.getAdvancePayment());
//        newOrder.setIsPaid(Order.getIsPaid());
//        newOrder.setOrderStatusEnum(Order.getOrderStatusEnum());
//
//        vehicle.setStatusTypeEnum(StatusTypeEnum.SOLD);
//        vehicleRepository.save(vehicle);
//        return purchaseRepository.save(newOrder);
//    }
    public Boolean deleteOrder(Long id){
        Purchase orderToDelete = purchaseRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Order with id " + id + " not found."));
        purchaseRepository.deleteById(id);
        return true;
    }
//    public Rent createNewRent(Long id, Rent rent) {
//        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Vehicle with id " + id + " not found."));
//        if (!vehicle.getStatusTypeEnum().equals(StatusTypeEnum.PURCHASABLE) || !vehicle.getAvailableRental()) {
//            throw new IllegalStateException("Vehicle not rentable.");
//        }
//        long rentalDays = rent.getDateStart().until(rent.getDateEnd()).getDays() + 1;
//        BigDecimal totalAmount = rent.getDailyRate().multiply(BigDecimal.valueOf(rentalDays));
//
//        Rent newRent = new Rent();
//        newRent.setVehicle(vehicle);
//        newRent.setCustomer(rent.getCustomer());
//        newRent.setAdvancePayment(rent.getAdvancePayment());
//        newRent.setDateStart(rent.getDateStart());
//        newRent.setDateEnd(rent.getDateEnd());
//        newRent.setDailyRate(rent.getDailyRate());
//        newRent.setTotalPrice(totalAmount);
//        newRent.setPickUpLocation(vehicle.getCurrentLocation());
//        newRent.setDeliveryPlace(rent.getDeliveryPlace());
//        newRent.setIsPaid(rent.getIsPaid());
//
//        vehicle.setStatusTypeEnum(StatusTypeEnum.NOTAVAILABLE);
//        vehicleRepository.save(vehicle);
//        return rentRepository.save(newRent);
//    }
    public Boolean deleteRent(Long id){
        Rent rentToDelete = rentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Rent with id " + id + " not found."));
        rentRepository.deleteById(id);
        return true;
    }

public List<Purchase> myPurchase(Long id) throws NoSuchElementException{
    Optional<List<Purchase>> optionalPurchases = purchaseRepository.purchaseList(id);
    if(optionalPurchases.isPresent()) {
        return optionalPurchases.get();
    } else {
        throw new NoSuchElementException("Nessun purchase presente");
    }
}

public List<Purchase> myOrder(Long id) throws NoSuchElementException{
    Optional<List<Purchase>> optionalOrder = purchaseRepository.purchaseList(id);
    if(optionalOrder.isPresent()) {
        return optionalOrder.get();
    } else {
        throw new NoSuchElementException("Nessun order presente");
    }
}

    public List<Rent> myRent(Long id) {
        return rentRepository.rentList(id);
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

    public List<Vehicle> searchVehicleByAllCriteria(VehiclesTypeEnum vehiclesTypeEnum,
                                                    String brand,
                                                    String model,
                                                    String colour,
                                                    Double cubiCapacity,
                                                    Integer hP,
                                                    Double kW,
                                                    LocalDate registrationYear,
                                                    FuelTypeEnum fuelTypeEnum,
                                                    BigDecimal price,
                                                    Double tradeDiscount,
                                                    Boolean newVehicle,
                                                    Double mileage,
                                                    Integer ageLimit,
                                                    StatusTypeEnum statusTypeEnum,
                                                    String currentLocation,
                                                    Boolean availableRental,
                                                    EmissionTypeEnum emissionTypeEnum,
                                                    Integer passengerNumber,
                                                    Boolean windShield,
                                                    Boolean tailBag,
                                                    Boolean passengerBackrest,
                                                    TransmissionTypeEnum transmissionTypeEnum,
                                                    CarTypeEnum carTypeEnum,
                                                    TractionTypeEnum tractionTypeEnum,
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
        return vehicleRepository.findByAllCriteria(vehiclesTypeEnum, brand, model, colour, cubiCapacity, hP, kW, registrationYear, fuelTypeEnum, price, tradeDiscount, newVehicle, mileage, ageLimit, statusTypeEnum, currentLocation, availableRental, emissionTypeEnum, passengerNumber, windShield, tailBag, passengerBackrest, transmissionTypeEnum, carTypeEnum, tractionTypeEnum, optionFullTraction, doors, centralizedClosing, airConditioning, bluetooth, satNav, electricRoof, parkAssist, spareTire, antiTheft, passengerTransport, windowedBackDoor, slideSideDoor, antiCollisionSystem);
    }
}
