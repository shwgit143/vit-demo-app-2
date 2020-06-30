package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public String save(Employee emp)
	{
		employeeRepository.save(emp);
		
		return "Saved";
	}
	public List<Employee> findAll()
	{
		return employeeRepository.findAll();
	}
	public Employee findByempId(String empId)
	{
		return employeeRepository.findByEmpId(empId);
	}

}
