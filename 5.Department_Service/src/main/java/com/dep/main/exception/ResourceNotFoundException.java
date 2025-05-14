package com.dep.main.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private String msg;
	
	public ResourceNotFoundException(String msg)
	{
		super(msg);
	}

}
