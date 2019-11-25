package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {

	FoodTrucks[] foodTrucks;
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}

	public FoodTruckApp() {
		this.foodTrucks = new FoodTrucks[5];
	}

	public void menu() {
		System.out.println("********************************");
		System.out.println("*Welcome to the Food Truck App!*");
		System.out.println("********************************");
		System.out.println("*     1: List food trucks      *");
		System.out.println("*     2: See average ratings   *");
		System.out.println("*     3: See highest ratings   *");
		System.out.println("*     4:       Exit            *");
		System.out.println("********************************");
	}

	public void createFoodTrucks(Scanner kb) {
		for (int i = 0; i < foodTrucks.length; i++) {
			System.out.println("Enter your food truck's name: ");
			String name = kb.nextLine();
			if (name.equalsIgnoreCase("exit")) {
				System.out.println("Completed Food Truck input.");
				break;
			}
			System.out.println("Enter your type of food: ");
			String foodType = kb.nextLine();
			System.out.println("Enter your Food Truck rating 1-5: ");
			int rating = kb.nextInt();
			kb.nextLine();
			foodTrucks[i] = new FoodTrucks(name, foodType, rating);
		}
	}

	public void run() {
		menu();
		createFoodTrucks(kb);
		while (foodTrucks.length > 0) {
			int select = kb.nextInt();
			if (select == 1) {
				listFoodTrucks();
			} else if (select == 2) {
				averageRatings();
			} else if (select == 3) {
				listHighestRatedTruck();
			} else if (select == 4) {
				break;
			} else {
				System.out.println("Invalid response. Please Try again.");
			}
			System.out.println();
		}

	}

	public void listFoodTrucks() {
		for (FoodTrucks foodTrucks2 : foodTrucks) {
			if (foodTrucks2 == null) {
				break;
			}
			System.out.println(foodTrucks2.toString());
		}
	}
	public void averageRatings() {
		double finalMultiple = 0;
		int numOfTrucks = 0;
		double finalAvg = 0;
		for (FoodTrucks foodTrucks2 : foodTrucks) {
			if (foodTrucks2 != null) {
				break;
			}
			finalMultiple += foodTrucks2.getRating();
			numOfTrucks++;
		}
		finalAvg = finalMultiple / numOfTrucks;
		System.out.println("The average rating is"+ finalAvg);
	}
	public void listHighestRatedTruck() {
		int numOf = 0;
		double highestRating = Integer.MIN_VALUE;
		for (FoodTrucks foodTrucks2 : foodTrucks) {
			if(foodTrucks2 == null) {
				break;
			}
			if (highestRating == foodTrucks2.getRating()) {
				numOf++;
			}
			if (highestRating < foodTrucks2.getRating()) {
				highestRating = foodTrucks2.getRating();
				numOf = 0;
			} else {
				continue;
			}
			
	}
	}
}
