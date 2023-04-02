package com.springbootindividual.employeemanagementproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootindividual.employeemanagementproject.model.Employee;
import com.springbootindividual.employeemanagementproject.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) 
		{
		super();
		this.employeeService = employeeService;
		}

	@GetMapping("/")
	public String viewTheHomePage(Model model) 
		{
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "employee";
		}

	@GetMapping("/employees/new")
	public String ShowNewEmployeeform(Model model) 
		{
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
		}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) 
		{
		employeeService.saveEmployee(employee);
		return "redirect:/";
		}

	@GetMapping("/employees/edit/{id}")
	public String editEmployeeform(@PathVariable long id, Model model) 
		{
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
		}

	@PostMapping("/employees/{id}")
	public String showEmployeeUpdate(@PathVariable long id, @ModelAttribute("employee") Employee employee,
			Model model) 
		{
		Employee existingemployee = employeeService.getEmployeeById(id);
		existingemployee.setFirstName(employee.getFirstName());
		existingemployee.setLastName(employee.getLastName());
		existingemployee.setEmail(employee.getEmail());
		// save employee object
		employeeService.showEmployeeUpdate(existingemployee);
		return "redirect:/";
		}

	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) 
		{
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
		}
}
