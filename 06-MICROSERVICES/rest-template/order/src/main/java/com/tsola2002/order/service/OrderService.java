package com.tsola2002.order.service;

import com.tsola2002.order.entity.Order;
import com.tsola2002.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Map<String, Object> createOrder(Order order){
        // customer microservice url
        String url = "http://localhost:8080/customers/" + order.getCustomerId();

        //make a call to customer microservice
        //Customer customer = restTemplate.getForObject(url, Customer.class);

        Order savedOrder = orderRepository.save(order);

        // combine response
        Map<String, Object> response = new HashMap<>();
        response.put("order", savedOrder);
        //response.put("customer", customer);
        return response;
    }
}
