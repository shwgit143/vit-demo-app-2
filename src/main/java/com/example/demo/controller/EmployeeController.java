package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	 @ResponseBody
	@GetMapping(value="/save")
	public String save(@ModelAttribute("empid") String empid,@ModelAttribute("empname") String empname,@ModelAttribute("empemail") String empemail,@ModelAttribute("emplocation") String emplocation)
	{
		System.out.println(empid);
		System.out.println(empname);
		System.out.println(empemail);
		System.out.println(emplocation);
		
		return employeeService.save(new Employee(empid,empname,empemail,emplocation));
	}
	@ResponseBody
	@RequestMapping(path="/displayAll")
	public List<Employee> showAll() {
	    return employeeService.findAll();
	}
	@ResponseBody
	@RequestMapping("/display/{empId}")
	public Employee showEmployee(@PathVariable String empId)
	{
		return employeeService.findByempId(empId);
	}
}
