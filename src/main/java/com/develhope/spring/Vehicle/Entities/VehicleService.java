package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.Entities.Enums.EmissionType;
import com.develhope.spring.Vehicle.Entities.Enums.FuelType;
import com.develhope.spring.Vehicle.Entities.Enums.StatusType;
import com.develhope.spring.Vehicle.Entities.Enums.VehiclesType;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    public Vehicle createVehicle(VehiclesType vehiclesType, Vehicle vehicle){
        if(vehiclesType.equals(VehiclesType.SCOOTER)){
            Scooter scooter = new Scooter();
            return vehicleRepository.saveAndFlush(scooter);
        }else if(vehiclesType.equals(VehiclesType.MOTORBIKE)){
            Motorbike motorbike = new Motorbike();
            return vehicleRepository.save(motorbike);
        } else if (vehiclesType.equals(VehiclesType.CAR)) {
            Car car = new Car();
            return vehicleRepository.save(car);
        } else if (vehiclesType.equals(VehiclesType.VAN)) {
            Van van = new Van();
            return vehicleRepository.save(van);
        }else{ throw new IllegalArgumentException("Veicolo inserito non presente: " + vehiclesType);
        }
    }

}
