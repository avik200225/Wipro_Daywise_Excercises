package com.wipro.thread.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wipro.thread.ThreadConsonant;
import com.wipro.thread.ThreadVowel;

public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        List<String> names = new ArrayList<>(Arrays.asList("Amit", "Jayanta", "Anita", "Sourav", "Esha", "Bobby"));
        
        ThreadVowel t1 = new ThreadVowel(names);
        Thread thread1 = new Thread(t1);
        ThreadConsonant t2 = new ThreadConsonant(names);
        Thread thread2 = new Thread(t2);
        
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Final list: " + names);
    }
}
