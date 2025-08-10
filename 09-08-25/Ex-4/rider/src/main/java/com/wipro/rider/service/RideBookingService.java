package com.wipro.rider.service;

import com.wipro.rider.dto.BookingResponseDTO;
import com.wipro.rider.entity.RideBooking;

public interface RideBookingService {
	
	RideBooking createBooking(RideBooking booking);
	
	void handleBookingResponse(BookingResponseDTO response);
}
