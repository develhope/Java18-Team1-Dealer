package com.develhope.spring.User.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Customer extends User{
    @Column(nullable = false)
    private Integer phone;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Integer creditCard;
    @Column(nullable = false)
    private String taxId;

    public Customer(Long id, String firstName, String lastName, String email, String password, Integer phone, String address, Integer creditCard, String taxId) {
        super(id, firstName, lastName, email, password);
        this.phone = phone;
        this.address = address;
        this.creditCard = creditCard;
        this.taxId = taxId;
    }

    public Customer() {
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Integer creditCard) {
        this.creditCard = creditCard;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phone=" + phone +
                ", address='" + address + '\'' +
                ", creditCard=" + creditCard +
                ", taxId='" + taxId + '\'' +
                '}';
    }
}
