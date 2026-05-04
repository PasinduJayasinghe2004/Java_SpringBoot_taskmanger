package com.example.taskmanager.Controller;

import com.example.taskmanager.dto.AuthResponse;
import com.example.taskmanager.dto.LoginRequest;
import com.example.taskmanager.model.User;
import com.example.taskmanager.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return service.register(user);
    }
    @PostMapping("/login")
    public AuthResponse login (@RequestBody LoginRequest request){
        return service.login(request);
    }
}
