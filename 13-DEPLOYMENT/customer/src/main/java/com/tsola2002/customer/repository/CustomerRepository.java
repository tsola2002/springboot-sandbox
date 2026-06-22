package com.tsola2002.customer.repository;

import com.tsola2002.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    public List<Customer> getCustomers(){
        return List.of(
                new Customer(1L, "John Doe", "john@gmail.com"),
                new Customer(2L, "Jane Doe", "jane@gmail.com"),
                new Customer(3L, "Steve Doe", "steve@gmail.com")
        );
    }
}
