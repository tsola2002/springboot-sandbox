package com.tsola2002.demo.Controller;

import com.tsola2002.demo.Entity.Customer;
import com.tsola2002.demo.Service.CustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  // GET ALL CUSTOMERS
  @GetMapping
  public List<Customer> getAllCustomers(){

    return customerService.getAllCustomers();
  }

  // READ BY ID
  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable Integer id){
    return customerService.getCustomerById(id);
  }

  // CREATE CUSTOMER
  @PostMapping
  public Customer createCustomer(@RequestBody Customer customer){
    return customerService.createCustomer(customer);
  }

  // UPDATE CUSTOMER
  @PutMapping("/{id}")
  public Customer updateCustomer(@PathVariable Integer id,
      @RequestBody Customer customer){
    return customerService.updateCustomer(id, customer);
  }

  // DELETE A CUSTOMER
  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Integer id){
    customerService.deleteCustomer(id);
  }


}
