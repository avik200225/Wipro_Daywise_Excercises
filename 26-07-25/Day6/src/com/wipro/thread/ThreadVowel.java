package com.wipro.thread;

import java.util.List;


public class ThreadVowel implements Runnable {
    public List<String> names;

    public ThreadVowel(List<String> names) {
       this.names = names;
    }
    @Override
    public void run() {
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
                char ch = Character.toLowerCase(name.charAt(0));
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    names.set(i, name.toUpperCase());
                }
            }
        }
    }
	
