package com.cts.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hrms.entity.Employee;
import com.cts.hrms.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService ds;
	
	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return ds.create(employee);
	}
	
	@GetMapping
	public List<Employee> read() {
		return ds.read();
	}
	
	@GetMapping("/{id}")
	public Employee read(@PathVariable("id") Integer id) {
		return ds.read(id);
	}
	
	@PutMapping
	public Employee update(@RequestBody Employee employee) {
		return ds.update(employee);
	}
	
	@DeleteMapping("/{id}")
	public Employee delete(@PathVariable("id") Integer id) {
		return ds.delete(id);
	}
	
}
