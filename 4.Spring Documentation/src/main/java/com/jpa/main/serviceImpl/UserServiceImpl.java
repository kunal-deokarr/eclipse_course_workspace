package com.jpa.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.main.dto.UserDto;
import com.jpa.main.entity.User;
import com.jpa.main.exception.ResourceNotFoundException;
import com.jpa.main.mapper.AutoMapper;
import com.jpa.main.repository.UserRepository;
import com.jpa.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository ur;
	

	@Override
	public UserDto createUser(UserDto userDto) {
		
		// convert Dto into jpa
		
		User user = AutoMapper.autoMapper.mapToUser(userDto);
		
		// save converted user to DB
		
		User savedUser = ur.save(user);
		
		// convert jpa into DTO
		
		UserDto convertedDto = AutoMapper.autoMapper.mapToUserDto(savedUser);
	
		return convertedDto;
	}
	
// #########################################################################################	

	@Override
	public UserDto getUserWithId(Long userId) {
		
		// find user first
		
		Optional<User> optional = ur.findById(userId);
		
		if(optional.isPresent())
		{
			User user = optional.get();
			
			// convert to Dto
			
			UserDto convertedDto = AutoMapper.autoMapper.mapToUserDto(user);
			
			return convertedDto;
		}
		else {
			throw new ResourceNotFoundException("No user found with Id : "+userId);
		}
		
		
		
	}
	
// #########################################################################################

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> list = ur.findAll();
		
		return list.stream().map(e -> AutoMapper.autoMapper.mapToUserDto(e)).toList();
	}

// #########################################################################################	
	
	@Override
	public UserDto updateUser(Long userId, UserDto userDto) {
		
		Optional<User> Optional = ur.findById(userId);
		
		if(Optional.isPresent())
		{
			User existingUser = Optional.get();
			
			if(userDto.getFirstName() != null)
			{
				existingUser.setFirstName(userDto.getFirstName());
			}
			if(userDto.getLastName() != null)
			{
				existingUser.setLastName(userDto.getLastName());
			}
			if(userDto.getEmail() != null)
			{
				existingUser.setEmail(userDto.getEmail());
			}
			
			ur.save(existingUser);
			
			UserDto returnDto = AutoMapper.autoMapper.mapToUserDto(existingUser);
			
			return returnDto;
		}
		else
		{
			throw new ResourceNotFoundException("No user found with Id : "+userId);
		}
		
		
	}
	
// #########################################################################################	

	@Override
	public void deleteUserById(Long userId) {
		
		ur.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with Id : "+userId));
		
		ur.deleteById(userId);
		
	}

}
