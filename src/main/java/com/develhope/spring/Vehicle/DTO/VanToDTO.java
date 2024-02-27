package com.develhope.spring.Vehicle.DTO;

import com.develhope.spring.Vehicle.Entities.Van;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class VanToDTO {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Van van;
    public Van vanToDto(Van van){
        return modelMapper.map(van, Van.class);
    }
}
