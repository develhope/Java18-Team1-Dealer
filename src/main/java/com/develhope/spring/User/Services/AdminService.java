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
  
    //get lista salesman
    public List<Salesman> getSalesmenList(){return salesmanRepository.findAll();}

    //cancella account salesman
    public Salesman deleteASalesman(Long id){
        return salesmanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salesman not fund by id " + id)
                );
    }

    //modifica account salesman
    public Salesman modifySalesman(Long id,
                                   String newName,
                                   String newSurname,
                                   String newAddress,
                                   String newPhoneNumber){

        Salesman salesman = salesmanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salesman not fund by id " + id));

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
                .orElseThrow(
                        () -> new EntityNotFoundException("Customer not fund by id " + id)
                );
    }

    //modifica account customer
    public Customer modifyCustomer(Long id,
                                   String newName,
                                   String newSurname,
                                   String newAddress,
                                   String newPhoneNumber){

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
        Vehicle vehicleDeleted = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veicolo da cancellare non presente nel Database"));

        vehicleRepository.deleteById(id);
        return true;

    }

    //modifica veicolo
    public Vehicle updateVehicle(Long id, Vehicle vehicle){
        Vehicle vehicleUpdated = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veicolo da aggiornare non presente nel Database"));
        if(vehicleUpdated.getVehiclesTypeEnum() != null) {
            vehicleUpdated.setVehiclesTypeEnum(vehicle.getVehiclesTypeEnum());
        }
        if(vehicleUpdated.getBrand() != null && !vehicleUpdated.getBrand().isEmpty()){
            vehicleUpdated.setBrand(vehicleUpdated.getBrand());
        }
        if(vehicleUpdated.getModel() != null && !vehicleUpdated.getModel().isEmpty()) {
            vehicleUpdated.setModel(vehicleUpdated.getModel());
        }
        if(vehicleUpdated.getColour() != null && !vehicleUpdated.getColour().isEmpty()){
            vehicleUpdated.setColour(vehicleUpdated.getColour());
        }
        //TODO: da finire qui
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

        return vehicleRepository.save(vehicleUpdated);
    }

    //cambia STATUS di un veicolo
    public Vehicle updateStatusType(Long id, StatusTypeEnum statusTypeEnum){
        Vehicle vehicleUpdated = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veicolo da aggiornare non presente nel Database"));

        vehicleUpdated.setStatusTypeEnum(statusTypeEnum);

        return vehicleRepository.save(vehicleUpdated);
    }

    //modifica ACQUISTO per un CUSTOMER
    public List<Purchase> updatePurchaseById(Long idCustomer, Long idPurchase, Purchase purchaseUpdated){
        if(idCustomer != null && idPurchase != null) {

            List<Purchase> purchaseListByCustomer = purchaseRepository.purchasesByCustomer(idCustomer);

            //TODO: finire qui
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

