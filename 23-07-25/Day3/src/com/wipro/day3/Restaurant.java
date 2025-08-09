package com.wipro.day3;

public class Restaurant {
	String restaurantAddress;
	long contactNum;
	int avgOrders;
	
	public Restaurant(String restaurantAddress, long contactNum, int avgOrders) {
		super();
		this.restaurantAddress = restaurantAddress;
		this.contactNum = contactNum;
		this.avgOrders = avgOrders;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public long getContactNum() {
		return contactNum;
	}

	public void setContactNum(long contactNum) {
		this.contactNum = contactNum;
	}

	public int getAvgOrders() {
		return avgOrders;
	}

	public void setAvgOrders(int avgOrders) {
		this.avgOrders = avgOrders;
	}
	/*The toString() method returns the string itself. This method may seem redundant,
	  but its purpose is to allow code that is treating the string as a more generalized
	  object to know its string value without casting it to String type.
	 */
	@Override
	public String toString() {
		return "Restaurant [restaurantAddress=" + restaurantAddress + ", contactNum=" + contactNum + ","
				+ " avgOrders="+ avgOrders + "]";
	}
}
