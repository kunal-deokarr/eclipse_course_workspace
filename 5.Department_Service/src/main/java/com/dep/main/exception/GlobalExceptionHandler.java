package com.dep.main.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorApi> resourceExceptionHandler(ResourceNotFoundException exception, 
														HttpServletRequest request)
	{
		ErrorApi api = new ErrorApi(exception.getMessage(), LocalDateTime.now(), HttpStatus.NOT_FOUND, request.getRequestURI());
		
		return new ResponseEntity<>(api, HttpStatus.NOT_FOUND);
	}
}
