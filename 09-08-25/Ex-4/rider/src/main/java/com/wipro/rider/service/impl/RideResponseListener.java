package com.wipro.rider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wipro.rider.dto.BookingResponseDTO;
import com.wipro.rider.service.RideBookingService;
import com.wipro.rider.util.AppConstant;

@Service
public class RideResponseListener {
	
	@Autowired
	RideBookingService rideBookingService;
	
	@KafkaListener(topics=AppConstant.TOPIC_RIDER_RESPONSES, groupId="ride_uber")
	public void listen(BookingResponseDTO dto) {
		System.out.println("RiderService received response: " + dto);
		rideBookingService.handleBookingResponse(dto);
	}

}