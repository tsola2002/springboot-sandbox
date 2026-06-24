package com.tsola2002.customerservice.controller;

import com.tsola2002.customerservice.dto.FraudResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {

    private final RestTemplate restTemplate;

    public CustomerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{customerId}")
    public String checkCustomer(@PathVariable String customerId) {

        log.info("Customer request received: {}", customerId);

        String url = "http://localhost:8081/api/fraud/" + customerId;

        FraudResponse response = restTemplate.getForObject(url, FraudResponse.class);

        log.info("Fraud service response received: {}", response);

        return response.isFraudulent()
                ? "Customer is FRAUDULENT"
                : "Customer is CLEAN";
    }
}
