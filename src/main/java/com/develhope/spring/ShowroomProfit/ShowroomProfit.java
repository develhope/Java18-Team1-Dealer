package com.develhope.spring.ShowroomProfit;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowroomProfit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ProfitTypeEnum profitTypeEnum;
    private LocalDate payDate;
    private Double profit;

    @OneToOne
    private Rent rent;
    @OneToOne
    private Purchase purchase;
}
