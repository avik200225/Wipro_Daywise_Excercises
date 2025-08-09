package com.wipro.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UppercaseTest {


	@Test
    public void exceptionCheck() {
        String str = null;
        assertThrows(NullPointerException.class, () -> {
            str.toUpperCase();
        });
	}
}

