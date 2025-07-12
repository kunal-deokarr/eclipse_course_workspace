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

/**
 * 
 */
/**
 * @param stu
 * @return
 */
/**
 * 
 */
/**
 * 
 */
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
	
	/*
	 * this getCsrfToken method is used to hit this "/post" api or "postStudent()" method from postman
	 * in postman, before hitting the /post api by POST request, we will have to hit this /csrftoken api
	 * by which it will provide us a token and header name, we will have to copy it and then at the time of hitting the 
	 *  /post api in postman, in header section we'll need to paste this token in value column with header name
	 *  ie X-CSRF-TOKEN in key column. After following this procedure only we'll be able to hit /post api, 
	 *  without it we'll not be able to hit /post api.
	*/
	
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
