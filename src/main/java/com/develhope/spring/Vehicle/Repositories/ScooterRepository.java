package com.develhope.spring.Vehicle.Repositories;

import com.develhope.spring.Vehicle.Entities.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long> {
}
