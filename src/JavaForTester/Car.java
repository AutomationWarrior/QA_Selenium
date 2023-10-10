package JavaForTester;

public class Car {

	public static void main(String[] args) {
		// Honda
		String hondaCompany = "Honda";
		int hondaSpeed = 50;
		double hondaPrice = 1000;

		// Jeep
		String jeepCompany = "Jeep";
		int jeepSpeed = 100;
		double jeepPrice = 2000;

		System.out.println("Jeep");
		ShowData(jeepCompany, jeepSpeed);
		BuyCar(jeepCompany, jeepPrice);

		// BMW
		String bmwCompany = "BMW";
		int bmwSpeed = 200;
		double bmwPrice = 3000;

		System.out.println("BMW");
		ShowData(bmwCompany, bmwSpeed);
		BuyCar(bmwCompany, bmwPrice);
		
		
		System.out.println("Honda");
		ShowData(jeepCompany, hondaSpeed);
		BuyCar(hondaCompany, hondaPrice);
		
		// Giant
		String giantCompany = "Giant";
		int giantSpeed = 0;
		double giantPrice = 500;
		
		ShowData(giantCompany, giantSpeed);
		BuyCar(giantCompany, giantPrice);
	}

	public static void ShowData(String company, int speed) {
		System.out.println("Company: " + company);
		System.out.println("Speed: " + speed);
	}

	public static void BuyCar(String company, double price) {
		System.out.println("Price is: " + price + " for " + company);
	}
}
