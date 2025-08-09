package com.wipro.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringJunitTest {
    @Test
    void testStringIsUppercase() {
        String input = "HELLO";
        assertTrue(input.equals(input.toUpperCase()));
    }
}


