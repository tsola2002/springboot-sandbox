package com.tsola2002.customer.controller;

import com.tsola2002.customer.model.Customer;
import com.tsola2002.customer.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("api/customers")
    public List<Customer> getCustomer(){
        return customerService.getAllCustomer();
    }
}
