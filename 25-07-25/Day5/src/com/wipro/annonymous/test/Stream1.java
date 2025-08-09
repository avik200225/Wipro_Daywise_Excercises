package com.wipro.annonymous.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream1 {
	public static void main(String[] args) {
	List<String> names = Arrays.asList("Yash","Jayanta", "Jnanedra","Yash",
			"Amit", "Raja", "Anjali", "Jaya");

    List<String> filteredNames = names.stream()
     .filter(name -> name.toLowerCase()
     .contains("ja"))
     .collect(Collectors.toList());
    
    System.out.println(filteredNames);
	}	
}
