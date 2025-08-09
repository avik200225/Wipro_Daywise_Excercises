package com.wipro.annonymous.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.wipro.annonymous.Food;

public class FoodTest {
	public static void main(String[] args) {
		Food f1 = new Food("Chicken Noodles","NonVeg","Chinese",200);
		Food f2 = new Food("Veg Noodles","Veg","Chinese",100);
		Food f3 = new Food("Dal","Veg","Indian",80);
		Food f4 = new Food("Dosa","Veg","SouthIndian",150);	
		
		List<Food> flist = new ArrayList<>();
		flist.add(f1);
		flist.add(f2);
		flist.add(f3);
		flist.add(f4);
		
		List<Food> f = flist.stream()
				.filter(c -> c.getCuisine().equalsIgnoreCase("Chinese"))
				.collect(Collectors.toList());
		System.out.println(f);
		
		
	}	
}
