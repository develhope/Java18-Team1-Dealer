package com.develhope.spring.User.Services;

import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
import com.develhope.spring.User.Entities.Salesman;
import com.develhope.spring.User.Repositories.SalesmanRepository;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SalesmanService {
    @Autowired
    private SalesmanRepository salesmanRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

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
    public Salesman updateSalesmanInfo(Long idSalesman,Salesman updateSalesman){
        Salesman salesman = salesmanRepository.findById(idSalesman).orElseThrow(() -> new NoSuchElementException("Venditore con id " + idSalesman + " non trovato"));
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
            salesman = salesmanRepository.save(salesman);
        }
        return salesman;

    }
}
