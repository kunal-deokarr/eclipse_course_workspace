package com.dep.main.exception;

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
public class ErrorApi {
	
	private String message;
	private LocalDateTime dateTime;
	private HttpStatus httpstatus;
	private String path;

}
