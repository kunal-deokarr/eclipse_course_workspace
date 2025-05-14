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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;
	
// #########################################################################################	
	
	@PostMapping("/save")
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto user)
	{
		UserDto returnUser = us.createUser(user);
		return new ResponseEntity<UserDto>(returnUser, HttpStatus.CREATED);
	}
	
// #########################################################################################	

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		List<UserDto> userList = us.getAllUsers();
		return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
	}
	
// #########################################################################################	

	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@Valid @RequestBody UserDto user)
	{
		UserDto updateUser = us.updateUser(userId, user);
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);
	}
	
// #########################################################################################	

	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDto> findUserById(@PathVariable Long userId)
	{
		UserDto user = us.getUserWithId(userId);
		return new ResponseEntity<UserDto>(user, HttpStatus.FOUND);
	}
	
// #########################################################################################	

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId)
	{
		us.deleteUserById(userId);
		return new ResponseEntity<String>("Deleted...!!!", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
