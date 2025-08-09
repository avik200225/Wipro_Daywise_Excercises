package com.wipro.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DuplicateList {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList());
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(20);
		// maintains order
		Set<Integer> uniqueSet = new LinkedHashSet<>(list); 
		//Convert back to a list if needed
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        System.out.println("After removing duplicates: " + uniqueList);
	}
}
