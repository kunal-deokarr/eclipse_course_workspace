package com.dep.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dep.main.dto.DepartmentDto;
import com.dep.main.entity.Department;

@Mapper
public interface AutoMapper {

	
	AutoMapper autoMapper = Mappers.getMapper(AutoMapper.class);
	
	DepartmentDto mapToDto(Department dept);
	
	Department mapToJpa(DepartmentDto deptDto);
	
	
}
