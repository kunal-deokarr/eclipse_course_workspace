package com.emp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.main.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
