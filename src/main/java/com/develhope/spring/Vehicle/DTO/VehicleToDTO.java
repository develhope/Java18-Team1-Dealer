package com.develhope.spring.Vehicle.DTO;

import com.develhope.spring.Vehicle.Entities.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleToDTO {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Vehicle vehicle;
    public Vehicle vehicle(Vehicle vehicle){
        return modelMapper.map(vehicle, Vehicle.class);
    }
}
