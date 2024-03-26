package com.develhope.spring.Vehicle.Repositories;

import com.develhope.spring.Vehicle.DTO.VehicleMostSoldDTO;
import com.develhope.spring.Vehicle.Entities.Enums.*;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>, JpaSpecificationExecutor<Vehicle> {
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query(value = "SELECT v.brand, v.model COUNT v.id AS `quantity` FROM vehicle v INNER JOIN showroom_profit s " +
            "WHERE v.status_type_enum = SOLD AND pay_date BETWEEN :paydate1 AND :paydate2" +
            "GROUP BY v.brand, v.model ORDER BY quantity DESC", nativeQuery = true)
    List<VehicleMostSoldDTO> mostPurchasesVehicle(LocalDate paydate1, LocalDate paydate2);
