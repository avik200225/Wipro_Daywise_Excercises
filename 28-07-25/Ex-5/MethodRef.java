package com.wipro.methodref;

	import java.util.Arrays;
	import java.util.List;
	import java.util.stream.Collectors;

	public class MethodRef {
	    public static void main(String[] args) {
	        List<String> names = Arrays.asList("Avik", "Ram", "John", "Bella", "Chris");
	        List<String> sortedNames = names.stream().sorted(String::compareTo).collect(Collectors.toList());                                     
	        System.out.println("Sorted List:");
	        sortedNames.forEach(System.out::println);
	    }
	}

