package com.tsola2002.securityapp.service;

import com.tsola2002.securityapp.entity.Employee;
import com.tsola2002.securityapp.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    // list all employees
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    // get single employee
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).get();
    }

    // insert employee
    public Employee save(Employee employee) {
        return iEmployeeRepository.save(employee);
    }

    public void deleteById(Integer id) {
        iEmployeeRepository.deleteById(id);
    }






}
