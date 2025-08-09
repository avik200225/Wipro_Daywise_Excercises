package com.wipro.springdemo.beans;

import org.springframework.stereotype.Component;

@Component
public class Display {
    private int size = 6;

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Display [size=" + size + "]";
    }
}
