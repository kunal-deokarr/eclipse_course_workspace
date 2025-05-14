package com.jpa.main.payload;

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
	
	String msg;
	HttpStatus httpCode;
	LocalDateTime localDateTime;
	String path;

}
