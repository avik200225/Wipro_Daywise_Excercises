package com.wipro.rider.dto;

public class BookingRequestDTO {
	
	String bookingId; 
    String riderId;
    String pickup;
    String dropLocation;
    
    
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
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
		return "BookingRequestDTO [riderBookingId=" + bookingId + ", riderId=" + riderId + ", pickup=" + pickup
				+ ", dropLocation=" + dropLocation + "]";
	}
    
    
    

}