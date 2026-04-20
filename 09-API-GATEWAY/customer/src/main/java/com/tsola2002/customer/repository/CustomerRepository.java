package com.tsola2002.customer.repository;

import com.tsola2002.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository {

    private final List<Customer> customers = Arrays.asList(
            new Customer(1, "James", "UK", "M"),
            new Customer(2, "Jamila", "US", "F"),
            new Customer(3, "Bilal", "ES", "M")
    );

    // THIS WILL DISPLAY ALL CUSTOMERS
    public List<Customer> findAll() {
        return customers;
    }

    public Customer findById(int id) {
        return customers.stream()
                        .filter(c -> c.getId() == id)
                        .findFirst()
                        .orElse(null);
    }

}
