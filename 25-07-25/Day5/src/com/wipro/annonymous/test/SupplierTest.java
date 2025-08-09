package com.wipro.annonymous.test;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		Supplier<String> tomorrow = () -> {
            DayOfWeek d = LocalDate.now().plusDays(1).getDayOfWeek();
            return d.toString();
        };
		System.out.println("Tomorrow is: " + tomorrow.get());
	}
}
