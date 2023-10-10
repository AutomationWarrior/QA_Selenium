package OOP;

public class JeepCar {

	String company;
	int speed;
	
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
