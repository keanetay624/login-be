package com.keane.login.controller;

import com.keane.login.dto.JwtResponse;
import com.keane.login.dto.AuthRequest;
import com.keane.login.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class SecurityController {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public JwtResponse authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        return new JwtResponse.JwtResponseBuilder(HttpStatus.OK)
                .setAccToken(jwtService.generateToken(authRequest.getUsername()))
                .build();
    }
}
