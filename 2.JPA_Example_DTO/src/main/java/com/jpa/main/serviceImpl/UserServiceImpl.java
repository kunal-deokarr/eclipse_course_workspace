package com.jpa.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.main.dto.UserDto;
import com.jpa.main.entity.User;
import com.jpa.main.exception.EmailAlreadyExistException;
import com.jpa.main.exception.ResourceNotFoundException;
import com.jpa.main.mapper.AutoUserMapper;
import com.jpa.main.repository.UserRepository;
import com.jpa.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
// check if the user is exist with provided user-email
		
		Optional<User> o = ur.findByUserEmail(userDto.getUserEmail());
		
		if(o.isPresent())
		{
			throw new EmailAlreadyExistException("User already exist with email : "+userDto.getUserEmail());
		}
		
		// convert User-DTO to user
		
// Manually by mapper class		
		//User user = UserMapper.toUser(userDto);
		
// by using ModelMap		
//		User user = modelMapper.map(userDto, User.class);
		
// by using MapStrut		
		User user = AutoUserMapper.autoMapper.mapToUser(userDto);
		
		User savedUser = ur.save(user);
		
		// convert into userDto
		
		//UserDto userDtoConverted = UserMapper.toUserDto(savedUser);
		
		//UserDto userDtoConverted = modelMapper.map(savedUser, UserDto.class);
		
		UserDto userDtoConverted = AutoUserMapper.autoMapper.mapToUserDto(savedUser);
		
		return userDtoConverted;
	}

	@Override
	public UserDto getUserByUserId(Long userId) {

	//	Optional<User> opt = ur.findById(userId);
	
	/*	
		if(opt.isPresent())
		{
			User getUser = opt.get();
			UserDto userDto = AutoUserMapper.autoMapper.mapToUserDto(getUser);
			return userDto;
		}
		else
		{
			throw new ResourceNotFoundException("User", "id", userId);
		}
	*/
	
		
//		UserDto userDto = UserMapper.toUserDto(getUser);
		
//		UserDto userDto = modelMapper.map(getUser, UserDto.class);
	
//		UserDto userDto = AutoUserMapper.autoMapper.mapToUserDto(getUser);
		
		// return userDto;
		
		
		User user = ur.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User","id",userId)
				);
		
		return AutoUserMapper.autoMapper.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {

		List<User> users = ur.findAll();

		/*		
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		
		for(User u : users)
		{
			UserDto dto = UserMapper.toUserDto(u);
			userDtoList.add(dto);
		}
		 */		
		
		// use java 8 stream feature
		
		//return users.stream().map(e -> UserMapper.toUserDto(e)).toList();
		
//		return users.stream().map(UserMapper::toUserDto).toList();
		
//		return users.stream().map(e -> modelMapper.map(e, UserDto.class)).toList();
		
		return users.stream().map(e -> AutoUserMapper.autoMapper.mapToUserDto(e)).toList();
	}

	@Override
	public UserDto updateUser(UserDto userdto) {
			
		
		User exestingUser = ur.findById(userdto.getUserId()).orElseThrow(
				
				() -> new ResourceNotFoundException("User","id", userdto.getUserId())
				
				);
		
		
		
		if(userdto.getUserCity() != null)
		{
			exestingUser.setUserCity(userdto.getUserCity());
		}
		if(userdto.getUserName() != null)
		{
			exestingUser.setUserName(userdto.getUserName());
		}
	
		User updatedUser = ur.save(exestingUser);
		
//		UserDto convertedDto = UserMapper.toUserDto(updatedUser);
	
//		UserDto convertedDto = modelMapper.map(updatedUser, UserDto.class);
	
		UserDto convertedDto = AutoUserMapper.autoMapper.mapToUserDto(updatedUser);
		
		return convertedDto;

	}

	@Override
	public void deleteUser(Long userId) {
		
		User checkExistance = ur.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User","id",userId)
				);
		
		ur.deleteById(checkExistance.getUserId());
	
	}

}
