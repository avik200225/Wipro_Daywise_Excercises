package com.wipro.uber.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.uber.entity.UberBooking;

@Repository
public interface UberBookingRepo extends JpaRepository<UberBooking, Long> {
	
	UberBooking findByBookingId(String bookingId);
}