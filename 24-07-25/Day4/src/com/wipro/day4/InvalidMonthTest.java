package com.wipro.day4;
import java.util.*;

public class InvalidMonthTest {

	static void checkMonth(int month) throws InvalidMonthException 
	{
        if (month < 1 || month > 12) {
            throw new InvalidMonthException("Invalid Month: " + month + 
            ". Month should be between 1 and 12.");
        } else {
            System.out.println("Valid month: " + month);
        }
    }
	public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter the month number: ");
	int n = sc.nextInt();
	try {
		checkMonth(n);
	} catch (InvalidMonthException e) {
		e.printStackTrace();
	}
	}
}
