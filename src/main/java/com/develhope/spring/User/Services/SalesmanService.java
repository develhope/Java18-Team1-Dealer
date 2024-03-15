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
    public List<Purchase> checkOrdersListByStatus(OrderStatusEnum orderStatus){
        return purchaseRepository.findOrdersByOrderStatus(orderStatus);
    }
    public Salesman updateSalesmanInfo(Long idSalesman,Salesman updateSalesman){
        Salesman salesman = salesmanRepository.findById(idSalesman).orElseThrow(() -> new NoSuchElementException("Venditore con id " + idSalesman + " non trovato"));

    }
}
