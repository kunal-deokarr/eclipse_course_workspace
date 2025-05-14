package com.jpa.main.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	String msg;
	
	public ResourceNotFoundException(String msg)
	{
		super(msg);
	}
	

}
