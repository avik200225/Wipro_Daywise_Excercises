package com.wipro.basic;

public class Ex_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float num1 = 25.5867f, num2 = 25.5872f;
		int n1 = Math.round(num1*1000);
		int n2 = Math.round(num2*1000);
		if (n1==n2){
			System.out.println("Same upto three decimal places");
		}
		else {
			System.out.println("Not same");
		}
	}
}
