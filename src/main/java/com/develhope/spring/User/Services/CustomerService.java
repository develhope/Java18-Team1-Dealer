package com.develhope.spring.User.Services;

import com.develhope.spring.Purchase.Entities.DTO.CustomerPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.Rent.Repositories.RentRepository;
import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
public class CustomerService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private RentRepository rentRepository;

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
}
