package com.develhope.spring.User.Controllers;



import com.develhope.spring.Purchase.Entities.DTO.AdminPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.User.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/post")
    public @ResponseBody Purchase createNewPurchase(@RequestBody AdminPurchaseCreationDTO purchaseCreation){
        return adminService.createNewPurchase(purchaseCreation);
    }
}
