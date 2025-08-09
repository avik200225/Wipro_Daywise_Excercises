package com.wipro.annonymous.test;

import java.util.function.Predicate;
import java.util.*;

public class CheckTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Predicate<String> isUpperCase = str -> str.equals(str.toUpperCase());
        Predicate<String> isLowerCase = str -> str.equals(str.toLowerCase());

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isUpperCase.test(input)) {
            System.out.println("The string is in uppercase.");
        } 
        else if (isLowerCase.test(input)) {
            System.out.println("The string is in lowercase.");
		}
        sc.close();
	}
}
