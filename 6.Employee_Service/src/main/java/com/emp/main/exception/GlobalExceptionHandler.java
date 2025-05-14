package com.emp.main.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> resourceNotFoundHandler(ResourceNotFoundException ex, HttpServletRequest request)
	{
		ApiError error = new ApiError();
		error.setMessage(ex.getMessage());
		error.setHttpStatus(HttpStatus.NOT_FOUND);
		error.setLocalDateTime(LocalDateTime.now());
		error.setPath(request.getRequestURI());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
