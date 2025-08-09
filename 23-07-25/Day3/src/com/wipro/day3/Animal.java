package com.wipro.day3;

public abstract class Animal {
	
	int noOfLegs;
	String colour;
	
	abstract void animalSound();
	
	public int getNoOfLegs() {
		return noOfLegs;
	}
	public void setNoOfLegs(int noOfLegs) {
		this.noOfLegs = noOfLegs;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}	
}
