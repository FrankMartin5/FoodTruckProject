package com.skilldistillery.foodtrucks;

public class FoodTrucks {
	// F i e l d s
	private static int foodTruckId = 0;
	private int nextFoodTruckId;
	private String name;
	private String foodType;
	private double rating;
	// C o n s t r u c t o r s
	public FoodTrucks() {
	}
	public FoodTrucks(String name, String foodType, double rating) {
		this.foodType = foodType;
		this.name = name;
		this.rating = rating;
		foodTruckId++;
		nextFoodTruckId = foodTruckId;
	}
	
	
	// M e t h o d s
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	@Override
	public String toString() {
		return "FoodTrucks [nextFoodTruckId=" + nextFoodTruckId + ", name=" + name + ", foodType=" + foodType
				+ ", rating=" + rating + "]";
	}
	
	
}
