package com.wipro.datetimedemo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2023, 11, 1);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(date.format(f));
	}
}
