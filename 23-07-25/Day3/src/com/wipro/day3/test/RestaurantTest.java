package com.wipro.day3.test;

import com.wipro.day3.Restaurant;

public class RestaurantTest{

		public static void main(String[] args) {

		Restaurant res = new Restaurant("Delhi",1478523690,55);
		System.out.println("Restaurant Address: "+res.getRestaurantAddress());
		System.out.println("Restaurant Contact Num: "+res.getContactNum());
	}
}
