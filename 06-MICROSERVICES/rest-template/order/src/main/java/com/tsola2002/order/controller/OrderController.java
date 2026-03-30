package com.tsola2002.order.controller;

import com.tsola2002.order.entity.Order;
import com.tsola2002.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Map<String, Object> createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }
}
