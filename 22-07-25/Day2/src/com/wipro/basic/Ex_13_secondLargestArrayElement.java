package com.wipro.basic;

public class Ex_13_secondLargestArrayElement {

	public static void main(String[] args) {
		int num[] = {10, 5, 20, 8, 15};
		int lar = num[0],sl=0;
		for(int i=0;i<num.length;i++) {
			if (num[i]>lar) {
				sl=lar;
				lar=num[i];
			}
			else if(num[i]>sl && num[i]<lar) {
				sl=num[i];
			}
		}
		System.out.println("Second largest is: "+sl);
	}
}
