package com.develhope.spring.User.Repositories;

import com.develhope.spring.User.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE role = 'SALESMAN'", nativeQuery = true)
    List<Users> findAllSalesman();

    @Query(value = "SELECT * FROM users WHERE role = 'CUSTOMER'", nativeQuery = true)
    List<Users> findAllCustomer();

}
