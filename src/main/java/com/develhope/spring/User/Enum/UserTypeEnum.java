package com.develhope.spring.User.Enum;

public enum UserTypeEnum {

    ADMIN,

    SALESMAN,

    CUSTOMER,
    NOT_SET;

    public static UserTypeEnum convertStringToRole(String role) {
        return switch (role.toLowerCase()) {
            case "admin" -> UserTypeEnum.ADMIN;
            case "salesman" -> UserTypeEnum.SALESMAN;
            case "customer" -> UserTypeEnum.CUSTOMER;
            default -> UserTypeEnum.NOT_SET;
        };
    }

}
