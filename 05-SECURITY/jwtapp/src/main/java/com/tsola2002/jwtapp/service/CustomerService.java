package com.tsola2002.jwtapp.service;

import com.tsola2002.jwtapp.entity.Customer;
import com.tsola2002.jwtapp.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> getAllCustomers(){
      return customerRepository.findAll();
 }

  public Customer getCustomerById(Long id){
       return customerRepository.findById(id)
           .orElseThrow(() -> new RuntimeException("Customer Not Found"));
  }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer){
        Customer existingCustomer = getCustomerById(id);

        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setAddress(updatedCustomer.getAddress());

        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }



}
