package com.jpa.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.jpa.main.dto.UserDto;
import com.jpa.main.entity.User;

@Mapper
public interface AutoMapper {
	
	
	AutoMapper autoMapper = Mappers.getMapper(AutoMapper.class);
	
	
	@Mapping(target = "userId", ignore = true)
	 User mapToUser(UserDto userDto);
	
	
	 UserDto mapToUserDto(User user);

}
