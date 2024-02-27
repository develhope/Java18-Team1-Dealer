package com.develhope.spring.Vehicle.DTO;

import com.develhope.spring.Vehicle.Entities.Motorbike;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MotorbikeDTO {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Motorbike motorbike;
    public Motorbike motorbikeToDto(Motorbike motorbike){
        return modelMapper.map(motorbike, Motorbike.class);
    }
}
