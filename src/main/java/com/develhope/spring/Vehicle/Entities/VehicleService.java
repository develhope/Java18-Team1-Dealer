package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.DTO.CarDTO;
import com.develhope.spring.Vehicle.DTO.MotorBikeDTO;
import com.develhope.spring.Vehicle.DTO.ScooterDTO;
import com.develhope.spring.Vehicle.DTO.VanDTO;
import com.develhope.spring.Vehicle.Entities.Enums.VehiclesTypeEnum;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    //NB scooter e moto SOLO elettrici o benzina
    public List<Object> allVehiclesDTO(List<Vehicle> vehicles) throws Exception{
        List<Object> vehiclesDTO = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            if(vehicle.getVehiclesTypeEnum().equals(VehiclesTypeEnum.SCOOTER)){
                vehiclesDTO.add(getScooterDTO(vehicle));
            } else if (vehicle.getVehiclesTypeEnum().equals(VehiclesTypeEnum.MOTORBIKE)) {
                vehiclesDTO.add(getMotorBikeDTO(vehicle));
            } else if (vehicle.getVehiclesTypeEnum().equals(VehiclesTypeEnum.CAR)) {
                vehiclesDTO.add(getCarDTO(vehicle));
            } else if (vehicle.getVehiclesTypeEnum().equals(VehiclesTypeEnum.VAN)) {
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
        scooterDTO.setHP(vehicle.getHP());
        scooterDTO.setKW(vehicle.getKW());
        scooterDTO.setRegistrationYear(vehicle.getRegistrationYear());
        scooterDTO.setFuelTypeEnum(vehicle.getFuelTypeEnum());
        scooterDTO.setPrice(vehicle.getPrice());
        scooterDTO.setNewVehicle(vehicle.getNewVehicle());
        scooterDTO.setMileage(vehicle.getMileage());
        scooterDTO.setStatusTypeEnum(vehicle.getStatusTypeEnum());
        scooterDTO.setCurrentLocation(vehicle.getCurrentLocation());
        scooterDTO.setEmissionTypeEnum(vehicle.getEmissionTypeEnum());
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
        motorBikeDTO.setHP(vehicle.getHP());
        motorBikeDTO.setKW(vehicle.getKW());
        motorBikeDTO.setTransmissionTypeEnum(vehicle.getTransmissionTypeEnum());
        motorBikeDTO.setRegistrationYear(vehicle.getRegistrationYear());
        motorBikeDTO.setFuelTypeEnum(vehicle.getFuelTypeEnum());
        motorBikeDTO.setPrice(vehicle.getPrice());
        motorBikeDTO.setNewVehicle(vehicle.getNewVehicle());
        motorBikeDTO.setMileage(vehicle.getMileage());
        motorBikeDTO.setStatusTypeEnum(vehicle.getStatusTypeEnum());
        motorBikeDTO.setCurrentLocation(vehicle.getCurrentLocation());
        motorBikeDTO.setEmissionTypeEnum(vehicle.getEmissionTypeEnum());
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
        carDTO.setHP(vehicle.getHP());
        carDTO.setKW(vehicle.getKW());
        carDTO.setRegistrationYear(vehicle.getRegistrationYear());
        carDTO.setFuelTypeEnum(vehicle.getFuelTypeEnum());
        carDTO.setPrice(vehicle.getPrice());
        carDTO.setNewVehicle(vehicle.getNewVehicle());
        carDTO.setMileage(vehicle.getMileage());
        carDTO.setEmissionTypeEnum(vehicle.getEmissionTypeEnum());
        carDTO.setPassengerNumber(vehicle.getPassengerNumber());
        carDTO.setTransmissionTypeEnum(vehicle.getTransmissionTypeEnum());
        carDTO.setStatusTypeEnum(vehicle.getStatusTypeEnum());
        carDTO.setCarTypeEnum(vehicle.getCarTypeEnum());
        carDTO.setTractionTypeEnum(vehicle.getTractionTypeEnum());
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
        vanDTO.setHP(vehicle.getHP());
        vanDTO.setKW(vehicle.getKW());
        vanDTO.setTransmissionTypeEnum(vehicle.getTransmissionTypeEnum());
        vanDTO.setRegistrationYear(vehicle.getRegistrationYear());
        vanDTO.setFuelTypeEnum(vehicle.getFuelTypeEnum());
        vanDTO.setPrice(vehicle.getPrice());
        vanDTO.setNewVehicle(vehicle.getNewVehicle());
        vanDTO.setMileage(vehicle.getMileage());
        vanDTO.setEmissionTypeEnum(vehicle.getEmissionTypeEnum());
        vanDTO.setPassengerNumber(vehicle.getPassengerNumber());
        vanDTO.setTractionTypeEnum(vehicle.getTractionTypeEnum());
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
        vanDTO.setStatusTypeEnum(vehicle.getStatusTypeEnum());
        vanDTO.setCurrentLocation(vehicle.getCurrentLocation());
        vanDTO.setAvailableRental(vehicle.getAvailableRental());
        return vanDTO;
    }
}
