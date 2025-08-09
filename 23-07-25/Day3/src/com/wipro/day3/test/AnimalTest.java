package com.wipro.day3.test;

import com.wipro.day3.Bird;
import com.wipro.day3.Dog;
import com.wipro.day3.Human;

public class AnimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human h = new Human();
		h.setColour("brown");
		h.setNoOfLegs(2);
		System.out.println("Colour of Human is: "+h.getColour());
		System.out.println("No of legs of human is: "+h.getNoOfLegs());
		
		h.animalSound();
		
		Dog d =new Dog();
		d.animalSound();
		
		Bird b = new Bird();
		b.animalSound();
	}
}
