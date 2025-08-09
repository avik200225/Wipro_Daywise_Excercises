package com.wipro.basic;
import java.util.Scanner;
public class Ex_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter any floating number: ");
		float i = sc.nextFloat();
		float absValue = Math.abs(i);
		if (i == 0) {
            System.out.println("Zero");
        } else {
            if (i > 0) {
                System.out.print("Positive");
            } else {
                System.out.print("Negative");
            }

            if (absValue < 1) {
                System.out.print(" and small");
            } else if (absValue > 1000000) {
                System.out.print(" and large");
            }
	}
		sc.close();
}
}
