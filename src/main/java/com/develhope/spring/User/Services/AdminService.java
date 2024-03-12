package com.develhope.spring.User.Services;


import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Entities.Salesman;
import com.develhope.spring.User.Repositories.AdminRepository;
import com.develhope.spring.User.Repositories.CustomerRepository;
import com.develhope.spring.User.Repositories.SalesmanRepository;
import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Purchase.Repositories.PurchaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

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
  

    public List<Salesman> salesmenList(){return salesmanRepository.findAll();}

    public Salesman deleteASalesman(Long id){

        return salesmanRepository.findById(id)
                .orElseThrow(

                        () -> new EntityNotFoundException("Salesman not fund by id " + id)

                );
    }

    public Salesman modifySalesman(Long id,
                                   String newName,
                                   String newSurname,
                                   String newAddress,
                                   Integer newPhoneNumber){

        Salesman salesman = salesmanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salesman not fund by id " + id));

        salesman.setFirstName(newName);
        salesman.setLastName(newSurname);
        salesman.setAddress(newAddress);
        salesman.setPhone(newPhoneNumber);

        return salesman;
    }

    public List<Customer> customersList(){return customerRepository.findAll();}

    public Customer deleteACustomer(Long id){

        return customerRepository.findById(id)
                .orElseThrow(

                        () -> new EntityNotFoundException("Customer not fund by id " + id)

                );
    }

    public Customer modifyCustomer(Long id,
                                   String newName,
                                   String newSurname,
                                   String newAddress,
                                   Integer newPhoneNumber){

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salesman not fund by id " + id));

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
        Vehicle vehicleDeleted = vehicleRepository.findById(id).orElse(null);
        if (vehicleDeleted != null){
            vehicleRepository.deleteById(id);
            return true;
        }else {
            throw new RuntimeException("Veicolo da cancellare non presente nel Database");
        }
    }

    //modifica veicolo
    public Vehicle updateVehicle(Long id, Vehicle vehicle){
        Vehicle vehicleUpdated = vehicleRepository.findById(id).orElse(null);
        if(vehicle != null){
            vehicleUpdated.setVehiclesTypeEnum(vehicle.getVehiclesTypeEnum());
            vehicleUpdated.setBrand(vehicleUpdated.getBrand());
            vehicleUpdated.setModel(vehicleUpdated.getModel());
            vehicleUpdated.setColour(vehicleUpdated.getColour());
            vehicleUpdated.setCubiCapacity(vehicleUpdated.getCubiCapacity());
            vehicleUpdated.setHP(vehicle.getHP());
            vehicleUpdated.setKW(vehicle.getKW());
            vehicleUpdated.setRegistrationYear(vehicle.getRegistrationYear());
            vehicleUpdated.setFuelTypeEnum(vehicle.getFuelTypeEnum());
            vehicleUpdated.setPrice(vehicle.getPrice());
            vehicleUpdated.setTradeDiscount(vehicle.getTradeDiscount());
            vehicleUpdated.setNewVehicle(vehicle.getNewVehicle());
            vehicleUpdated.setMileage(vehicleUpdated.getMileage());
            vehicleUpdated.setAgeLimit(vehicle.getAgeLimit());
            vehicleUpdated.setStatusTypeEnum(vehicle.getStatusTypeEnum());
            vehicleUpdated.setCurrentLocation(vehicle.getCurrentLocation());
            vehicleUpdated.setAvailableRental(vehicle.getAvailableRental());
            vehicleUpdated.setEmissionTypeEnum(vehicle.getEmissionTypeEnum());
            vehicleUpdated.setPassengerNumber(vehicle.getPassengerNumber());
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
        }else {
            throw new RuntimeException("Veicolo da aggiornare non presente nel Database");
        }
        return vehicleUpdated;
    }

    //cambia STATUS di un veicolo
    public Vehicle updateStatusType(Long id, StatusTypeEnum statusTypeEnum){
        Vehicle vehicleUpdated = vehicleRepository.findById(id).orElse(null);
        if(vehicleUpdated != null){
            vehicleUpdated.setStatusTypeEnum(statusTypeEnum);
        }else {
            throw new RuntimeException("Veicolo da aggiornare non presente nel Database");
        }
        return vehicleUpdated;
    }

    //modifica ACQUISTO per un CUSTOMER (versione in cui è pure presente id Customer, controllare se necessario)
    //no id updated, si salesman e customer
    public List<Purchase> updatePurchaseById(Long idCustomer, Long idPurchase, Purchase purchaseUpdated){
        if(idCustomer != null && idPurchase != null) {
            List<Purchase> purchaseListByCustomer = purchaseRepository.purchasesByCustomer(idCustomer);
            for (Purchase purchase : purchaseListByCustomer){
                if (purchase.getId() == idPurchase){
                    purchase.setAdvancePayment(purchaseUpdated.getAdvancePayment());
                    purchase.setIsPaid(purchaseUpdated.getIsPaid());
                    purchase.setOrderStatus(purchaseUpdated.getOrderStatus());
                    purchase.setCustomer(purchaseUpdated.getCustomer());
                    purchase.setSalesman(purchaseUpdated.getSalesman());
                }
                purchaseRepository.save(purchase);
            }
            return purchaseListByCustomer;
        }else{
            throw new RuntimeException("Acquisto del cliente id " + idCustomer + " non aggiornato correttamente");
        }
    }


    //cancella ACQUISTO per un CUSTOMER
    //scriverlo in vehicleRepo
    public Boolean deletePurchaseById(Long idCustomer, Long idPurchase){
        if(idCustomer != null && idPurchase != null) {
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
            throw new RuntimeException("Operazione non riuscita");
        }
    }


    //ottieni VEICOLI filtrandoli per STATUSTYPE
    public List<Vehicle> vehiclesByStatusType(StatusTypeEnum statusTypeEnum){
        if(statusTypeEnum != null){
        return vehicleRepository.vehiclesByStatusType(statusTypeEnum);
        }else {
            throw new RuntimeException("Errore nell'inserimento dello stato dei veicoli da ricercare");
        }
    }
}

