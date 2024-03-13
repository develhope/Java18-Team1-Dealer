package com.develhope.spring.User.Controllers;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.User.Services.SalesmanService;
import com.develhope.spring.Vehicle.Entities.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salesman")
public class SalesmanController {
    @Autowired
    private SalesmanService salesmanService;

    @GetMapping("/get/info/{id}")
    public Vehicle getInfoById(@PathVariable Long id){
        return salesmanService.getVehicleInfoByid(id);
    }
    @GetMapping("/get/orderstatus/{id}")
    public String checkOrderStatusById(@PathVariable Long id){
        return salesmanService.checkOrderStatus(id);
    }
    @PatchMapping("/patch/orderstatus/{id}")
    public String updateOrderStatus(@PathVariable Long id, @RequestParam String orderStatus){
        return salesmanService.updateOrderStatus(id,orderStatus);
    }
    @GetMapping("/get/orderslist/{orderStatus}")
    public List<Purchase> checkOrdersListByOrderStatus(@PathVariable String orderStatus){
        return salesmanService.checkOrdersListByStatus(orderStatus);
    }
}
