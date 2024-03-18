package com.develhope.spring.User.Controllers;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.User.Services.AdminService;
import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.develhope.spring.Purchase.Entities.DTO.AdminPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.User.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorworld/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/newvehicle")
    public @ResponseBody Vehicle newVehicle(@RequestBody Vehicle vehicle){

        return adminService.newVehicle(vehicle);
    }
    @DeleteMapping("/delete-vehicle/{id}")
    public @ResponseStatus HttpEntity<String> deleteVehicle(@PathVariable Long id){
        Boolean response = adminService.deleteVehicle(id);
        if(response = true){
            return ResponseEntity.ok().body("Vehicle deleted");
        }else{
            return ResponseEntity.badRequest().body("Vehicle not deleted");
        }
    }
    @PutMapping("/update-vehicle/{id}")
    public @ResponseBody Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle){
        return adminService.updateVehicle(id, vehicle);
    }
    @PatchMapping("/update-vehiclestatus/{id}")
    public @ResponseBody Vehicle updateStatusVehicle(@PathVariable Long id, @RequestParam (value = "statusType") StatusTypeEnum statusTypeEnum){
        return adminService.updateStatusType(id, statusTypeEnum);
    }
    @PutMapping("/update-purchase/{idCustomer}/{idPurchase}")
    public ResponseEntity<List<Purchase>> updatePurchase(
            @PathVariable Long idCustomer, @PathVariable Long idPurchase, @RequestBody Purchase purchase){
        List<Purchase> customerPurcases = adminService.updatePurchaseById(idCustomer, idPurchase, purchase);
        if(customerPurcases != null) {
            return ResponseEntity.ok().body(customerPurcases);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/status-type/{statusType}")
    public ResponseEntity<List<Vehicle>> vehicleByStatusType(@RequestParam StatusTypeEnum statusType){
        List<Vehicle> vehiclesByStatusType = adminService.vehiclesByStatusType(statusType);
        if(vehiclesByStatusType != null) {
            return ResponseEntity.ok().body(vehiclesByStatusType);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @Autowired
    private AdminService adminService;

    @PostMapping("/post")
    public @ResponseBody Purchase createNewPurchase(@RequestBody AdminPurchaseCreationDTO purchaseCreation){
        return adminService.createNewPurchase(purchaseCreation);
    }
}
