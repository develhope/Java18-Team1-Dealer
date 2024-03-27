package com.develhope.spring.Purchase.Entities;

import com.develhope.spring.Purchase.Entities.Enums.OrderStatusEnum;
import com.develhope.spring.Purchase.Entities.Enums.VehicleStatusEnum;
import com.develhope.spring.ShowroomProfit.ShowroomProfit;
import com.develhope.spring.User.Entities.Users;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private BigDecimal advancePayment;

    @Column(nullable = false)
    private Boolean isPaid;

    @Column
    private OrderStatusEnum orderStatusEnum;
    @Column(nullable = false)
    private VehicleStatusEnum vehicleStatusEnum;

    @ManyToOne
    @JoinColumn(name = "salesman_id")
    private Users salesman;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Users customer;

    @OneToOne
    private Vehicle vehicle;
    @OneToOne
    private ShowroomProfit showroomProfit;
}
