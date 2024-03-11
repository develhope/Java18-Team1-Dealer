package com.develhope.spring.User.Services;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
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

    public String checkOrderStatus(Long idPurchase){
        Purchase purchase = purchaseRepository.findById(idPurchase).orElseThrow(() -> new NoSuchElementException("Ordine con id " + idPurchase + " non trovato"));
        return purchase.getOrderStatus();
    }
    public String updateOrderStatus(Long idPurchase, String orderStatus){
        Purchase purchase = purchaseRepository.findById(idPurchase).orElseThrow(() -> new NoSuchElementException("Ordine con id " + idPurchase + " non trovato"));
        purchase.setOrderStatus(orderStatus);
        return purchase.getOrderStatus();
    }
    public List<Purchase> checkOrdersListByStatus(String orderStatus){
        return salesmanRepository.findOrdersByOrderStatus(orderStatus);
    }
}
