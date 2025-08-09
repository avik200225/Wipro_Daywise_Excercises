package com.wipro.day3;

public class Exception_Currency {
	
	 public static double changeCurrency(double amount) throws NumberFormatException {
	        if (amount == 0) {
	            throw new NumberFormatException("Invalid Number");
	        }
	        return amount * 80;
	    }

	public static void main(String[] args) {
 
		 try {
	            double result = changeCurrency(0); 
	        } catch (NumberFormatException e) {
	            System.out.println("Exception occurred: " + e.getMessage());
	        }
	}
}
