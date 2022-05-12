package com.cts.hrms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hrms.entity.Student;
import com.cts.hrms.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository sr;
	
	public Student create(Student student) {
		return sr.save(student);
	}
	public List<Student> read() {
		return sr.findAll();
	}
	public Student read(Integer id) {
		Optional<Student> x = sr.findById(id);
		Student s=null;
		if(x.isPresent())
		{
			s=x.get();
		}
		return s;
	}
	public Student update(Student student) {
		Optional<Student> x = sr.findById(student.getId());
		Student s=null;
		if(x.isPresent())
		{
			s=student;
			sr.save(student);
		}
		return s;
	}
	public Student delete(Integer id) {
		Optional<Student> x = sr.findById(id);
		Student s=null;
		if(x.isPresent())
		{
			s=x.get();
			sr.delete(s);
		}
		return s;
	}
	
	public List<Student> findByLN(String lastName)
	{
		return sr.findStudentsByLastName(lastName);
	}
	
}
