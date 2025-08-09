package com.wipro.orderms.dto;
import lombok.Data;


@Data
public class Payment {
 
	int id;
	String orderId;	  
	boolean paymentStatus; 
	double paymentAmount;

}
