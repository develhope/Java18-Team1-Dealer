package com.develhope.spring.User.Controllers;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/post/purchase")
    public Purchase createNewPurchase(@RequestParam Long idVehicle, @RequestBody Customer customer, @RequestParam BigDecimal price){
        return adminService.createNewPurchase(idVehicle,customer,price);
    }
}
