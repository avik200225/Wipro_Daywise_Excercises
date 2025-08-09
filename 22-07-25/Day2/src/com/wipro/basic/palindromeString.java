package com.wipro.basic;

/*public class palindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "MADAM";
		String reversed = "";
		for(int i=s.length()-1;i>=0;i--) {
			reversed += s.charAt(i);
		}
		if(s.equalsIgnoreCase(reversed)) {
			System.out.println("Palindrome String");
		}
		else {
			System.out.println("Not Palindrome");
		}
	}
	*/
	public class palindromeString {

	    public static void main(String[] args) {
	        String input = "Madam";
	        input = input.toLowerCase();

	        StringBuilder sb = new StringBuilder(input);
	        String reversed = sb.reverse().toString();

	        // Check if original and reversed strings are equal
	        if (input.equals(reversed)) {
	            System.out.println("The string is a palindrome.");
	        } else {
	            System.out.println("The string is not a palindrome.");
	        }
	    }
	}

	
	//WITH STRINGBUILDER
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Strring s = 
//		StringBuilder s = new StringBuilder("MADAM");
//		StringBuilder sr = new StringBuilder(s).reverse();
//		if(s.equals(sr)) {
//			System.out.println("Palindrome String");
//		}
//		else {
//			System.out.println("Not Palindrome");
//		}
//	}

