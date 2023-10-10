package JavaForTester;

import java.util.Scanner;

public class CarOOP {
	//Global -  Biến instance - Properties
	String company;
	int speed;
	double price;

	// Actions
	public void ShowData() {
		System.out.println("Company: " + company);
		System.out.println("Speed: " + speed);
	}

	public void BuyCar() {
		System.out.println("Price is: " + price + " for " + company);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CarOOP honda = new CarOOP();
		CarOOP jeep = new CarOOP();
		CarOOP bmw = new CarOOP();

		honda.company = "Honda";
		honda.speed = 50;
		honda.price = 1000;
		
		jeep.company = "Jeep";
		jeep.speed = 100;
		jeep.price =  2000;
		
		bmw.company = "BMW";
		bmw.speed = 300;
		bmw.price = 2000;
		
		System.out.println("Honda");
		honda.ShowData();
		honda.BuyCar();
		
		System.out.println("Jeep");
		jeep.ShowData();
		jeep.BuyCar();
		
		System.out.println("BMW");
		bmw.ShowData();
		bmw.BuyCar();
		
		// Bike:  group 
		String company = "Bike";
		int speed = 0;
		double price = 500;
		
//		ShowData(company,speed);
	}
}
