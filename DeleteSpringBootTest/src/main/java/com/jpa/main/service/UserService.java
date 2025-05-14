package com.jpa.main.service;

import java.util.List;

import com.jpa.main.dto.UserDto;
import com.jpa.main.entity.User;

public interface UserService{
	
	
	public UserDto createUser(UserDto userDto);
	
	public UserDto getUserWithId(Long userId);
	
	public List<UserDto> getAllUsers();
	
	public UserDto updateUser(Long userId, UserDto userDto);
	
	public void deleteUserById(Long userId);

}
