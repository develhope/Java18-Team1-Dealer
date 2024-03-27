package com.develhope.spring.User.DTO;

import com.develhope.spring.User.Enum.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private UserTypeEnum role;
    private String phone;
    private String address;
    private String creditCard;
    private String taxId;
}
