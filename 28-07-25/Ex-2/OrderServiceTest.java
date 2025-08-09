package com.WiproA.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrderServiceTest {
	 @Test
	    void test() {

	        OrderService mockOrderService = Mockito.mock(OrderService.class);
	        when(mockOrderService.placeOrder("ORD-01")).thenReturn("successful");
	        String result = mockOrderService.placeOrder("ORD-01");
	        assertEquals("successful", result);
	        verify(mockOrderService).placeOrder("ORD-01");
}
}
