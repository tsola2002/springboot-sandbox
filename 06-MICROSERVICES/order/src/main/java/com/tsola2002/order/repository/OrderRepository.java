package com.tsola2002.order.repository;

import com.tsola2002.order.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepository {

    private final List<Order> orders = Arrays.asList(
            new Order(1, Arrays.asList("Apples", "Bananas")),
            new Order(2, Arrays.asList("Water"))
    );

    public Order findByCustomerId(int customerId) {
        return orders.stream()
                     .filter(o -> o.getCustomerId() == customerId)
                     .findFirst()
                     .orElse(null);
    }

}
