package com.ducatech.springboot.demo.MyCoolApp.repository;

import com.ducatech.springboot.demo.MyCoolApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {}
