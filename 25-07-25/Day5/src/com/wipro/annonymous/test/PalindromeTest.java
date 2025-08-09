package com.wipro.annonymous.test;
import java.util.function.Predicate;

public class PalindromeTest {
	public static void main(String[] args) {

	Predicate <String> isPalindrome = s -> {
		return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
	};
	
	System.out.println(isPalindrome.test("MADAM"));
	}
}
