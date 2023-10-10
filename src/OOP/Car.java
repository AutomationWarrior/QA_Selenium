package OOP;

public class Car {
	// Properties
	String company;
	int speed;

	// Constructor
	// Constructor ko tham số - Mặc định
	public Car() {

	}

	// Getter - Setter

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	// Phương thức riêng của class
	public void ShowInfo() {
		System.out.println("Company: " + company + " Speed: " + speed);
	}

}
