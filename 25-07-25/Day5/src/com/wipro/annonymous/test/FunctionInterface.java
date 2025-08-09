package com.wipro.annonymous.test;

import java.util.function.Function;
public class FunctionInterface {
	public static void main(String[] args) {
		Function<Double, Double> getFraction = num -> num - Math.floor(num);

        double number = 123.45;
        double fraction = getFraction.apply(number);

        System.out.printf("Fractional part: %.2f", fraction);
	}
}
