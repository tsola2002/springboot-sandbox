package com.tsola2002.jwtapp.controller;

import com.tsola2002.jwtapp.dto.LoginRequest;
import com.tsola2002.jwtapp.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request){
        if(request.getUsername().equals("admin") &&
           request.getPassword().equals("password")){
            String token = jwtService.generateToken(request.getUsername());
            return  Map.of("token", token);
        }

        throw  new RuntimeException("Invalid Credentials");
    }
}
