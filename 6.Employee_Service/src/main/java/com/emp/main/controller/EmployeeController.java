package com.emp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.main.dto.ApiResponseDto;
import com.emp.main.dto.EmployeeDto;
import com.emp.main.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto empDto)
	{
		
		EmployeeDto dto = service.saveEmployee(empDto);
		
		return new ResponseEntity<EmployeeDto>(dto, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ApiResponseDto> getEmpById(@PathVariable Long empId)
	{
		ApiResponseDto dto = service.getEmployeeById(empId);
		return new ResponseEntity<ApiResponseDto>(dto, HttpStatus.OK);
	}

}
