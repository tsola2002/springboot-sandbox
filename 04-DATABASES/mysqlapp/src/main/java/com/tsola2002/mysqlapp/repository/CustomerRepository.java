package com.tsola2002.mysqlapp.repository;

import com.tsola2002.mysqlapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
