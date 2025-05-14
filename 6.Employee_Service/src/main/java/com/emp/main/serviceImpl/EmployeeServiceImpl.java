package com.emp.main.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.emp.main.dto.ApiResponseDto;
import com.emp.main.dto.DepartmentDto;
import com.emp.main.dto.EmployeeDto;
import com.emp.main.entity.Employee;
import com.emp.main.exception.ResourceNotFoundException;
import com.emp.main.mapper.AutoMapper;
import com.emp.main.repository.EmployeeRepository;
import com.emp.main.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webClient;

	@Autowired
	private ApiResponse apiResponse;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto empDto) {
		
		// convert to emp jpa
		
//		Employee emp = new Employee(empDto.getId(),empDto.getFirstName(),empDto.getLastName(),empDto.getEmail());
	
		Employee emp = AutoMapper.autoMapper.mapToEmployee(empDto);
		
		Employee savedEmp = repo.save(emp);
		
		// convert to dto
		
//		EmployeeDto savedDto = new EmployeeDto(savedEmp.getId(),savedEmp.getFirstName(),savedEmp.getLastName(),savedEmp.getEmail());
	
		EmployeeDto savedDto = AutoMapper.autoMapper.mapToEmployeeDto(savedEmp);
		
		return savedDto;
		
	}
	
	
	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public ApiResponseDto getEmployeeById(Long empId) {
		
		Optional<Employee> opt = repo.findById(empId);
		
		if(opt.isPresent())
		{
			Employee emp = opt.get();
			
			EmployeeDto empDto = AutoMapper.autoMapper.mapToEmployeeDto(emp);
			
//			ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/dept/code/"+emp.getDepartmentCode(),
//																				DepartmentDto.class);

/*			DepartmentDto deptDto = webClient.get()
			.uri("http://localhost:8080/api/dept/code/"+emp.getDepartmentCode())
			.retrieve()
			.bodyToMono(DepartmentDto.class)
			.block();
*/
			DepartmentDto deptDto = apiResponse.getDepartment(empDto.getDepartmentCode());
			
			ApiResponseDto apiResponse = new ApiResponseDto();
			apiResponse.setEmployee(empDto);
//			apiResponse.setDepartment(responseEntity.getBody());
			apiResponse.setDepartment(deptDto);
			
			return apiResponse;
			
		}
		else {
			
			throw new ResourceNotFoundException("No Employee found with ID : "+empId);
		}
		
		
	}
	
// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ FAllBACK METHOD $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
	
public ApiResponseDto getDefaultDepartment(Long empId) {
		
		Optional<Employee> opt = repo.findById(empId);
		
		
			Employee emp = opt.get();
			
			EmployeeDto empDto = AutoMapper.autoMapper.mapToEmployeeDto(emp);
			
//			ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/dept/code/"+emp.getDepartmentCode(),
//																				DepartmentDto.class);

/*			DepartmentDto deptDto = webClient.get()
			.uri("http://localhost:8080/api/dept/code/"+emp.getDepartmentCode())
			.retrieve()
			.bodyToMono(DepartmentDto.class)
			.block();
*/
			DepartmentDto deptDto = new DepartmentDto();
			deptDto.setDepartmentName("fallback Department");
			deptDto.setDepartmentCode("fake Code");
			deptDto.setDepartmentDescription("fake Description");
			
			ApiResponseDto apiResponse = new ApiResponseDto();
			apiResponse.setEmployee(empDto);
//			apiResponse.setDepartment(responseEntity.getBody());
			apiResponse.setDepartment(deptDto);
			
			return apiResponse;
			
		}
	
	
	
}
