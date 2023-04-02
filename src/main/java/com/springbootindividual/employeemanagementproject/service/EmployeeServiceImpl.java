package com.springbootindividual.employeemanagementproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootindividual.employeemanagementproject.model.Employee;
import com.springbootindividual.employeemanagementproject.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);

	}
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Passenger detail not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public void showEmployeeUpdate(Employee existingemployee) {
		this.employeeRepository.save(existingemployee);
	}
}
