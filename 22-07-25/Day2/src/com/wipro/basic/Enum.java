package com.wipro.basic;

public class Enum{

    enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
        JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public static void main(String[] args) {

        System.out.println("All Months:");
        for (Month m : Month.values()) {
            System.out.println(m);
        }

        Month selectedMonth = Month.FEBRUARY;

        if (selectedMonth == Month.FEBRUARY) {
            System.out.println("\nSelected month is FEBRUARY.");
        } else {
            System.out.println("\nSelected month is not FEBRUARY.");
        }
    }
}

