package com.jpa.main.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Long userId;
	
	@NotEmpty(message = "User name should not be empty or null")
	private String userName;
	
	@NotEmpty(message = "City name should not be empty or null")
	private String userCity;
	
	@NotEmpty(message = "Email should not be empty or null")
	@Email(message = "Email should in valid arragement")
	private String userEmail;

}
