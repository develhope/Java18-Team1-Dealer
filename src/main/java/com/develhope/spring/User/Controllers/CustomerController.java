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
//    @PostMapping("/newpurchase")
//    @Operation(summary = "Crea nuovo Purchase")
//    @ApiResponses(value ={
//            @ApiResponse(responseCode = "200", description = "OK"),
//            @ApiResponse(responseCode = "400", description = "Bad Request"),
//            @ApiResponse(responseCode = "500", description = "Server Error")
//    })
//    public @ResponseBody Purchase createNewPurchase(@RequestBody CustomerPurchaseCreationDTO purchaseCreation){
//        return customerService.createNewPurchase(purchaseCreation);
//    }
//    @PostMapping("/neworder")
//    @Operation(summary = "Crea nuovo Purchase(ordine)")
//    @ApiResponses(value ={
//            @ApiResponse(responseCode = "200", description = "OK"),
//            @ApiResponse(responseCode = "400", description = "Bad Request"),
//            @ApiResponse(responseCode = "500", description = "Server Error")
//    })
//    public ResponseEntity<Purchase> createNewOrder(@RequestParam Long id, @RequestBody Purchase order) {
//        return ResponseEntity.ok(customerService.createNewOrder(id, order));
//    }

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
//    @PostMapping("/newrent")
//    @Operation(summary = "Crea nuovo Rent(noleggio)")
//    @ApiResponses(value ={
//            @ApiResponse(responseCode = "200", description = "OK"),
//            @ApiResponse(responseCode = "400", description = "Bad Request"),
//            @ApiResponse(responseCode = "500", description = "Server Error")
//    })
//    public ResponseEntity<Rent> createRent(@RequestParam Long id, @RequestBody Rent rent) {
//        return ResponseEntity.ok(customerService.createNewRent(id, rent));
//    }
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

    @GetMapping("/purchaseCList")
    public List<Purchase> purchaseList(@PathVariable Long id) {
        return customerService.myPurchase(id);
    }

    @GetMapping("/orderCList")
    public List<Purchase> orderList(@PathVariable Long id) {
        return customerService.myOrder(id);
    }

    @GetMapping("/rentCList")
    public List<Rent> rentList(@PathVariable Long id) {
        return customerService.myRent(id);
    }

    @PutMapping("/updateC")
    public Users updateC(@PathVariable Long id, @RequestBody Users customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/deleteCAccount/{id}")
    public void deleteCAccount(@PathVariable Long id) {
        customerService.deleteAccount(id);
    }

    @GetMapping("/search")
    public List<Vehicle> searchVehicles(
            @RequestParam(required = false) VehiclesTypeEnum vehiclesTypeEnum,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String colour,
            @RequestParam(required = false) Double cubiCapacity,
            @RequestParam(required = false) Integer hP,
            @RequestParam(required = false) Double kW,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate registrationYear,
            @RequestParam(required = false) FuelTypeEnum fuelTypeEnum,
            @RequestParam(required = false) BigDecimal price,
            @RequestParam(required = false) Double tradeDiscount,
            @RequestParam(required = false) Boolean newVehicle,
            @RequestParam(required = false) Double mileage,
            @RequestParam(required = false) Integer ageLimit,
            @RequestParam(required = false) StatusTypeEnum statusTypeEnum,
            @RequestParam(required = false) String currentLocation,
            @RequestParam(required = false) Boolean availableRental,
            @RequestParam(required = false) EmissionTypeEnum emissionType,
            @RequestParam(required = false) Integer passengerNumber,
            @RequestParam(required = false) Boolean windShield,
            @RequestParam(required = false) Boolean tailBag,
            @RequestParam(required = false) Boolean passengerBackrest,
            @RequestParam(required = false) TransmissionTypeEnum transmissionTypeEnum,
            @RequestParam(required = false) CarTypeEnum carTypeEnum,
            @RequestParam(required = false) TractionTypeEnum tractionTypeEnum,
            @RequestParam(required = false) Boolean optionFullTraction,
            @RequestParam(required = false) Integer doors,
            @RequestParam(required = false) Boolean centralizedClosing,
            @RequestParam(required = false) Boolean airConditioning,
            @RequestParam(required = false) Boolean bluetooth,
            @RequestParam(required = false) Boolean satNav,
            @RequestParam(required = false) Boolean electricRoof,
            @RequestParam(required = false) Boolean parkAssist,
            @RequestParam(required = false) Boolean spareTire,
            @RequestParam(required = false) Boolean antiTheft,
            @RequestParam(required = false) Boolean passengerTransport,
            @RequestParam(required = false) Boolean windowedBackDoor,
            @RequestParam(required = false) Boolean slideSideDoor,
            @RequestParam(required = false) Boolean antiCollisionSystem
    ) {
        return customerService.searchVehicleByAllCriteria(
                vehiclesTypeEnum, brand, model, colour, cubiCapacity, hP, kW, registrationYear,
                fuelTypeEnum,price, tradeDiscount, newVehicle, mileage, ageLimit, statusTypeEnum, currentLocation,
                availableRental, emissionType, passengerNumber, windShield, tailBag, passengerBackrest,
                transmissionTypeEnum, carTypeEnum, tractionTypeEnum,optionFullTraction, doors, centralizedClosing, airConditioning, bluetooth,
                satNav, electricRoof, parkAssist, spareTire, antiTheft, passengerTransport, windowedBackDoor,
                slideSideDoor, antiCollisionSystem
        );
    }
}
