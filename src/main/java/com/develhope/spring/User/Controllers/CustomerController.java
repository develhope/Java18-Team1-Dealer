package com.develhope.spring.User.Controllers;

import com.develhope.spring.Purchase.Entities.DTO.CustomerPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.User.Services.CustomerService;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/get/info/{id}")
    public Vehicle getInfoById(@PathVariable Long id) {
        return customerService.getVehicleInfoByid(id);
    }
    @PostMapping("/post")
    public @ResponseBody Purchase createNewPurchase(@RequestBody CustomerPurchaseCreationDTO purchaseCreation){
        return customerService.createNewPurchase(purchaseCreation);
    }
}
