package com.wipro.basic;
import java.util.*;
public class Ex_12_largestnumarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size/no. of elements in the array: ");
		int n = sc.nextInt();
		int num[] = new int[n];
		System.out.println("Enter the elements of array: ");
		for(int i=0;i<num.length;i++) {
			num[i]=sc.nextInt();
		}
		int max = num[0];
		for(int i=1;i<num.length;i++) {
			if(num[i]>max) {
				max=num[i];
			}
		}
		System.out.println("Largest element is: "+max);
	}
}
