package com.develhope.spring.Purchase.Entities.DTO;

import com.develhope.spring.Purchase.Entities.Enums.VehicleStatusEnum;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Entities.Salesman;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPurchaseCreationDTO {
    private Long idVehicle;
    private Salesman salesman;
    private Customer customer;
    private BigDecimal price;
    private VehicleStatusEnum vehicleStatus;
}
