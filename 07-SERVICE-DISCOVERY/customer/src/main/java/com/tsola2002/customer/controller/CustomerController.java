package com.tsola2002.customer.controller;

import com.tsola2002.customer.model.Customer;
import com.tsola2002.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private final CustomerService service;

    @Value("${order.service.url:http://localhost:8081}")
    private String orderServiceUrl;


    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}/orders") public Object getCustomerOrders(
            @PathVariable int id) {
        return service.getCustomerOrders(id, orderServiceUrl);
    }
}
