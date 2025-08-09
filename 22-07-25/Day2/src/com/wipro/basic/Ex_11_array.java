package com.wipro.basic;

public class Ex_11_array {

	public static void main(String[] args) {
		int numbers[] = {2,4,6,8,10};
		for(int i=0;i<numbers.length;i++) {
			numbers[i]=numbers[i]*2;
		}
		for(int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i]+" ");
		}
	}
}
