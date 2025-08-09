package com.wipro.thread.test;

import com.wipro.thread.Counter;
import com.wipro.thread.CounterThread;

public class CounterTest {
		public static void main(String[] args) throws InterruptedException {
	        Counter counter = new Counter();

	        CounterThread t1 = new CounterThread(counter);
	        CounterThread t2 = new CounterThread(counter);

	        t1.start();
	        t2.start();

	        t1.join();
	        t2.join();

	        System.out.println("Final count: " + counter.getCount());
	    }
    }

