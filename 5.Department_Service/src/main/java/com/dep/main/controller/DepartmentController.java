package com.dep.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dep.main.dto.DepartmentDto;
import com.dep.main.service.DepartmentService;

@RestController
@RequestMapping("api/dept")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$	
	
	// save department REST API
	
	@PostMapping("/save")
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto deptDto)
	{
		DepartmentDto dto = departmentService.saveDepartment(deptDto);
		
		return new ResponseEntity<DepartmentDto>(dto, HttpStatus.CREATED);
	}
	
// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$		
	
	// get Department by department code REST API
	
	@GetMapping("/code/{deptCode}")
	public ResponseEntity<DepartmentDto> getDepartmentByDeptCode(@PathVariable("deptCode") String deptCode)
	{
		DepartmentDto deptDto = departmentService.getDepartmentByCode(deptCode);
		
		return new ResponseEntity<DepartmentDto>(deptDto, HttpStatus.OK);
	}
	

// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$		

	
	@GetMapping("/{deptId}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long deptId)
	{
		DepartmentDto dto = departmentService.getDepartmentById(deptId);
		return new ResponseEntity<DepartmentDto>(dto,HttpStatus.OK);
	}
	
	
}
