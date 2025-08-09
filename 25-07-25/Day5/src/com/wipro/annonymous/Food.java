package com.wipro.annonymous;
public class Food {
	String foodName;
	String foodType;
	String Cuisine;
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getCuisine() {
		return Cuisine;
	}
	public void setCuisine(String cuisine) {
		Cuisine = cuisine;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	int price;
	
	public Food(String foodName, String foodType, String cuisine, int price) {
		super();
		this.foodName = foodName;
		this.foodType = foodType;
		Cuisine = cuisine;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", foodType=" + foodType + ","
				+ " Cuisine=" + Cuisine + ", price=" + price+ "]";
	}
}
