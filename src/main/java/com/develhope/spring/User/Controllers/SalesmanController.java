package com.develhope.spring.User.Controllers;

import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.User.Services.SalesmanService;
import com.develhope.spring.Vehicle.Entities.Vehicle;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorworld/salesman")
public class SalesmanController {
    @Autowired
    private SalesmanService salesmanService;

    @GetMapping("/info-vehicle/{id}")
    @Operation(summary = "Ottieni informazioni veicoli attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public Vehicle getInfoById(@PathVariable Long id){
        return salesmanService.getVehicleInfoByid(id);
    }

    @GetMapping("/status-purchase/{id}")
    @Operation(summary = "Ottieni OrderStatusEnum dell'ordine attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public OrderStatusEnum checkOrderStatusById(@PathVariable Long id){
        return salesmanService.checkOrderStatus(id);
    }

    @GetMapping("/purchases-status/{orderStatus}")
    @Operation(summary = "Ottieni lista di purchase attraverso OrderstatusEnum")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public List<Purchase> checkOrdersListByOrderStatus(@PathVariable OrderStatusEnum orderStatus){
        return salesmanService.checkOrdersListByStatus(orderStatus);
    }
    @PatchMapping("/update-orderstatus/{id}")
    @Operation(summary = "Modifica OrderStatusEnum di un ordine attraverso ID purchase")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public OrderStatusEnum updateOrderStatus(@PathVariable Long id, @RequestParam OrderStatusEnum orderStatus){
        return salesmanService.updateOrderStatus(id,orderStatus);
    }
//    @PostMapping("/neworder")
//    @Operation(summary = "Crea nuovo Purchase(ordine)")
//    @ApiResponses(value ={
//            @ApiResponse(responseCode = "200", description = "OK"),
//            @ApiResponse(responseCode = "400", description = "Bad Request"),
//            @ApiResponse(responseCode = "500", description = "Server Error")
//    })
//    public ResponseEntity<Purchase> createNewOrder(@RequestParam Long id, @RequestBody Purchase order) {
//        return ResponseEntity.ok(salesmanService.createNewOrder(id, order));
//    }

    @PutMapping("/update-order/{id}")
    @Operation(summary = "Modifica un Purchase(ordine) attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Purchase> updateOrder(@PathVariable Long id, @RequestBody Purchase order) {
        return ResponseEntity.ok(salesmanService.updateOrder(id, order));
    }

    @DeleteMapping("/delete-order/{id}")
    @Operation(summary = "Elimina un Purchase(ordine) attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Boolean> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok(salesmanService.deleteOrder(id));
    }

//    @PostMapping("/newrent")
//    @Operation(summary = "Crea nuovo Rent(noleggio)")
//    @ApiResponses(value ={
//            @ApiResponse(responseCode = "200", description = "OK"),
//            @ApiResponse(responseCode = "400", description = "Bad Request"),
//            @ApiResponse(responseCode = "500", description = "Server Error")
//    })
//    public ResponseEntity<Rent> createNewRent(@RequestParam Long id, @RequestBody Rent rent) {
//        return ResponseEntity.ok(salesmanService.createNewRent(id, rent));
//    }

    @PutMapping("/update-rent/{id}")
    @Operation(summary = "Modifica un Rent(noleggio) attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Rent> updateRent(@PathVariable Long id, @RequestBody Rent rent) {
        return ResponseEntity.ok(salesmanService.updateRent(id, rent));
    }

    @DeleteMapping("/delete-rent/{id}")
    @Operation(summary = "Elimina un Rent(noleggio) attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Boolean> deleteRent(@PathVariable Long id) {
        return ResponseEntity.ok(salesmanService.deleteRent(id));
    }

}
