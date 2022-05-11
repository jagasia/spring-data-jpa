package com.cts.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.hrms.entity.Student;
import com.cts.hrms.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService ss;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/show")
	public String showStudentPage()
	{
		return "student";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/submit", params = "add")
	public String addStudent(Student student)
	{
		ss.create(student);
		return "student";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/submit", params = "update")
	public String updateStudent(Student student)
	{
		ss.update(student);
		return "student";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/submit", params = "delete")
	public String deleteStudent(Student student)
	{
		ss.delete(student.getId());
		return "student";
	}
}
