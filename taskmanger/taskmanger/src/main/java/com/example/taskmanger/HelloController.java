package com.example.taskmanger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/name")
    public String name(){
        return "My name is Pasindu";
    }
}
