package com.develhope.spring.Vehicle.Repositories;

import com.develhope.spring.Vehicle.Entities.Van;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VanRepository extends JpaRepository<Van, Long> {
}
