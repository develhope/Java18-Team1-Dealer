package com.develhope.spring.User.Controllers;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.ShowroomProfit.ShowroomProfitRepository;
import com.develhope.spring.User.DTO.CustomerDTO;
import com.develhope.spring.User.DTO.SalesmanDTO;
import com.develhope.spring.User.Entities.Users;
import com.develhope.spring.User.Services.AdminService;
import com.develhope.spring.Vehicle.DTO.VehicleMostSoldDTO;
import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.develhope.spring.Purchase.Entities.DTO.AdminPurchaseCreationDTO;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/motorworld/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ShowroomProfitRepository showroomProfitRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping("/newvehicle")
    @Operation(summary = "Creazione nuovo veicolo")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseBody Vehicle newVehicle(@RequestBody Vehicle vehicle){

        return adminService.newVehicle(vehicle);
    }

    @DeleteMapping("/delete-vehicle/{id}")
    @Operation(summary = "Eliminazione di un veicolo attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseStatus HttpEntity<String> deleteVehicle(@PathVariable Long id){
        Boolean response = adminService.deleteVehicle(id);
        if(response = true){
            return ResponseEntity.ok().body("Vehicle deleted");
        }else{
            return ResponseEntity.badRequest().body("Vehicle sold or not available");
        }
    }

    @PutMapping("/update-vehicle/{id}")
    @Operation(summary = "Modifica dei valori del veicolo attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseBody Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle){
        return adminService.updateVehicle(id, vehicle);
    }

    @PatchMapping("/update-vehiclestatus/{id}")
    @Operation(summary = "Modifica dello statusType di un veicolo attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseBody Vehicle updateStatusVehicle(@PathVariable Long id, @RequestParam (value = "statusType") StatusTypeEnum statusTypeEnum){
        return adminService.updateStatusType(id, statusTypeEnum);
    }

    @GetMapping("/status-type/{statusType}")
    @Operation(summary = "Lista dei veicoli filtrati attraverso statusType")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<List<Vehicle>> vehicleByStatusType(@PathVariable StatusTypeEnum statusType){
        List<Vehicle> vehiclesByStatusType = adminService.vehiclesByStatusType(statusType);
        if(vehiclesByStatusType != null) {
            return ResponseEntity.ok().body(vehiclesByStatusType);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update-purchase/{idCustomer}/{idPurchase}")
    @Operation(summary = "Modifica di un acquisto attraverso ID cliente e ID acquisto")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<List<Purchase>> updatePurchase(
            @PathVariable Long idCustomer, @PathVariable Long idPurchase, @RequestBody Purchase purchase){
        List<Purchase> customerPurchases = adminService.updatePurchaseById(idCustomer, idPurchase, purchase);
        if(customerPurchases != null) {
            return ResponseEntity.ok().body(customerPurchases);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-purchase/{idCustomer}/{idPurchase}")
    @Operation(summary = "Elimina un acquisto attraverso ID purchase")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseStatus HttpEntity<String> deletePurchase(@PathVariable Long idCustomer, @PathVariable Long idPurchase){
        Boolean response = adminService.deletePurchaseById(idCustomer, idPurchase);
        if(response = true){
            return ResponseEntity.ok().body("Purchase deleted");
        }else{
            return ResponseEntity.badRequest().body("Purchase not deleted");
        }
    }

    @PostMapping("/newpurchase")
    @Operation(summary = "Crea nuovo Purchase")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseBody Purchase createNewPurchase(@RequestBody AdminPurchaseCreationDTO purchaseCreation) {
        return adminService.createNewPurchase(purchaseCreation);
    }

    @GetMapping("/getAll/salesmen")
    @Operation(summary = "Ottiene la lista dei venditori")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public List<SalesmanDTO> getAllSalesmen(){return adminService.getSalesmenList();}

    @DeleteMapping("/delete-salesman/{id}")
    @Operation(summary = "Elimina un venditore attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseStatus HttpEntity<String> deleteSalesman(@PathVariable Long id)
    {

        Boolean response = adminService.deleteASalesman(id);
        if (response = true){

            return ResponseEntity.ok().body("Salesman deleted");

        }else{

            return ResponseEntity.badRequest().body("Salesman not deleted");
        }
    }

    @PutMapping("/update-salesman/{id}")
    @Operation(summary = "Modifica un venditore tramite ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseBody Users updateSalesman(@PathVariable Long id,
                                              @RequestBody Users salesman)
    {
        return adminService.modifySalesman(id, salesman);
    }

    @GetMapping("/getAll/customers")
    @Operation(summary = "Ottiene la lista dei clienti")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public List<CustomerDTO> getAllCustomers(){return adminService.getCustomersList();}

    @DeleteMapping("/delete-customer/{id}")
    @Operation(summary = "Elimina un cliente attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseStatus HttpEntity<String> deleteCustomer(@PathVariable Long id)
    {

        Boolean response = adminService.deleteACustomer(id);
        if (response = true){

            return ResponseEntity.ok().body("Customer deleted");

        }else{

            return ResponseEntity.badRequest().body("Customer not deleted");
        }
    }

    @PutMapping("/update-customer/{id}")
    @Operation(summary = "Modifica un cliente attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseBody Users updateCustomer(@PathVariable Long id,
                                                 @RequestBody Users customer)
    {
        return adminService.modifyCustomer(id, customer);
    }

    @PostMapping("/neworder")
    @Operation(summary = "Crea nuovo Purchase(ordine)")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Purchase> createOrder(@RequestParam Long id, @RequestBody Purchase order) {
        return ResponseEntity.ok(adminService.createNewOrder(id, order));
    }

    @PutMapping("/update-order/{id}")
    @Operation(summary = "Modifica un Purchase(ordine) attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Purchase> updateOrder(@PathVariable Long id, @RequestBody Purchase order) {
        return ResponseEntity.ok(adminService.updateOrder(id, order));
    }

    @DeleteMapping("/delete-order/{id}")
    @Operation(summary = "Elimina un Purchase(ordine) attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Boolean> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteOrder(id));
    }

    @PostMapping("/newrent")
    @Operation(summary = "Crea nuovo Rent(noleggio)")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Rent> createRent(@RequestParam Long id, @RequestBody Rent rent) {
        return ResponseEntity.ok(adminService.createNewRent(id, rent));
    }

    @PutMapping("/update-rent/{id}")
    @Operation(summary = "Modifica un Rent(noleggio) attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Rent> updateRent(@PathVariable Long id, @RequestBody Rent rent) {
        return ResponseEntity.ok(adminService.updateRent(id, rent));
    }

    @DeleteMapping("/delete-rent/{id}")
    @Operation(summary = "Elimina un Rent(noleggio) attraverso ID")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Boolean> deleteRent(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteRent(id));
    }
    @GetMapping("/most-expsold-vehicle")
    @Operation(summary = "Ottieni il veicolo più costoso venduto fino a questo momento")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public @ResponseBody Vehicle mostExpSoldVehicle(){
        return adminService.mostExpensiveVehicleSold();
    }

    @GetMapping("/count-purchase/{id}")
    @Operation(summary = "Numero di vendite in un dato periodo attraverso ID salesman")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Object> countPurchasesSalesman(@PathVariable Long id, @RequestParam LocalDate startDate,
                                                     @RequestParam LocalDate endDate){
        if(id != null && startDate !=null && endDate != null){
            Long result = showroomProfitRepository.countPurchaseForSalesman(id, startDate, endDate);
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }
    @GetMapping("/profit-bysalesman/{id}")
    @Operation(summary = "Guadagno di un venditore in un certo periodo di tempo tramite ID salesman")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Object> profitsBySalesman(@PathVariable Long id, @RequestParam LocalDate startDate,
                                               @RequestParam LocalDate endDate){
        if(id != null && startDate !=null && endDate != null){
            Double profitBySalesman = showroomProfitRepository.profitBySalesman(id, startDate, endDate);
            return ResponseEntity.ok(profitBySalesman);
        }else{
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }
    @GetMapping("/profit")
    @Operation(summary = "Guadagno complessivo autosalone in un certo periodo di tempo")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Object> allProfits(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        if(startDate !=null && endDate != null){
            Double profits = showroomProfitRepository.profitShowroom(startDate, endDate);
            return ResponseEntity.ok(profits);
        }else{
            return ResponseEntity.badRequest().body("Insert valid dates");
        }
    }
    @GetMapping("/most-sold")
    @Operation(summary = "Veicolo più venduto nell'autosalone in un certo periodo di tempo")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<Object> mostPurchaseVehicle(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        if(startDate !=null && endDate != null){
            VehicleMostSoldDTO vehicleMostSoldDTO = vehicleRepository.mostPurchasesVehicle(startDate, endDate).getFirst();
            return ResponseEntity.ok(vehicleMostSoldDTO);
        }else{
            return ResponseEntity.badRequest().body("Insert valid dates");
        }
    }
}
