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

	

	public void run() {
//		menu();
//		createFoodTrucks(kb);
		while (foodTrucks.length > 0) {
			menu();
			createFoodTrucks(kb);
			String select = kb.next();
			if (select.equals("1")) {
				listFoodTrucks();
			} else if (select.equals("2")) {
				averageRatings();
			} else if (select.equals("3")) {
				listHighestRatedTruck();
			} else if (select.equals("4")) {
				break;
			} else {
				System.out.println("Invalid response. Please Try again.");
			}
			System.out.println();
			continue;
		}
		
	
	}
	public void createFoodTrucks(Scanner kb) {
		for (int i = 0; i < foodTrucks.length; i++) {
			System.out.println("Enter your food truck's name: ");
			String name = kb.next();
			if (name.equalsIgnoreCase("exit")) {
				System.out.println("Completed Food Truck input. Continue with the next menu option");
				break;
			}
			System.out.println("Enter your type of food: ");
			String foodType = kb.next();
			System.out.println("Enter your Food Truck rating 1-5: ");
			int rating = kb.nextInt();
//			kb.nextLine();
			foodTrucks[i] = new FoodTrucks(name, foodType, rating);
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
		double sum = 0;
		int count = 0;
		for (FoodTrucks truck : foodTrucks) {
			if (truck == null) {
				break;
			}
			sum += truck.getRating();
			count++;
		}
		System.out.println("Average Rating: " + (Math.round((sum / count) * 10) / 10.0));
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
			System.out.printf("The highest rated food truck is "+ "%.2f",highestRating);
	}
	}
}
