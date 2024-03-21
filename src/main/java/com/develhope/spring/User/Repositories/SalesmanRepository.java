package com.develhope.spring.User.Repositories;

import com.develhope.spring.User.Entities.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalesmanRepository extends JpaRepository<Salesman,Long> {
}
