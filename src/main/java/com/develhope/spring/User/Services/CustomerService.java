package com.develhope.spring.User.Services;

import com.develhope.spring.Purchase.Entities.DTO.CustomerPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.Vehicle.Entities.Enums.StatusType;
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

    public Vehicle getVehicleInfoByid(Long idVehicle){
        return vehicleRepository.findById(idVehicle).orElseThrow(() -> new NoSuchElementException("Veicolo con id " + idVehicle + " non trovato"));
    }
    public Purchase createNewPurchase(CustomerPurchaseCreationDTO dto){
        Vehicle vehicle = vehicleRepository.findById(dto.getIdVehicle()).orElseThrow(() -> new NoSuchElementException("Veicolo con id " + dto.getIdVehicle() + " non trovato"));
        if(vehicle.getStatusType().equals(StatusType.PURCHASABLE)){
            Purchase purchase = new Purchase();
            purchase.setVehicle(vehicle);
            purchase.setCustomer(dto.getCustomer());
            purchase.setIsPaid(false);

            vehicle.setStatusType(StatusType.SOLD);
            vehicleRepository.save(vehicle);
            return purchaseRepository.save(purchase);
        } else {
            throw new IllegalStateException("Il veicolo non è acquistabile.");
        }
    }
}
