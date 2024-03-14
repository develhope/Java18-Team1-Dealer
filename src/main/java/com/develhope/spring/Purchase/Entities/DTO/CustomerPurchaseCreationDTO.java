package com.develhope.spring.Purchase.Entities.DTO;

import com.develhope.spring.User.Entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPurchaseCreationDTO {
    private Long idVehicle;
    private Customer customer;
}
