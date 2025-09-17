package com.tsola2002.securityapp.repository;

import com.tsola2002.securityapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
