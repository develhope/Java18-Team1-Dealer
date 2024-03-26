package com.develhope.spring.User.Repositories;

import com.develhope.spring.User.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT * FROM users WHERE role = 'SALESMAN'", nativeQuery = true)
    List<Users> findAllSalesman();

    @Query(value = "SELECT * FROM users WHERE role = 'CUSTOMER'", nativeQuery = true)
    List<Users> findAllCustomer();

}
