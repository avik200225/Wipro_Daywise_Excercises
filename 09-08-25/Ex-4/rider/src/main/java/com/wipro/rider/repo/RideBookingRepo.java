package com.wipro.rider.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.rider.entity.RideBooking;

@Repository
public interface RideBookingRepo extends JpaRepository<RideBooking, Long> {

}
