package com.wipro.uber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.uber.entity.UberBooking;
import com.wipro.uber.service.UberBookingService;

@RestController
@RequestMapping("/uber")
public class UberBookingController {

	@Autowired
	UberBookingService uberBookingService;
	
	
	@GetMapping("/bookings")
    public List<UberBooking> getAllBookings() {
        return uberBookingService.getAllBookings();
    }

    
    @GetMapping("/bookings/{id}")
    public UberBooking getBookingById(@PathVariable Long id) {
        return uberBookingService.getBookingById(id);
    }
	
}