package com.wipro.thread.test;

import com.wipro.thread.ThreadAlpha;
import com.wipro.thread.ThreadNum;

public class ThreadDemo {

	public static void main(String[] args) {	 
		ThreadNum t1 = new ThreadNum();
		t1.start();
		ThreadAlpha t2= new ThreadAlpha();
		t2.start();
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
