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

import com.jpa.main.payload.ErrorApi;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorApi> resourceNotFoundHandler(ResourceNotFoundException ex,
															HttpServletRequest request	)
	{
		
		ErrorApi error = new ErrorApi();
		error.setMsg(ex.getMessage());
		error.setLocalDateTime(LocalDateTime.now());
		error.setPath(request.getRequestURI());
		error.setHttpCode(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ErrorApi>(error, HttpStatus.NOT_FOUND);
		
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Map<String, String> map = new HashMap<String, String>();
		
			List<ObjectError> errors = ex.getBindingResult().getAllErrors();
		
			errors.forEach((error) ->
			{
				String fieldError =	((FieldError) error).getField();
				String message = error.getDefaultMessage();
				
				map.put(fieldError, message);
			});
			
			return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
		
	}
	
}
