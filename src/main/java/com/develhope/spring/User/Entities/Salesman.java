package com.develhope.spring.User.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Salesman extends User{
    @Column(nullable = false)
    private Integer phone;
    @Column(nullable = false)
    private  String address;
    @Column(nullable = false)
    private Integer salesNumber;

    public Salesman(Long id, String firstName, String lastName, String email, String password, Integer phone, String address, Integer salesNumber) {
        super(id, firstName, lastName, email, password);
        this.phone = phone;
        this.address = address;
        this.salesNumber = salesNumber;
    }

    public Salesman() {
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

    public Integer getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(Integer salesNumber) {
        this.salesNumber = salesNumber;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "phone=" + phone +
                ", address='" + address + '\'' +
                ", salesNumber=" + salesNumber +
                '}';
    }
}
