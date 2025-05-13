package com.jpa.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jpa.main.dto.UserDto;
import com.jpa.main.entity.User;

@Mapper
public interface AutoUserMapper {
	
// instance of AutoUserMapper	
	AutoUserMapper autoMapper = Mappers.getMapper(AutoUserMapper.class);

// Jpa entity to DTO	
	UserDto mapToUserDto(User user);
	
// Dto to jpa entity	
	User mapToUser(UserDto userDto);

}
