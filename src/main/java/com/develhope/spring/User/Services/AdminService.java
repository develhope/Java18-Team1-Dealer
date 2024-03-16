package com.develhope.spring.User.Services;

import com.develhope.spring.Purchase.Entities.DTO.AdminPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
import com.develhope.spring.Vehicle.Entities.Enums.StatusType;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AdminService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase createNewPurchase(AdminPurchaseCreationDTO dto){
        Vehicle vehicle = vehicleRepository.findById(dto.getIdVehicle()).orElseThrow(() -> new NoSuchElementException("Veicolo con id " + dto.getIdVehicle() + " non trovato"));
        if(vehicle.getStatusType().equals(StatusType.PURCHASABLE)){
            Purchase purchase = new Purchase();
            purchase.setVehicle(vehicle);
            purchase.setSalesman(dto.getSalesman());
            purchase.setCustomer(dto.getCustomer());
            purchase.setAdvancePayment(vehicle.getPrice());
            purchase.setIsPaid(false);
            purchase.setVehicleStatusEnum(dto.getVehicleStatus());

            vehicle.setStatusType(StatusType.SOLD);
            vehicleRepository.save(vehicle);
            return purchaseRepository.save(purchase);
        } else {
            throw new IllegalStateException("Il veicolo non è acquistabile.");
        }
    }
}
