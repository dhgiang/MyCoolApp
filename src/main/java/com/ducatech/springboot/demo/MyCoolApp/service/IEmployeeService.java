package com.ducatech.springboot.demo.MyCoolApp.service;

import com.ducatech.springboot.demo.MyCoolApp.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
