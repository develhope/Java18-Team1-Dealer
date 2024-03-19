package com.develhope.spring.User.Services;

import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Entities.Salesman;
import com.develhope.spring.User.Repositories.AdminRepository;
import com.develhope.spring.User.Repositories.CustomerRepository;
import com.develhope.spring.User.Repositories.SalesmanRepository;
import com.develhope.spring.Vehicle.Entities.Enums.*;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
import com.develhope.spring.Purchase.Entities.DTO.AdminPurchaseCreationDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    SalesmanRepository salesmanRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    //get lista salesman
    public List<Salesman> getSalesmenList(){return salesmanRepository.findAll();}

    //cancella account salesman
    public Salesman deleteASalesman(Long id){
        return salesmanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salesman not found by id " + id)
                );
    }

    //modifica account salesman
    public Salesman modifySalesman(Long id,
                                   String newName,
                                   String newSurname,
                                   String newAddress,
                                   String newPhoneNumber){

        Salesman salesman = salesmanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salesman not found by id " + id));

        salesman.setFirstName(newName);
        salesman.setLastName(newSurname);
        salesman.setAddress(newAddress);
        salesman.setPhone(newPhoneNumber);

        return salesman;
    }

    //get lista customer
    public List<Customer> getCustomersList(){return customerRepository.findAll();}

    //cancella account customer
    public Customer deleteACustomer(Long id){

        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found by id " + id));
    }

    //modifica account customer
    public Customer modifyCustomer(Long id,
                                   String newName,
                                   String newSurname,
                                   String newAddress,
                                   String newPhoneNumber){

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salesman not found by id " + id));

        customer.setFirstName(newName);
        customer.setLastName(newSurname);
        customer.setAddress(newAddress);
        customer.setPhone(newPhoneNumber);

        return customer;
    }

    //aggiungi veicolo
    public Vehicle newVehicle(Vehicle vehicle){

        return vehicleRepository.save(vehicle);
    }

    //cancella veicolo
    public Boolean deleteVehicle(Long id){
        Vehicle vehicleDeleted = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle id " + id + " to delete not found"));
        purchaseRepository.deleteById(id);
        vehicleRepository.deleteById(id);
        return true;
    }

    //modifica veicolo
        public Vehicle updateVehicle(Long id, Vehicle vehicle){
        Vehicle vehicleUpdated = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle id " + id + " to update not found"));

        if(vehicle.getVehiclesTypeEnum() != null && Arrays.asList(VehiclesTypeEnum.values()).contains(vehicle.getVehiclesTypeEnum())){
            vehicleUpdated.setVehiclesTypeEnum(vehicle.getVehiclesTypeEnum());
        }
        if(vehicle.getBrand() != null && !vehicle.getBrand().isEmpty()){
            vehicleUpdated.setBrand(vehicle.getBrand());
        }
        if(vehicle.getModel() != null && !vehicle.getModel().isEmpty()){
            vehicleUpdated.setModel(vehicle.getModel());
        }
        if(vehicle.getColour() != null && !vehicle.getColour().isEmpty()){
            vehicleUpdated.setColour(vehicle.getColour());
        }
        if(vehicle.getCubiCapacity() != null){
            vehicleUpdated.setCubiCapacity(vehicle.getCubiCapacity());
        }
        if(vehicle.getHP() != null){
            vehicleUpdated.setHP(vehicle.getHP());
        }
        if(vehicle.getKW() != null){
            vehicleUpdated.setKW(vehicle.getKW());
        }
        if(vehicle.getRegistrationYear() != null){
            vehicleUpdated.setRegistrationYear(vehicle.getRegistrationYear());
        }
        if(vehicle.getFuelTypeEnum() != null && Arrays.asList(FuelTypeEnum.values()).contains(vehicle.getFuelTypeEnum())){
            vehicleUpdated.setFuelTypeEnum(vehicle.getFuelTypeEnum());
        }
        if(vehicle.getPrice() != null){
            vehicleUpdated.setPrice(vehicle.getPrice());
        }
        //nullable column
        vehicleUpdated.setTradeDiscount(vehicle.getTradeDiscount());

        if(vehicle.getNewVehicle() != null){
            vehicleUpdated.setNewVehicle(vehicle.getNewVehicle());
        }
        //nullable column
        vehicleUpdated.setMileage(vehicle.getMileage());

        if(vehicle.getAgeLimit() != null){
            vehicleUpdated.setAgeLimit(vehicle.getAgeLimit());
        }
        if(vehicle.getStatusTypeEnum() != null && Arrays.asList(StatusTypeEnum.values()).contains(vehicle.getStatusTypeEnum())){
            vehicleUpdated.setStatusTypeEnum(vehicle.getStatusTypeEnum());
        }
        //nullable column
        vehicleUpdated.setCurrentLocation(vehicle.getCurrentLocation());

        if(vehicle.getAvailableRental() != null){
            vehicleUpdated.setAvailableRental(vehicle.getAvailableRental());
        }
        if(vehicle.getEmissionTypeEnum() != null && Arrays.asList(EmissionTypeEnum.values()).contains(vehicle.getEmissionTypeEnum())){
            vehicleUpdated.setEmissionTypeEnum(vehicle.getEmissionTypeEnum());
        }
        if(vehicle.getPassengerNumber() != null){
            vehicleUpdated.setPassengerNumber(vehicle.getPassengerNumber());
        }
        //nullable column
        vehicleUpdated.setWindShield(vehicle.getWindShield());

        vehicleUpdated.setTailBag(vehicle.getTailBag());

        vehicleUpdated.setPassengerBackrest(vehicle.getPassengerBackrest());

        vehicleUpdated.setTransmissionTypeEnum(vehicle.getTransmissionTypeEnum());

        vehicleUpdated.setCarTypeEnum(vehicle.getCarTypeEnum());

        vehicleUpdated.setTractionTypeEnum(vehicle.getTractionTypeEnum());

        vehicleUpdated.setOptionFullTraction(vehicle.getOptionFullTraction());

        vehicleUpdated.setDoors(vehicle.getDoors());

        vehicleUpdated.setCentralizedClosing(vehicle.getCentralizedClosing());

        vehicleUpdated.setAirConditioning(vehicle.getAirConditioning());

        vehicleUpdated.setBluetooth(vehicle.getBluetooth());

        vehicleUpdated.setSatNav(vehicle.getSatNav());

        vehicleUpdated.setElectricRoof(vehicle.getElectricRoof());

        vehicleUpdated.setParkAssist(vehicle.getParkAssist());

        vehicleUpdated.setSpareTire(vehicle.getSpareTire());

        vehicleUpdated.setAntiTheft(vehicle.getAntiTheft());

        vehicleUpdated.setPassengerTransport(vehicle.getPassengerTransport());

        vehicleUpdated.setWindowedBackDoor(vehicle.getWindowedBackDoor());

        vehicleUpdated.setSlideSideDoor(vehicle.getSlideSideDoor());

        vehicleUpdated.setAntiCollisionSystem(vehicle.getAntiCollisionSystem());

        return vehicleRepository.save(vehicleUpdated);
    }

    //cambia STATUS di un veicolo
    public Vehicle updateStatusType(Long id, StatusTypeEnum statusType){
        Vehicle vehicleUpdated = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle id " + id + " to update not found"));

        if(statusType != null && Arrays.asList(StatusTypeEnum.values()).contains(statusType)) {
            vehicleUpdated.setStatusTypeEnum(statusType);
            return vehicleRepository.save(vehicleUpdated);
        }else{
            throw new EntityNotFoundException("Status type of vehicle not correct");
        }
    }

    //modifica ACQUISTO per un CUSTOMER
    public List<Purchase> updatePurchaseById(Long idCustomer, Long idPurchase, Purchase purchaseUpdated){
        if(idCustomer != null && idPurchase != null && customerRepository.findById(idCustomer).isPresent()
                && purchaseRepository.findById(idPurchase).isPresent()) {

            List<Purchase> purchaseListByCustomer = purchaseRepository.purchasesByCustomer(idCustomer);

            for (Purchase purchase : purchaseListByCustomer){
                if (Objects.equals(purchase.getId(), idPurchase)){
                    if(purchaseUpdated.getAdvancePayment() != null) {
                        purchase.setAdvancePayment(purchaseUpdated.getAdvancePayment());
                    }
                    if(purchaseUpdated.getIsPaid() != null){
                        purchase.setIsPaid(purchaseUpdated.getIsPaid());
                    }
                    if(purchaseUpdated.getOrderStatusEnum() != null){
                        purchase.setOrderStatusEnum(purchaseUpdated.getOrderStatusEnum());
                    }
                }
                purchaseRepository.save(purchase);
            }
            return purchaseListByCustomer;
        }else{
            throw new RuntimeException("Something went wrong");
        }
    }

    //cancella ACQUISTO per un CUSTOMER
    public Boolean deletePurchaseById(Long idCustomer, Long idPurchase){
        if(idCustomer != null && idPurchase != null && customerRepository.findById(idCustomer).isPresent()
                && purchaseRepository.findById(idPurchase).isPresent()) {
            Iterator<Purchase> iterator = purchaseRepository.purchasesByCustomer(idCustomer).listIterator();
            while (iterator.hasNext()){
                Purchase purchase = iterator.next();
                if(idPurchase.equals(purchase.getId())){
                    iterator.remove();
                    break;
                }
            }
            return true;
        }else{
            throw new RuntimeException("Something went wrong");
        }
    }


    //ottieni VEICOLI filtrandoli per STATUSTYPE
    public List<Vehicle> vehiclesByStatusType(StatusTypeEnum statusType){
        Optional<List<Vehicle>> optionalVehicles = vehicleRepository.vehiclesByStatusType(statusType);
        if(optionalVehicles.isPresent()) {
            return optionalVehicles.get();
        } else {
            throw new RuntimeException("Vehicle status " + statusType + " not found");
        }
    }
    public Purchase createNewPurchase(AdminPurchaseCreationDTO dto){
        Vehicle vehicle = vehicleRepository.findById(dto.getIdVehicle()).orElseThrow(() -> new NoSuchElementException("Veicolo con id " + dto.getIdVehicle() + " non trovato"));
        Salesman salesman = salesmanRepository.findById(dto.getSalesman().getId()).orElseThrow(() -> new NoSuchElementException("Venditore con id " + dto.getSalesman().getId() + " non trovato"));
        Customer customer = customerRepository.findById(dto.getCustomer().getId()).orElseThrow(() -> new NoSuchElementException("Venditore con id " + dto.getCustomer().getId() + " non trovato"));
        if(vehicle.getStatusTypeEnum().equals(StatusTypeEnum.PURCHASABLE)){
            Purchase purchase = new Purchase();
            purchase.setVehicle(vehicle);
            purchase.setSalesman(salesman);
            purchase.setCustomer(customer);
            purchase.setAdvancePayment(vehicle.getPrice());
            purchase.setIsPaid(false);
            purchase.setVehicleStatusEnum(dto.getVehicleStatus());
            purchase.setOrderStatusEnum(OrderStatusEnum.COMPLETED);

            vehicle.setStatusTypeEnum(StatusTypeEnum.SOLD);
            vehicleRepository.save(vehicle);
            return purchaseRepository.save(purchase);
        } else {
            throw new IllegalStateException("Il veicolo non è acquistabile.");
        }
    }
}

