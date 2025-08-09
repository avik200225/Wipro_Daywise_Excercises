package com.wipro.datetimedemo;
import java.util.*;
import java.time.LocalDate;

public class LeapYear {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter year, month & date");
		int year = sc.nextInt();
		int month = sc.nextInt();
		int date =sc.nextInt();
		LocalDate dt = LocalDate.of(year,month,date);
		System.out.println(dt);
		int y = dt.getYear();
		
		if(year%400==0||(y%100!=0 && y%4==0))
	    {
	        System.out.println(y+" is a Leap Year");
	    }
	    else{
	        System.out.println(y+" is not a Leap Year");
	    }
	}
}
