package com.develhope.spring.Authentication;

import com.develhope.spring.Authentication.entities.RefreshToken;
import com.develhope.spring.User.Entities.Users;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    RefreshToken generateRefreshToken(Users user);

    boolean isRefreshTokenExpired(RefreshToken token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
