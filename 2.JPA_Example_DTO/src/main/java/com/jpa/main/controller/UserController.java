package com.jpa.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.main.dto.UserDto;
import com.jpa.main.entity.User;
import com.jpa.main.service.UserService;
import com.jpa.main.serviceImpl.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	private UserService us;
	
// create user	
	
	@PostMapping("/save")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto savedDto = us.createUser(userDto);
		
		return new ResponseEntity<UserDto>(savedDto, HttpStatus.CREATED);
	}
	
// get user by ID
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<UserDto> getUserByID(@PathVariable("id") Long userId)
	{
		UserDto userDto = us.getUserByUserId(userId);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
// get all users
	
	@GetMapping("/findAll")
	public ResponseEntity<List<UserDto>> findAllUsers()
	{
		List<UserDto> usersList = us.getAllUser();
		return new ResponseEntity<List<UserDto>>(usersList, HttpStatus.OK);
	}
	
// update the user
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long userId,
											@Valid @RequestBody UserDto userdto)
	{
		userdto.setUserId(userId);
		
		UserDto u = us.updateUser(userdto);
		
		return new ResponseEntity<UserDto>(u, HttpStatus.OK);
		
	}
	
// delete user by user id
	
	@DeleteMapping("delete/{userId}")
	public ResponseEntity<String> deleteById(@PathVariable Long userId)
	{
		us.deleteUser(userId);
		
		return new ResponseEntity<String>("User Deleted Successfully", HttpStatus.OK);
	}
	
	
	
}
