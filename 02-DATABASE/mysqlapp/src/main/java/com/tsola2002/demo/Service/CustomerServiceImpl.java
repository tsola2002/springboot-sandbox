package com.tsola2002.demo.Service;

import com.tsola2002.demo.Entity.Customer;
import com.tsola2002.demo.Repository.CustomerRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;



  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> getAllCustomers(){

    return customerRepository.findAll();
  }

  public Customer createCustomer(Customer customer){

    return customerRepository.save(customer);
  }


  public Customer updateCustomer(Integer id, Customer updatedCustomer){
    Customer existingCustomer = getCustomerById(id);

    existingCustomer.setName(updatedCustomer.getName());
    existingCustomer.setAddress(updatedCustomer.getAddress());
    existingCustomer.setGender(updatedCustomer.getGender());
    return customerRepository.save(existingCustomer);
  }

  @Override
  public Customer getCustomerById(Integer id) {
    return customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer Not Found"));
  }

  @Override
  public void deleteCustomer(Integer id) {

    customerRepository.deleteById(id);
  }
}
