package com.wipro.collection;

import java.util.ArrayList;

public class Arraylist {
	public static void main(String args[]) {
	ArrayList<Integer> num = new ArrayList<>();
	
    num.add(20);
    num.add(30);
    num.add(40);
    num.add(50);
    num.add(60); 
    num.remove(2);   
    System.out.println("After removing index 2: " + num);   
    num.add(70);
    System.out.println("After adding 60 at the end: " + num);

}
}