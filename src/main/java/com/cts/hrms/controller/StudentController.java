package com.cts.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.hrms.entity.Student;
import com.cts.hrms.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService ss;
	
//	@RequestMapping(method = RequestMethod.GET, value = "/")
	@GetMapping
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/ln/{lastName}")
	@ResponseBody		//this method does not return a view. it returns the content. .ie., response body
	public List<Student> findStudentsByLN(@PathVariable("lastName") String lastName)
	{
		return ss.findByLN(lastName);
	}
}
