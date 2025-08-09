package com.wipro.collection;

public class BoxDemo {

    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>(1);
        System.out.println(b1.getData());

        Box<String> b2 = new Box<>("Hello");
        System.out.println(b2.getData());
    }
}
