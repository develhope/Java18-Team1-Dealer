package com.develhope.spring.User.DTO;

import com.develhope.spring.User.Entities.Salesman;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalesmanDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String email;
    private Integer salesNumber;

}
