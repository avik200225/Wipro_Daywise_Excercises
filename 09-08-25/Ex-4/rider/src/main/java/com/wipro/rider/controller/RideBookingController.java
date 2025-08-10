package com.wipro.rider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.rider.entity.RideBooking;
import com.wipro.rider.service.RideBookingService;

@RestController
@RequestMapping("/ride")
public class RideBookingController {
	
	@Autowired
	RideBookingService rideBookingService;
	
	
	@PostMapping
    public ResponseEntity<RideBooking> createRide(@RequestBody RideBooking booking) {
        RideBooking saved = rideBookingService.createBooking(booking);
        return ResponseEntity.ok(saved);
    }
	
}