package com.wipro.annonymous.test;
import java.util.function.Consumer;

public class ConsumerTest {
	public static void main(String[] args) {
	Consumer<Integer> printNextEven = number -> {
            int nextEven = (number % 2 == 0) ? number + 2 : number + 1;
            System.out.println("Next even number: " + nextEven);
        };
        printNextEven.accept(5); 
        printNextEven.accept(100);
	}
}
