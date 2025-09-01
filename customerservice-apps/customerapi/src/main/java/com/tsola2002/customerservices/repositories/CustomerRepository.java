package com.tsola2002.customerservices.repositories;

import com.tsola2002.customerservices.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
