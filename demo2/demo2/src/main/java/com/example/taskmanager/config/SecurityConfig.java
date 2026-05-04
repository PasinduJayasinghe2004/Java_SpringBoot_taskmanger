package com.example.taskmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.beans.Customizer;


@Configuration
public class SecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/tasks/**").authenticated()
                                .anyRequest().permitAll()
                )
                .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
