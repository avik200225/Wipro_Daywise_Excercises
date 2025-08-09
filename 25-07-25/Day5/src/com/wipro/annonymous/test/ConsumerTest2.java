package com.wipro.annonymous.test;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.function.Consumer;

public class ConsumerTest2 {
    public static void main(String[] args) {
        Consumer<ZonedDateTime> t = time -> 
            System.out.println("Current time in Europe/London: " + time);

        ZonedDateTime londonTime = ZonedDateTime.now(ZoneId.of("Europe/London"));
        t.accept(londonTime);
    }
}