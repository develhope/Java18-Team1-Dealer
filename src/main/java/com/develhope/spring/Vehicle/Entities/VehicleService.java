package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.Entities.Enums.VehiclesType;
import com.develhope.spring.Vehicle.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public Motorbike createVehicle(Motorbike motorbike){
        if(motorbike.getVehiclesType().equals(VehiclesType.MOTORBIKE)){
            return vehicleRepository.save(motorbike);
        }else{ throw new IllegalArgumentException("Veicolo non inserito correttamente");
        }
    }

    public Scooter createVehicle(Scooter scooter){
        if(scooter.getVehiclesType().equals(VehiclesType.SCOOTER)){
            return vehicleRepository.save(scooter);
        }else{ throw new IllegalArgumentException("Veicolo non inserito correttamente");
        }
    }

//    public Vehicle createVehicle(VehiclesType vehiclesType, Vehicle vehicle){
//        if(vehiclesType.equals(VehiclesType.SCOOTER)){
//            Scooter scooter = new Scooter();
//            scooter.setId(vehicle.getId());
//            return vehicleRepository.save(scooter);
//        }else if(vehiclesType.equals(VehiclesType.MOTORBIKE)){
//            Motorbike motorbike = new Motorbike();
//            return vehicleRepository.save(motorbike);
//        } else if (vehiclesType.equals(VehiclesType.CAR)) {
//            Car car = new Car();
//            return vehicleRepository.save(car);
//        } else if (vehiclesType.equals(VehiclesType.VAN)) {
//            Van van = new Van();
//            return vehicleRepository.save(van);
//        }else{ throw new IllegalArgumentException("Veicolo inserito non presente: " + vehiclesType);
//        }
//    }

}
