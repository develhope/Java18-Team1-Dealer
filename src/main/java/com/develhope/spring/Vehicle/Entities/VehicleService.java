package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.DTO.CarDTO;
import com.develhope.spring.Vehicle.DTO.MotorBikeDTO;
import com.develhope.spring.Vehicle.DTO.ScooterDTO;
import com.develhope.spring.Vehicle.DTO.VanDTO;
import com.develhope.spring.Vehicle.Entities.Enums.VehiclesType;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;


    //Usare SOLO con COSTUMER per mostrargli i veicoli. Escludere dalla lista i veicoli VENDUTI e NON DISPONIBILI
    //clienti vedono solo ORDINABILE o DISPONIBILE
    //NB scooter e moto SOLO elettrici o benzina
    public List<Object> allVehiclesDTO(List<Vehicle> vehicles) throws Exception{
        List<Object> vehiclesDTO = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            if(vehicle.getVehiclesType().equals(VehiclesType.SCOOTER)){
                vehiclesDTO.add(getScooterDTO(vehicle));
            } else if (vehicle.getVehiclesType().equals(VehiclesType.MOTORBIKE)) {
                vehiclesDTO.add(getMotorBikeDTO(vehicle));
            } else if (vehicle.getVehiclesType().equals(VehiclesType.CAR)) {
                vehiclesDTO.add(getCarDTO(vehicle));
            } else if (vehicle.getVehiclesType().equals(VehiclesType.VAN)) {
                vehiclesDTO.add(getVanDTO(vehicle));
            }
        }
        return vehiclesDTO;
    }
    private ScooterDTO getScooterDTO(Vehicle vehicle){
        ScooterDTO scooterDTO = new ScooterDTO();
        scooterDTO.setId(vehicle.getId());
        scooterDTO.setBrand(vehicle.getBrand());
        scooterDTO.setModel(vehicle.getModel());
        scooterDTO.setColour(vehicle.getColour());
        scooterDTO.setCubiCapacity(vehicle.getCubiCapacity());
        scooterDTO.sethP(vehicle.getHP());
        scooterDTO.setkW(vehicle.getKW());
        scooterDTO.setRegistrationYear(vehicle.getRegistrationYear());
        scooterDTO.setFuelType(vehicle.getFuelType());
        scooterDTO.setPrice(vehicle.getPrice());
        scooterDTO.setNewVehicle(vehicle.getNewVehicle());
        scooterDTO.setMileage(vehicle.getMileage());
        scooterDTO.setStatusType(vehicle.getStatusType());
        scooterDTO.setCurrentLocation(vehicle.getCurrentLocation());
        scooterDTO.setEmissionType(vehicle.getEmissionType());
        scooterDTO.setPassengerNumber(vehicle.getPassengerNumber());
        scooterDTO.setWindShield(vehicle.getWindShield());
        scooterDTO.setTailBag(vehicle.getTailBag());
        scooterDTO.setPassengerBackrest(vehicle.getPassengerBackrest());
        scooterDTO.setAvailableRental(vehicle.getAvailableRental());
        return scooterDTO;
    }
    private MotorBikeDTO getMotorBikeDTO(Vehicle vehicle){
        MotorBikeDTO motorBikeDTO = new MotorBikeDTO();
        motorBikeDTO.setId(vehicle.getId());
        motorBikeDTO.setBrand(vehicle.getBrand());
        motorBikeDTO.setModel(vehicle.getModel());
        motorBikeDTO.setColour(vehicle.getColour());
        motorBikeDTO.setCubiCapacity(vehicle.getCubiCapacity());
        motorBikeDTO.sethP(vehicle.getHP());
        motorBikeDTO.setkW(vehicle.getKW());
        motorBikeDTO.setTransmissionType(vehicle.getTransmissionType());
        motorBikeDTO.setRegistrationYear(vehicle.getRegistrationYear());
        motorBikeDTO.setFuelType(vehicle.getFuelType());
        motorBikeDTO.setPrice(vehicle.getPrice());
        motorBikeDTO.setNewVehicle(vehicle.getNewVehicle());
        motorBikeDTO.setMileage(vehicle.getMileage());
        motorBikeDTO.setStatusType(vehicle.getStatusType());
        motorBikeDTO.setCurrentLocation(vehicle.getCurrentLocation());
        motorBikeDTO.setEmissionType(vehicle.getEmissionType());
        motorBikeDTO.setPassengerNumber(vehicle.getPassengerNumber());
        motorBikeDTO.setWindShield(vehicle.getWindShield());
        motorBikeDTO.setTailBag(vehicle.getTailBag());
        motorBikeDTO.setPassengerBackrest(vehicle.getPassengerBackrest());
        motorBikeDTO.setAvailableRental(vehicle.getAvailableRental());
        return motorBikeDTO;
    }
    private CarDTO getCarDTO(Vehicle vehicle){
        CarDTO carDTO = new CarDTO();
        carDTO.setId(vehicle.getId());
        carDTO.setBrand(vehicle.getBrand());
        carDTO.setModel(vehicle.getModel());
        carDTO.setColour(vehicle.getColour());
        carDTO.setCubiCapacity(vehicle.getCubiCapacity());
        carDTO.sethP(vehicle.getHP());
        carDTO.setkW(vehicle.getKW());
        carDTO.setRegistrationYear(vehicle.getRegistrationYear());
        carDTO.setFuelType(vehicle.getFuelType());
        carDTO.setPrice(vehicle.getPrice());
        carDTO.setNewVehicle(vehicle.getNewVehicle());
        carDTO.setMileage(vehicle.getMileage());
        carDTO.setEmissionType(vehicle.getEmissionType());
        carDTO.setPassengerNumber(vehicle.getPassengerNumber());
        carDTO.setTransmissionType(vehicle.getTransmissionType());
        carDTO.setStatusType(vehicle.getStatusType());
        carDTO.setCarType(vehicle.getCarType());
        carDTO.setTractionType(vehicle.getTractionType());
        carDTO.setOptionFullTraction(vehicle.getOptionFullTraction());
        carDTO.setDoors(vehicle.getDoors());
        carDTO.setCentralizedClosing(vehicle.getCentralizedClosing());
        carDTO.setAirConditioning(vehicle.getAirConditioning());
        carDTO.setBluetooth(vehicle.getBluetooth());
        carDTO.setSatNav(vehicle.getSatNav());
        carDTO.setElectricRoof(vehicle.getElectricRoof());
        carDTO.setParkAssist(vehicle.getParkAssist());
        carDTO.setSpareTire(vehicle.getSpareTire());
        carDTO.setAntiTheft(vehicle.getAntiTheft());
        carDTO.setCurrentLocation(vehicle.getCurrentLocation());
        carDTO.setAvailableRental(vehicle.getAvailableRental());
        return carDTO;
    }
    private VanDTO getVanDTO(Vehicle vehicle){
        VanDTO vanDTO = new VanDTO();
        vanDTO.setId(vehicle.getId());
        vanDTO.setBrand(vehicle.getBrand());
        vanDTO.setModel(vehicle.getModel());
        vanDTO.setColour(vehicle.getColour());
        vanDTO.setCubiCapacity(vehicle.getCubiCapacity());
        vanDTO.sethP(vehicle.getHP());
        vanDTO.setkW(vehicle.getKW());
        vanDTO.setTransmissionType(vehicle.getTransmissionType());
        vanDTO.setRegistrationYear(vehicle.getRegistrationYear());
        vanDTO.setFuelType(vehicle.getFuelType());
        vanDTO.setPrice(vehicle.getPrice());
        vanDTO.setNewVehicle(vehicle.getNewVehicle());
        vanDTO.setMileage(vehicle.getMileage());
        vanDTO.setEmissionType(vehicle.getEmissionType());
        vanDTO.setPassengerNumber(vehicle.getPassengerNumber());
        vanDTO.setTractionType(vehicle.getTractionType());
        vanDTO.setOptionFullTraction(vehicle.getOptionFullTraction());
        vanDTO.setDoors(vehicle.getDoors());
        vanDTO.setCentralizedClosing(vehicle.getCentralizedClosing());
        vanDTO.setAirConditioning(vehicle.getAirConditioning());
        vanDTO.setBluetooth(vehicle.getBluetooth());
        vanDTO.setSatNav(vehicle.getSatNav());
        vanDTO.setElectricRoof(vehicle.getElectricRoof());
        vanDTO.setParkAssist(vehicle.getParkAssist());
        vanDTO.setSpareTire(vehicle.getSpareTire());
        vanDTO.setAntiTheft(vehicle.getAntiTheft());
        vanDTO.setPassengerTransport(vehicle.getPassengerTransport());
        vanDTO.setWindowedBackDoor(vehicle.getWindowedBackDoor());
        vanDTO.setSlideSideDoor(vehicle.getSlideSideDoor());
        vanDTO.setAntiCollisionSystem(vehicle.getAntiCollisionSystem());
        vanDTO.setStatusType(vehicle.getStatusType());
        vanDTO.setCurrentLocation(vehicle.getCurrentLocation());
        vanDTO.setAvailableRental(vehicle.getAvailableRental());
        return vanDTO;
    }

}
