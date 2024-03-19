package com.develhope.spring.Vehicle.Repositories;

import com.develhope.spring.Vehicle.Entities.Enums.StatusTypeEnum;
import com.develhope.spring.Vehicle.Entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
//    @Query(value = "SELECT * FROM vehicle WHERE status_type_enum LIKE :statusTypeEnum", nativeQuery = true)
//    List<Vehicle> vehiclesByStatusType(StatusTypeEnum statusTypeEnum);
}
