package com.wipro.day3;

public class Shape{
	public int noOfSides;
	public String area;
	
	public Shape(int noOfSides, String area) {
		super();
		this.noOfSides = noOfSides;
		this.area = area;
	}

//	public int getNoOfSides() {
//		return noOfSides;
//	}
//
//	public void setNoOfSides(int noOfSides) {
//		this.noOfSides = noOfSides;
//	}
//
//	public String getArea() {
//		return area;
//	}
//
//	public void setArea(String area) {
//		this.area = area;
//	}

	@Override
	public String toString() {
		return "Shape [noOfSides=" + noOfSides + ", area=" + area + "]";
	}
}
