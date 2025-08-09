package com.wipro.annonymous.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalInterface2 {
	public static void main(String[] args) {
		List<String> input = List.of("Jayanta","Amit","Vasu");
		Function<List<String>,List<Integer>> getlength = list ->{
			List<Integer> lengths = new ArrayList<>();
			for(String s: list) {
				lengths.add(s.length());
			}
			return lengths;
		};
		List<Integer> res = getlength.apply(input);
		System.out.println(res);
	}
}
