package com.develhope.spring.Authentication;

import com.develhope.spring.Authentication.dto.request.RefreshTokenRequest;
import com.develhope.spring.Authentication.dto.request.SignUpRequest;
import com.develhope.spring.Authentication.dto.request.SigninRequest;
import com.develhope.spring.Authentication.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest request);
}
