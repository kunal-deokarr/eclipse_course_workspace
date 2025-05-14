package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Practice {
	
	public static void main(String[] args) {
		
		List<Employee> al=new ArrayList<>();
		al.add(new Employee(6, "Jhansi", 32, "F", "engg", 2011, 250000));
		al.add(new Employee(7, "SK", 28, "M", "sales", 2015, 350000));
		al.add(new Employee(5, "Swati", 25, "F", "marketing", 2016, 450000));
		al.add(new Employee(2, "Pavan", 30, "M", "agri", 2022, 150000));
		al.add(new Employee(4, "kk", 28, "F", "engg", 2010, 450000));
		al.add(new Employee(1, "nk", 35, "F", "pharmacy", 2024, 850000));
		al.add(new Employee(3, "dk", 25, "F", "marketing", 2000, 50000));
		
		
		Optional<Employee> first = al.stream().sorted((a,b) -> (int)(a.getSalary()-b.getSalary())).skip(1).findFirst();

		
		System.out.println(first.get());
		
		
		List<Integer> list = Arrays.asList(1,2,5,6,7);
		
		List<Integer> list2 = list.stream().map(e -> e*e).toList();
		
		list2.forEach(System.out::println);
		
	}

	
	
	
}
