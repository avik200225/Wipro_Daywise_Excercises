package com.wipro.datetimedemo;
import java.util.*;
import java.time.LocalDate;
import java.time.Period;

public class DateToAge {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter birth year: ");
        int year = scanner.nextInt();
        System.out.print("Enter birth month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter birth day (1-31): ");
        int day = scanner.nextInt();

        LocalDate birthDate = LocalDate.of(year, month, day);       
        LocalDate currentDate = LocalDate.now();
        System.out.println(Period.between(birthDate, currentDate).getYears()); 
        //.getYears() returns only year diff
        scanner.close();
	}
}
