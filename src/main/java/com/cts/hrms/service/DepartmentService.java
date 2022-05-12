package com.cts.hrms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hrms.entity.Department;
import com.cts.hrms.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository dr;

	public Department create(Department department) {		
		return dr.save(department);
	}
	public List<Department> read() {
		return dr.findAll();
	}
	public Department read(Integer id) {
		Optional<Department> x = dr.findById(id);
		Department d=null;
		if(x.isPresent())
		{
			d=x.get();
		}
		return d;
	}
	public Department update(Department department) {
		Optional<Department> x = dr.findById(department.getId());
		Department d=null;
		if(x.isPresent())
		{
			d=department;
			dr.save(department);
		}
		return d;
	}
	public Department delete(Integer id) {
		Optional<Department> x = dr.findById(id);
		Department d=null;
		if(x.isPresent())
		{
			d=x.get();
			dr.delete(d);
		}
		return d;
	}
	
}
