package com.wipro.annonymous.test;
import com.wipro.annonymous.Multiply;

public class MultiplyTest {
	public static void main(String[] args) {
	
		Multiply m = (a,b)->{return a*b;};
		int x= m.multiply(10,2);
		System.out.println(x);	
	}
}
