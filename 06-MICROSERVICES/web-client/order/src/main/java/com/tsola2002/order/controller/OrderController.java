package com.tsola2002.order.controller;

import com.tsola2002.order.dto.Customer;
import com.tsola2002.order.entity.Order;
import com.tsola2002.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //CREATE CUSTOMER
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){

        return orderService.createCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public String updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        orderService.updateCustomer(id, customer);
        return "Customer updated Successfully";
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id){
        orderService.deleteCustomer(id);
        return "Customer Successfully Deleted";
    }


}
