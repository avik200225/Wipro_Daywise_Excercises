package com.wipro.basic;

public class stringVowelCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "ELEPHANT";
		name = name.toLowerCase();
	    int vow=0,cons=0;
	    for(int i=0;i<name.length();i++){
	        if(name.charAt(i)=='a'||name.charAt(i)=='e'|| name.charAt(i)=='i' || name.charAt(i)=='o'
	        		|| name.charAt(i)=='u'){
	            vow++;
	        }
	        else {
	        	cons++;
	        }
	    }
	        System.out.println("Number of vowels and consonants in string is: "+vow+ "and "+cons);
	    }
	}

