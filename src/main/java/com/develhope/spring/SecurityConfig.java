package com.develhope.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authz) -> authz
                        .requestMatchers("/motorworld/admin/**").hasRole("ADMIN")
                        .requestMatchers("/motorworld/salesman/**").hasRole("SALESMAN")
                        .requestMatchers("/motorworld/customer/**").hasRole("CUSTOMER")
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .logout(withDefaults());

        return http.build();
    }
    @Autowired
    private DataSource dataSource;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT first_name, password, true FROM users WHERE first_name=?")
                .authoritiesByUsernameQuery("SELECT first_name, CONCAT('ROLE_', role) FROM users WHERE first_name=?")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    //TODO: non funziona con 3 tabelle la query
}
