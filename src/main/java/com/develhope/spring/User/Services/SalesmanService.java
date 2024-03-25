package com.develhope.spring.User.Services;

import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.Rent.Repositories.RentRepository;
import com.develhope.spring.User.Entities.Users;
import com.develhope.spring.User.Repositories.UsersRepository;
import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SalesmanService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private RentRepository rentRepository;

    public Vehicle getVehicleInfoByid(Long idVehicle){
        return vehicleRepository.findById(idVehicle).orElseThrow(() -> new NoSuchElementException("Veicolo con id " + idVehicle + " non trovato"));
    }

    public OrderStatusEnum checkOrderStatus(Long idPurchase){
        Purchase purchase = purchaseRepository.findById(idPurchase).orElseThrow(() -> new NoSuchElementException("Ordine con id " + idPurchase + " non trovato"));
        return purchase.getOrderStatusEnum();
    }
    public OrderStatusEnum updateOrderStatus(Long idPurchase, OrderStatusEnum orderStatus){
        Purchase purchase = purchaseRepository.findById(idPurchase).orElseThrow(() -> new NoSuchElementException("Ordine con id " + idPurchase + " non trovato"));
        purchase.setOrderStatusEnum(orderStatus);
        purchaseRepository.save(purchase);
        return purchase.getOrderStatusEnum();
    }
    public List<Purchase> checkOrdersListByStatus(OrderStatusEnum orderStatus) throws NoSuchElementException{
        Optional<List<Purchase>> optionalPurchases = purchaseRepository.findOrdersByOrderStatus(orderStatus);
        if(optionalPurchases.isPresent()) {
            return optionalPurchases.get();
        } else {
            throw new NoSuchElementException("Ordini con stato " + orderStatus + " non trovati");
        }
    }
    public Users updateSalesmanInfo(Long idSalesman, Users updateSalesman){
        Users salesman = usersRepository.findById(idSalesman).orElseThrow(() -> new NoSuchElementException("Venditore con id " + idSalesman + " non trovato"));
        boolean isSalesManUpdated = false;

        if(updateSalesman.getFirstName() != null && !updateSalesman.getFirstName().isEmpty()){
            salesman.setFirstName(updateSalesman.getFirstName());
            isSalesManUpdated = true;
        }
        if(updateSalesman.getLastName() != null && !updateSalesman.getLastName().isEmpty()){
            salesman.setLastName(updateSalesman.getLastName());
            isSalesManUpdated = true;
        }
        if(updateSalesman.getEmail() != null && !updateSalesman.getEmail().isEmpty()){
            salesman.setEmail(updateSalesman.getEmail());
            isSalesManUpdated = true;
        }
        if(updateSalesman.getPassword() != null && !updateSalesman.getPassword().isEmpty()){
            salesman.setPassword(updateSalesman.getPassword());
            isSalesManUpdated = true;
        }
        if(updateSalesman.getPhone() != null && !updateSalesman.getPhone().isEmpty()){
            salesman.setPhone(updateSalesman.getPhone());
            isSalesManUpdated = true;
        }
        if(updateSalesman.getAddress() != null && !updateSalesman.getAddress().isEmpty()){
            salesman.setAddress(updateSalesman.getAddress());
            isSalesManUpdated = true;
        }
        if(updateSalesman.getSalesNumber() != null){
            salesman.setSalesNumber(updateSalesman.getSalesNumber());
            isSalesManUpdated = true;
        }
        if(isSalesManUpdated){
            salesman = usersRepository.save(salesman);
        }
        return salesman;

    }
//    public Purchase createNewOrder(Long id, Purchase Order) {
//        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Vehicle with id " + id + " not found."));
//        if (!vehicle.getStatusTypeEnum().equals(StatusTypeEnum.ORDERABLE) || !vehicle.getAvailableRental()) {
//            throw new IllegalStateException("Vehicle not orderable.");
//        }
//        Purchase newOrder = new Purchase();
//        newOrder.setVehicle(vehicle);
//        newOrder.setUsers(Order.getUsers());
//        newOrder.setSalesman(Order.getSalesman());
//        newOrder.setAdvancePayment(Order.getAdvancePayment());
//        newOrder.setIsPaid(Order.getIsPaid());
//        newOrder.setOrderStatusEnum(Order.getOrderStatusEnum());
//
//        vehicle.setStatusTypeEnum(StatusTypeEnum.SOLD);
//        vehicleRepository.save(vehicle);
//        return purchaseRepository.save(newOrder);
//    }
    public Purchase updateOrder(Long id, Purchase order) {
        Purchase orderUpdated = purchaseRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Order with id " + id + " not found."));
        if (order.getOrderStatusEnum() != null){
            orderUpdated.setOrderStatusEnum(order.getOrderStatusEnum());
        }
        return orderUpdated;
    }
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
    public Rent updateRent(Long id, Rent rent) {
        Rent rentUpdated = rentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Rent with id " + id + " not found."));
        if (rent.getDateStart() != null){
            rentUpdated.setDateStart(rent.getDateStart());
        }
        if (rent.getDateEnd() != null){
            rentUpdated.setDateEnd(rent.getDateEnd());
        }
        if (rent.getDeliveryPlace() != null){
            rentUpdated.setDeliveryPlace(rent.getDeliveryPlace());
        }
        if (rent.getPickUpLocation() != null){
            rentUpdated.setPickUpLocation(rent.getPickUpLocation());
        }
        return rentUpdated;
    }
    public Boolean deleteRent(Long id){
        Rent rentToDelete = rentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Rent with id " + id + " not found."));
        rentRepository.deleteById(id);
        return true;
    }
}
