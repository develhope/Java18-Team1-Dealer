package com.develhope.spring.User.Controllers;

import com.develhope.spring.Purchase.Entities.DTO.CustomerPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.User.Services.CustomerService;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/motorworld/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/info-vehicle/{id}")
    @Operation(summary = "Ottieni informazioni veicoli attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public Vehicle getInfoById(@PathVariable Long id) {
        return customerService.getVehicleInfoByid(id);
    }
    @PostMapping("/newpurchase")
    @Operation(summary = "Crea nuovo Purchase")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseBody Purchase createNewPurchase(@RequestBody CustomerPurchaseCreationDTO purchaseCreation){
        return customerService.createNewPurchase(purchaseCreation);
    }
}
