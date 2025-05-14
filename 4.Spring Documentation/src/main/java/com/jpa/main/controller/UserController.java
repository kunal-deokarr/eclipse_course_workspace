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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
		name = "CRUD Rest api for user resource",
		description = "CRUD Rest API for Create user, Delete user, Update user, Find user and Find all users."
		)
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;
	
// #########################################################################################	
	
	@Operation(
			summary = "Create user Rest Api",
			description = "This api is used to save user detail in database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "Http Status code 201:CREATED"
			)
	@PostMapping("/save")
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto user)
	{
		UserDto returnUser = us.createUser(user);
		return new ResponseEntity<UserDto>(returnUser, HttpStatus.CREATED);
	}
	
// #########################################################################################	

	@Operation(
			summary = "Get all users Rest Api",
			description = "This api is used to get all users detail from database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status code 200:OK"
			)
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		List<UserDto> userList = us.getAllUsers();
		return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
	}
	
// #########################################################################################	

	@Operation(
			summary = "Update the user by Id Rest Api",
			description = "This api is used update user detail from database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status code 200:OK"
			)
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto user)
	{
		UserDto updateUser = us.updateUser(userId, user);
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);
	}
	
// #########################################################################################	

	@Operation(
			summary = "Get user by ID Rest Api",
			description = "This api is used to get user detail by ID from database"
			)
	@ApiResponse(
			responseCode = "302",
			description = "Http Status code 302:FOUND"
			)
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDto> findUserById(@PathVariable Long userId)
	{
		UserDto user = us.getUserWithId(userId);
		return new ResponseEntity<UserDto>(user, HttpStatus.FOUND);
	}
	
// #########################################################################################	

	@Operation(
			summary = "Delete user by ID Rest Api",
			description = "This api is used Delete user from database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status code 200:OK"
			)
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId)
	{
		us.deleteUserById(userId);
		return new ResponseEntity<String>("Deleted...!!!", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
