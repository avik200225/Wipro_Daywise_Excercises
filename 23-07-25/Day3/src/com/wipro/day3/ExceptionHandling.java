package com.wipro.day3;

public class ExceptionHandling {

	public static void main(String[] args) {
		String fName = null;
		try {
            String upper = fName.toUpperCase(); 
            System.out.println("Uppercase: " + upper);
        } 
		catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException: fName is null");
        }
		
    }
}
