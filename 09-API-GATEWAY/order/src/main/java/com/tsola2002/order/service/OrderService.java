package com.tsola2002.order.service;

import com.tsola2002.order.repository.OrderRepository;
import com.tsola2002.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order getOrdersForCustomer(int customerId) {
        return repository.findByCustomerId(customerId);
    }
}
