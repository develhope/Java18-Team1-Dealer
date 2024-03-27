package com.develhope.spring.Rent.Repositories;

import com.develhope.spring.Rent.Entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent,Long> {
    @Query(value = "SELECT * FROM RENT WHERE ID= :id", nativeQuery = true)
    List<Rent> rentList(@Param("id")Long id);
}
