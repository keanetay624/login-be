package com.keane.login.controller;

import com.keane.login.dto.AuthRequest;
import com.keane.login.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    private JwtService jwtService;

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        return jwtService.generateToken(authRequest.getUsername());
    }
}
