package com.develhope.spring.Purchase.Entities.DTO;

import com.develhope.spring.Purchase.Entities.Enums.VehicleStatusEnum;
import com.develhope.spring.User.Entities.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPurchaseCreationDTO {
    private Long idVehicle;
    private Users salesman;
    private Users customer;
    private VehicleStatusEnum vehicleStatus;
}
