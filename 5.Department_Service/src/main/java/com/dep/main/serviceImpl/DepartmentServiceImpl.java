package com.dep.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dep.main.dto.DepartmentDto;
import com.dep.main.entity.Department;
import com.dep.main.exception.ResourceNotFoundException;
import com.dep.main.mapper.AutoMapper;
import com.dep.main.repository.DepartmentRepository;
import com.dep.main.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository repo;
	
	
// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$		

	// save department logic
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto deptDto) {
		
		// convert Dto into jpa entity
		
//		Department dept = new Department(
//				deptDto.getId(),
//				deptDto.getDepartmentName(),
//				deptDto.getDepartmentDescription(),
//				deptDto.getDepartmentCode()
//				);
		
		Department dept = AutoMapper.autoMapper.mapToJpa(deptDto);
		
		Department savedDept = repo.save(dept);
		
		// convert department jpa entity to department dto
		
//		DepartmentDto savedDeptDto = new DepartmentDto(
//				savedDept.getId(),
//				savedDept.getDepartmentName(),
//				savedDept.getDepartmentDescription(),
//				savedDept.getDepartmentCode()
//				);
		
		DepartmentDto savedDeptDto = AutoMapper.autoMapper.mapToDto(savedDept);
				
		
		return savedDeptDto;
	}


// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$	

	// get Department by Department code logic
	
	@Override
	public DepartmentDto getDepartmentByCode(String deptCode) {
		
		
		Optional<Department> optional = repo.findByDepartmentCode(deptCode);
		
		if(optional.isPresent())
		{
			Department existingDepartment = optional.get();
			
//			DepartmentDto deptDto = new DepartmentDto(existingDepartment.getId(),existingDepartment.getDepartmentName(),
//					existingDepartment.getDepartmentDescription(),existingDepartment.getDepartmentCode());
			
			DepartmentDto deptDto = AutoMapper.autoMapper.mapToDto(existingDepartment);
			
			return deptDto;
			
		}
		else {
			throw new ResourceNotFoundException("No Department Found with Code : "+deptCode);
		}
		
		
		
		
	}
	
// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$	

// get department by ID	
	
	public DepartmentDto getDepartmentById(Long deptId)
	{
		Optional<Department> optional = repo.findById(deptId);
		
		if(optional.isPresent())
		{
			Department dept = optional.get();
			
			// convert into dto
			
			DepartmentDto deptDto = AutoMapper.autoMapper.mapToDto(dept);
			
			return deptDto;
			
		}
		else {
			throw new ResourceNotFoundException("No department found with ID : "+deptId);
		}
	}
	
	
	

}
