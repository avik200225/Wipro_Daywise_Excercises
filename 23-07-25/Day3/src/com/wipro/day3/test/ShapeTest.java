package com.wipro.day3.test;

import com.wipro.day3.Circle;
import com.wipro.day3.Rectangle;
import com.wipro.day3.Square;

public class ShapeTest {

	public static void main(String[] args) {
		
	Circle c = new Circle(0,"pirsquare");
//	c.setArea("area of circle");
//	c.setNoOfSides(0);
	
	Rectangle r = new Rectangle(4, "l*b");
//	r.setArea("area of rectangle");
//	r.setNoOfSides(4);
	
	Square s = new Square(4, "l*l");
//	s.setArea("area of square");
//	s.setNoOfSides(4);
	
	System.out.println("Area of Circle is: "+c.area);
	System.out.println("Area of Rectangle is: "+r.area);
	System.out.println("Area of Square is: "+s.area);
//	System.out.println(c.getArea());
//	System.out.println("No of sides of circle: "+c.getNoOfSides());
//	
//	System.out.println(r.getArea());
//	System.out.println("No of sides of rectangle: "+r.getNoOfSides());
//	
//	System.out.println(s.getArea());
//	System.out.println("No of sides of square: "+s.getNoOfSides());
	
	}

}
