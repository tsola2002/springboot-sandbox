package com.tsola2002.fraud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud")
public class FraudController {

    @GetMapping("/{customerId}")
    public boolean isFraudster(
            @PathVariable Integer customerId) {
        return false;
    }
}
