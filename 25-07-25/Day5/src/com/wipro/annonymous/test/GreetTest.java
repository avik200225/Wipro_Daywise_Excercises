package com.wipro.annonymous.test;
import com.wipro.annonymous.Greet;

public class GreetTest {
	public static void main(String[] args) {
		Greet g =()->{
			System.out.println("Hello");
		};
		g.sayHello();		
	}
}
