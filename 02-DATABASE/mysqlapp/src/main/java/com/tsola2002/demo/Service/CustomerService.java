package com.tsola2002.demo.Service;

import com.tsola2002.demo.Entity.Customer;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.List;

public interface CustomerService {

  Customer createCustomer(Customer customer);

  List<Customer> getAllCustomers();

  Customer updateCustomer(Integer id, Customer customer);

  Customer getCustomerById(Integer id);

  void deleteCustomer(Integer id);

}
