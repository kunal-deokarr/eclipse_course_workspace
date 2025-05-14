package com.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	
	String msg;
	
	Test(String msg)
	{
		System.out.println("Constructor");
	}
	
	Test test()
	{
		System.out.println("test");
		return this;
	}
	
	Test west() {
		System.out.println("west");
		return this;
	} 
	
	public static void main(String[] args) {
		
		try {
			Test t = (Test)Class.forName("TestThing").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
