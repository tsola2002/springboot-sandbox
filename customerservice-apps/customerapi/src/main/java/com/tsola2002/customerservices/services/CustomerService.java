package com.tsola2002.customerservices.services;

import com.tsola2002.customerservices.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    List<Customer> getCustomers();

}
