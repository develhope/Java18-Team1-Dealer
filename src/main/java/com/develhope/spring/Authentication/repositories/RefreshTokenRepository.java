package com.develhope.spring.Authentication.repositories;


import com.develhope.spring.Authentication.entities.RefreshToken;
import com.develhope.spring.User.Entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByToken(String token);
    List<RefreshToken> findByUserInfo(Users user);
}
