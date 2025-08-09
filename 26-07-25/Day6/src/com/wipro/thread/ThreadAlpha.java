package com.wipro.thread;

public class ThreadAlpha extends Thread {
	public void run() {
		for(char c='A'; c<='J';c++) {
			System.out.println(c);
		}
		try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }		
	}
}
