package com.jpa.main.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	@NotEmpty(message = "First name cannot be emtpy or null")
	private String firstName;
	
	@NotEmpty(message = "Last name cannot be emtpy or null")
	private String lastName;
	
	@Email(message = "Email should in proper format")
	@NotEmpty(message = "Email cannot be emtpy or null")
	private String email;

}
