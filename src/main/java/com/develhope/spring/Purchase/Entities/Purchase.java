package com.develhope.spring.Purchase.Entities;

import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Entities.Salesman;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private BigDecimal advancePayment;

    @Column(nullable = false)
    private Boolean isPaid;

    @Column(nullable = false)
    private String orderStatus;

    @ManyToOne
    private Salesman salesman;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Vehicle vehicle;

    public Purchase(Long id, BigDecimal advancePayment, Boolean isPaid, String orderStatus, Salesman salesman, Customer customer, Vehicle vehicle) {
        this.id = id;
        this.advancePayment = advancePayment;
        this.isPaid = isPaid;
        this.orderStatus = orderStatus;
        this.salesman = salesman;
        this.customer = customer;
        this.vehicle = vehicle;
    }

    public Purchase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(BigDecimal advancePayment) {
        this.advancePayment = advancePayment;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", advancePayment=" + advancePayment +
                ", isPaid=" + isPaid +
                ", orderStatus='" + orderStatus + '\'' +
                ", salesman=" + salesman +
                ", customer=" + customer +
                ", vehicle=" + vehicle +
                '}';
    }
}
