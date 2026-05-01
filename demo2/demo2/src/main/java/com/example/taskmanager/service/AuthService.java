package com.example.taskmanager.service;

import com.example.taskmanager.config.JwtUtil;
import com.example.taskmanager.dto.AuthResponse;
import com.example.taskmanager.dto.LoginRequest;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private JwtUtil jwtUtil;

    public String register(User user){
        repository.save(user);
        return "User registered successfully";
    }
    public AuthResponse login(LoginRequest request){
        User user=repository.findByUserName(request.getUserName())
                .orElseThrow(()->new RuntimeException("UserNotFound"));

        if(!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

            String token=jwtUtil.generateToken(user.getUsername());
            return new AuthResponse(token);
        }


}
