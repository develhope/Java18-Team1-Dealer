package com.develhope.spring.Vehicle.Entities;

import com.develhope.spring.Vehicle.Entities.Enums.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Motorbike extends Vehicle{
    @Column(nullable = false)
    private MotorbikeType motorbikeType;
    @Column(nullable = false)
    private TransmissionType transmissionType;
    @Column(nullable = false)
    private Boolean windShield;
    @Column(nullable = false)
    private Boolean tailBag;
    @Column(nullable = false)
    private Boolean passengerBackrest;


}
