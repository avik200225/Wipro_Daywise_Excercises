package com.wipro.uber.service;

import java.util.List;

import com.wipro.uber.dto.BookingRequestDTO;
import com.wipro.uber.entity.UberBooking;

public interface UberBookingService {
	
	void processBookingRequest(BookingRequestDTO dto);
	
	List<UberBooking> getAllBookings();
    UberBooking getBookingById(Long id);

}