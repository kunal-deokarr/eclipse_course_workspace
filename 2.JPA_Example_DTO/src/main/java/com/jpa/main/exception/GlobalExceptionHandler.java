package com.jpa.main.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourceNotFoundHandler(ResourceNotFoundException re, 
											WebRequest webRequest)
	{
		ErrorDetails errorDetail = new ErrorDetails(LocalDateTime.now(), re.getMessage(),
										webRequest.getDescription(false), "USER-NOT-FOUND");
		
		return new ResponseEntity<ErrorDetails>(errorDetail, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(EmailAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> emailAlreadyExistHandler(EmailAlreadyExistException re,
													WebRequest webrequest)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), re.getMessage(),
									webrequest.getDescription(false), "Email-Already-Exist");
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> anyExceptionHandler(Exception exception, 
																WebRequest webrequest)
	{
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
									webrequest.getDescription(false), "INTERNAL SERVER ERROR");
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		
		allErrors.forEach((error) -> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			
			map.put(fieldName, message);
		});
		
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		
	}
	
	
}
