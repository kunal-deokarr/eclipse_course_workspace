package com.jpa.main.exception;


public class EmailAlreadyExistException extends RuntimeException{
	
	String messsage;

	public EmailAlreadyExistException(String message)
	{
		super(message);
		
	}
	
}
