package com.develhope.spring.Vehicle.Repositories;

import com.develhope.spring.Vehicle.Entities.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorbikeRepository extends JpaRepository<Motorbike, Long> {
}
