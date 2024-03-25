package com.develhope.spring.Vehicle.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleMostSoldDTO {
    private String brand;
    private String model;
    private Long quantity;
}
