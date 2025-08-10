package com.wipro.rider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "ride_booking")
public class RideBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "ride_id")
	String riderId;
	
	@Column(name = "pick_up")
    String pickup;
    
	@Column(name = "drop_location")
    String dropLocation;
    
	@Column(name = "status")
    String status;          
    
	@Column(name = "booking_id")
    String bookingId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "RideBooking [id=" + id + ", riderId=" + riderId + ", pickup=" + pickup + ", dropLocation="
				+ dropLocation + ", status=" + status + ", bookingId=" + bookingId + "]";
	}	
}