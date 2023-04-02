package com.springbootindividual.employeemanagementproject.service;

import java.util.List;

import com.springbootindividual.employeemanagementproject.model.Employee;

public interface EmployeeService 
{
	List<Employee> getAllEmployee();

	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);

	void showEmployeeUpdate(Employee employee);

	void deleteEmployeeById(long id);
}
