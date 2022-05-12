package com.cts.hrms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hrms.entity.Employee;
import com.cts.hrms.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository dr;

	public Employee create(Employee employee) {
		return dr.save(employee);
	}
	public List<Employee> read() {
		return dr.findAll();
	}
	public Employee read(Integer id) {
		Optional<Employee> x = dr.findById(id);
		Employee d=null;
		if(x.isPresent())
		{
			d=x.get();
		}
		return d;
	}
	public Employee update(Employee employee) {
		Optional<Employee> x = dr.findById(employee.getId());
		Employee d=null;
		if(x.isPresent())
		{
			d=employee;
			dr.save(employee);
		}
		return d;
	}
	public Employee delete(Integer id) {
		Optional<Employee> x = dr.findById(id);
		Employee d=null;
		if(x.isPresent())
		{
			d=x.get();
			dr.delete(d);
		}
		return d;
	}
	
}
