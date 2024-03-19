package com.develhope.spring.Vehicle.Repositories;

import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query(value = "SELECT * FROM VEHICLE WHERE status_type_enum LIKE :status", nativeQuery = true)
    List<Vehicle> vehiclesByStatusType(String status);
}
