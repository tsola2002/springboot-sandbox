package com.tsola2002.order.controller;

import com.tsola2002.order.model.Order;
import com.tsola2002.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/customer/{customerId}")
    public Object getOrdersByCustomer(@PathVariable int customerId) {
        Order order = service.getOrdersForCustomer(customerId);
        return order != null ? order : new Object[0];
    }
}
