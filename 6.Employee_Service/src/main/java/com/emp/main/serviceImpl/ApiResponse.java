package com.emp.main.serviceImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.emp.main.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiResponse {

	@GetMapping("/api/dept/code/{deptCode}")
	DepartmentDto getDepartment(@PathVariable("deptCode") String deptCode);
	
}
