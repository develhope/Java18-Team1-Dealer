package com.develhope.spring.User.Controllers;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CustomerController {
    @Autowired
     CustomerService customerService;

    @GetMapping("/purchaseCList")
    public List<Purchase> purchaseList (@PathVariable Long id){
        return customerService.myPurchase(id);
    }

    @GetMapping("/orderCList")
    public List<Purchase> orderList (@PathVariable Long id){
        return customerService.myOrder(id);
    }

    @GetMapping("/rentCList")
    public List<Rent> rentList (@PathVariable Long id){
        return customerService.myRent(id);
    }

    @PutMapping("/updateC")
    public Customer updateC(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/deleteCAccount/{id}")
    public void deleteCAccount(@PathVariable Long id){
        customerService.deleteAccount(id);
    }
}
