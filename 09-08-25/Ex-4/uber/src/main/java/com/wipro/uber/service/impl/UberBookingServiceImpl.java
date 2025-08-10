package com.wipro.uber.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

import com.wipro.uber.dto.BookingRequestDTO;
import com.wipro.uber.dto.BookingResponseDTO;
import com.wipro.uber.entity.UberBooking;
import com.wipro.uber.repo.UberBookingRepo;
import com.wipro.uber.service.UberBookingService;
import com.wipro.uber.util.AppConstant;

@Service
public class UberBookingServiceImpl implements UberBookingService {
	
	@Autowired
	UberBookingRepo uberBookingRepo;
	
	@Autowired
	KafkaTemplate<String, BookingResponseDTO> kafkaTemplate;

	@Override
	public void processBookingRequest(BookingRequestDTO dto) {
		
		String bookingId = "UB-" + UUID.randomUUID().toString().substring(0, 8);

        UberBooking booking = new UberBooking();
        booking.setBookingId(bookingId);
        

        booking.setStatus("ACCEPTED");
        booking.setRiderId(dto.getRiderId());
        booking.setPickup(dto.getPickup());
        booking.setDropLocation(dto.getDropLocation());

        UberBooking savedBooking = uberBookingRepo.save(booking);

        
        savedBooking.setRiderBookingId(savedBooking.getId());
        uberBookingRepo.save(savedBooking);  

        BookingResponseDTO response = new BookingResponseDTO();
        response.setRiderBookingId(savedBooking.getId());  // Long
        response.setBookingId(bookingId);
        response.setStatus("ACCEPTED");

        kafkaTemplate.send(AppConstant.TOPIC_RIDER_RESPONSES, response);


	}

	@Override
	public List<UberBooking> getAllBookings() {
		
		return uberBookingRepo.findAll();
	}

	@Override
	public UberBooking getBookingById(Long id) {
		
		return uberBookingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found: " + id));
	}

}