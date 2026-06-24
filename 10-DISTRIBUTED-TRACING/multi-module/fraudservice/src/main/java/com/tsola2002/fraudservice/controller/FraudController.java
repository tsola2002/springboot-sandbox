package com.tsola2002.fraudservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsola2002.fraudservice.dto.FraudResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/fraud")
@Slf4j
public class FraudController {

    @GetMapping("/{customerId}")
    public FraudResponse checkFraud(@PathVariable("customerId") String customerId) {

        log.info("Fraud check started for customerId={}", customerId);

        boolean isFraudulent = customerId.startsWith("9");

        FraudResponse response = new FraudResponse(customerId, isFraudulent);

        log.info("Fraud check completed for customerId={}, result={}",
                customerId, isFraudulent);

        return response;
        
    }

}
