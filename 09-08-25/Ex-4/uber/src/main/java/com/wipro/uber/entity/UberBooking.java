package com.wipro.uber.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "uber_booking")
public class UberBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "booking_id")
	String bookingId; 
    
	@Column(name = "rider_booking_id")
	Long riderBookingId; 
    
	@Column(name = "status")
	String status; 
    
	@Column(name = "rider_id")
	String riderId;
    
	@Column(name = "pick_up")
	String pickup;
    
	@Column(name = "drop_location")
	String dropLocation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Long getRiderBookingId() {
		return riderBookingId;
	}

	public void setRiderBookingId(Long riderBookingId) {
		this.riderBookingId = riderBookingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRiderId() {
		return riderId;
	}

	public void setRiderId(String riderId) {
		this.riderId = riderId;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	@Override
	public String toString() {
		return "UberBooking [id=" + id + ", bookingId=" + bookingId + ", riderBookingId=" + riderBookingId + ", status="
				+ status + ", riderId=" + riderId + ", pickup=" + pickup + ", dropLocation="
				+ dropLocation + "]";
	}
}