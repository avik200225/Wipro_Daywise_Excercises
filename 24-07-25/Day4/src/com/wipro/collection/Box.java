package com.wipro.collection;

public class Box<X> {
    X x;

    public Box(X x) {
        this.x = x;
    }

    public void add(X x) {
        this.x = x;
    }

    public X getData() {
        return x;
    }
}
