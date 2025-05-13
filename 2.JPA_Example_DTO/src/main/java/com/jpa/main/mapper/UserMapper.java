package com.jpa.main.mapper;

import com.jpa.main.dto.UserDto;
import com.jpa.main.entity.User;

public class UserMapper {
	
// convert user to userdto	
	
	public static UserDto toUserDto(User user)
	{
		UserDto userDto = new UserDto(user.getUserId(), 
									  user.getUserName(),
									  user.getUserCity(),
									  user.getUserEmail());	
		return userDto;
	}
	

// convert userDto to user	
	
	public static User toUser(UserDto userDto)
	{
		User user = new User(userDto.getUserId(),
							userDto.getUserName(),
							userDto.getUserCity(),
							userDto.getUserEmail());
		
		return user;
	}

}
