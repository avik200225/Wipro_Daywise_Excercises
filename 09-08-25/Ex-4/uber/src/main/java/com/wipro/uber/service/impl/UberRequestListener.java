package com.wipro.uber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wipro.uber.dto.BookingRequestDTO;
import com.wipro.uber.service.UberBookingService;
import com.wipro.uber.util.AppConstant;

@Service
public class UberRequestListener {
	
	@Autowired
	UberBookingService uberBookingService;
	
	@KafkaListener(topics=AppConstant.TOPIC_UBER_REQUESTS,groupId="uber_ride")
	public void listen(BookingRequestDTO event) {
        System.out.println("UberService received request: " + event);
        uberBookingService.processBookingRequest(event);
    }
	

}