package com.develhope.spring.Vehicle.DTO;

import com.develhope.spring.Vehicle.Entities.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CartToDTO {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Car car;
    public Car carToDto(Car car){
        return modelMapper.map(car, Car.class);
    }
}
