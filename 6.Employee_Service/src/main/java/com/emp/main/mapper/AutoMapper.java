package com.emp.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.emp.main.dto.EmployeeDto;
import com.emp.main.entity.Employee;

@Mapper
public interface AutoMapper {
	
	
	AutoMapper autoMapper = Mappers.getMapper(AutoMapper.class);

	
	EmployeeDto mapToEmployeeDto(Employee emp);
	
	
	Employee mapToEmployee(EmployeeDto empDto);
}
