package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.Entities.Enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scooter extends Vehicle{
    @Column(nullable = false)
    private Boolean windShield;
    @Column(nullable = false)
    private Boolean tailBag;
    @Column(nullable = false)
    private Boolean passengerBackrest;
    @Column(nullable = false)
    private Boolean heatedGrips;
}
