package com.jpa.main.service;

import java.util.List;

import com.jpa.main.dto.UserDto;
import com.jpa.main.entity.User;

public interface UserService {
	
	
	public UserDto createUser(UserDto userDto);
	
	public UserDto getUserByUserId(Long userId);
	
	public List<UserDto> getAllUser();
	
	public UserDto updateUser(UserDto userdto);
	
	public void deleteUser(Long userId);

}
