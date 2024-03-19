package com.develhope.spring.User.Controllers;

import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.User.Services.SalesmanService;
import com.develhope.spring.Vehicle.Entities.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorworld/salesman")
public class SalesmanController {
    @Autowired
    private SalesmanService salesmanService;

    @GetMapping("/get/info/{id}")
    public Vehicle getInfoById(@PathVariable Long id){
        return salesmanService.getVehicleInfoByid(id);
    }
    @GetMapping("/get/orderstatus/{id}")
    public OrderStatusEnum checkOrderStatusById(@PathVariable Long id){
        return salesmanService.checkOrderStatus(id);
    }
    @GetMapping("/get/orderslist/{orderStatus}")
    public List<Purchase> checkOrdersListByOrderStatus(@PathVariable OrderStatusEnum orderStatus){
        return salesmanService.checkOrdersListByStatus(orderStatus);
    }
    @PatchMapping("/patch/orderstatus/{id}")
    public OrderStatusEnum updateOrderStatus(@PathVariable Long id, @RequestParam OrderStatusEnum orderStatus){
        return salesmanService.updateOrderStatus(id,orderStatus);
    }

}
