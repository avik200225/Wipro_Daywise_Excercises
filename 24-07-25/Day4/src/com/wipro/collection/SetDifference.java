package com.wipro.collection;
import java.util.HashSet;
import java.util.Set;

public class SetDifference {
    public static void main(String[] args) {

        Set<Integer> setA = new HashSet<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);

        Set<Integer> setB = new HashSet<>();
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);
        setA.removeAll(setB); 

        System.out.println("Difference: " + setA);
    }
}
