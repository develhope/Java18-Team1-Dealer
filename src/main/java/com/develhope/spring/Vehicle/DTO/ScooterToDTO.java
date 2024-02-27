package com.develhope.spring.Vehicle.DTO;

import com.develhope.spring.Vehicle.Entities.Scooter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ScooterToDTO {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Scooter scooter;
    public Scooter scooterToDto(Scooter scooter){
        return modelMapper.map(scooter, Scooter.class);
    }
}
