package com.develhope.spring.Authentication;

import com.develhope.spring.Authentication.dto.request.RefreshTokenRequest;
import com.develhope.spring.Authentication.dto.request.SignUpRequest;
import com.develhope.spring.Authentication.dto.request.SigninRequest;
import com.develhope.spring.Authentication.dto.response.JwtAuthenticationResponse;
import com.develhope.spring.Authentication.entities.RefreshToken;
import com.develhope.spring.Authentication.repositories.RefreshTokenRepository;
import com.develhope.spring.User.Entities.Users;
import com.develhope.spring.User.Enum.UserTypeEnum;
import com.develhope.spring.User.Repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final UsersRepository userRepository;
    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        Users user = Users.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserTypeEnum.convertStringToRole(request.getRole()))
                .phone(request.getPhone())
                .address(request.getAddress())
                .creditCard(request.getCreditCard())
                .taxId(request.getTaxId()).build();

        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        RefreshToken refreshToken = jwtService.generateRefreshToken(user);
        return JwtAuthenticationResponse.builder().authToken(jwt).refreshToken(refreshToken.getToken()).build();
    }


    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        //TODO Instead of only throw IllegalArgumentException maybe we could handle an error on the controller side
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        var jwt = jwtService.generateToken(user);
        RefreshToken refreshToken = jwtService.generateRefreshToken(user);
        return JwtAuthenticationResponse.builder().authToken(jwt).refreshToken(refreshToken.getToken()).build();
    }

    @Override
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest request) {
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByToken(request.getRefreshToken());

        if (refreshToken.isPresent() && !jwtService.isRefreshTokenExpired(refreshToken.get())) {
            //TODO Instead of only throw IllegalArgumentException maybe we could handle an error on the controller side
            var user = userRepository.findByEmail(refreshToken.get().getUserInfo().getEmail())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

            var jwt = jwtService.generateToken(user);

            return JwtAuthenticationResponse.builder().authToken(jwt).refreshToken(refreshToken.get().getToken()).build();
        } else {
            //TODO Manage errors, for now we return an empty response
            return JwtAuthenticationResponse.builder().build();
        }
    }
}
