package com.dep.main.service;

import java.util.List;

import com.dep.main.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto saveDepartment(DepartmentDto deptDto);
	
	DepartmentDto getDepartmentByCode(String deptCode);
	
	DepartmentDto getDepartmentById(Long deptId);

}
