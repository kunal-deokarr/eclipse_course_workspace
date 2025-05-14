package com.jpa.main.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
	description = "UseDto Model Information"	
		)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	@Schema(
		description = "Users First Name"	
			)
	@NotEmpty(message = "First name cannot be emtpy or null")
	private String firstName;
	
	@Schema(
			description = "Users Last Name"	
				)
	@NotEmpty(message = "Last name cannot be emtpy or null")
	private String lastName;
	
	@Schema(
			description = "Users Email Address"	
				)
	@Email(message = "Email should in proper format")
	@NotEmpty(message = "Email cannot be emtpy or null")
	private String email;

}
