package com.wipro.annonymous.test;
import java.util.Optional;

public class OptionalClass {
	    public static void main(String[] args) {

	        Optional<Integer> optionalNumber = Optional.of(123);
	        optionalNumber.ifPresent(value -> System.out.println("Value is: " + value));
	        Optional<Integer> emptyOptional = Optional.empty();
	        int result = emptyOptional.orElse(0);
	        System.out.println("Value from empty optional (orElse): " + result);
	    }
	}
