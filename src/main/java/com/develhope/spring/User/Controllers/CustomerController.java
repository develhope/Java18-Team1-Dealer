package com.develhope.spring.User.Controllers;

import com.develhope.spring.Purchase.Entities.DTO.CustomerPurchaseCreationDTO;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.User.Entities.Users;
import com.develhope.spring.User.Repositories.UsersRepository;
import com.develhope.spring.User.Services.CustomerService;
import com.develhope.spring.Vehicle.Entities.Enums.*;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/motorworld/customer")
public class CustomerController {
    @Autowired
    private UsersRepository usersRepository;
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
    @PostMapping("/neworder")
    @Operation(summary = "Crea nuovo Purchase(ordine)")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Purchase> createNewOrder(@RequestParam Long id, @RequestBody Purchase order) {
        return ResponseEntity.ok(customerService.createNewOrder(id, order));
    }

    @DeleteMapping("/delete-order/{id}")
    @Operation(summary = "Elimina un Purchase(ordine) attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Boolean> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.deleteOrder(id));
    }
    @PostMapping("/newrent")
    @Operation(summary = "Crea nuovo Rent(noleggio)")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Rent> createRent(@RequestParam Long id, @RequestBody Rent rent) {
        return ResponseEntity.ok(customerService.createNewRent(id, rent));
    }
    @DeleteMapping("/delete-rent/{id}")
    @Operation(summary = "Elimina un Rent(noleggio) attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Boolean> deleteRent(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.deleteRent(id));
    }

    @GetMapping("/purchases/{id}")
    @Operation(summary = "Ottieni lista di acquisti del cliente attraverso ID acquisto(Purchase)")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public List<Purchase> purchaseList(@PathVariable Long id) {
        return customerService.myPurchase(id);
    }

    @GetMapping("/orders/{id}")
    @Operation(summary = "Ottieni lista di ordini del cliente attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public List<Purchase> orderList(@PathVariable Long id) {
        return customerService.myOrder(id);
    }

    @GetMapping("/rents/{id}")
    @Operation(summary = "Ottieni lista di noleggi del cliente attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public List<Rent> rentList(@PathVariable Long id) {
        return customerService.myRent(id);
    }

    @PutMapping("/update-customer/{id}")
    @Operation(summary = "Aggiorna dati e profilo del cliente attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public Users updateC(@PathVariable Long id, @RequestBody Users customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    @Operation(summary = "Elimina account del cliente attraverso ID cliente")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public void deleteCAccount(@PathVariable Long id) {
        customerService.deleteAccount(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Ottieni una lista di veicoli scegliendo un parametro di ricerca")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public List<Vehicle> searchVehiclesByAttribute(@RequestParam String key, @RequestParam String value){
        return customerService.vehicleListForParams(key, value);

    }
}
