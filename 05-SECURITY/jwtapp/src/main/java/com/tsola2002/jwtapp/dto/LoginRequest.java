package com.tsola2002.jwtapp.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}
