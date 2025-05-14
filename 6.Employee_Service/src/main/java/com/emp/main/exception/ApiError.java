package com.emp.main.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

	private String message;
	private String path;
	private HttpStatus httpStatus;
	private LocalDateTime localDateTime;
	
}
