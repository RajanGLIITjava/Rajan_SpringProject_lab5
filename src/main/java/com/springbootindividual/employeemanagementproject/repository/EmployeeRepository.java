package com.springbootindividual.employeemanagementproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootindividual.employeemanagementproject.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
