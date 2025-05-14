package com.emp.main.service;

import com.emp.main.dto.ApiResponseDto;
import com.emp.main.dto.EmployeeDto;

public interface EmployeeService {

	
	EmployeeDto saveEmployee(EmployeeDto empDto);
	
	ApiResponseDto getEmployeeById(Long empId);
}
