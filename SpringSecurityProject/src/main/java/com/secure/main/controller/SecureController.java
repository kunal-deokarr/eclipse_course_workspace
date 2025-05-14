package com.secure.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secure.main.entity.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecureController {

	
	private List<Student> sList = Arrays.asList(
			new Student(1,"sunay"),
			new Student(2,"Puja")
			);
	
	@GetMapping("/get")
	public List<Student> secureMethod()
	{
		return sList;
	}
	
	@GetMapping("/csfrtoken")
	public CsrfToken getCsrfToken(HttpServletRequest request)
	{
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PostMapping("/post")
	public Student postStudent(@RequestBody Student stu)
	{
//		sList.add(stu);
		System.out.println("method hit");
		System.out.println(stu.getClass().getName());
		return stu;
	}
	
}
