package OOP;

public class HondaCar extends Car {

	String hondaMachine;
	String hondaColor;

	public String getHondaMachine() {
		return hondaMachine;
	}

	public void setHondaMachine(String hondaMachine) {
		this.hondaMachine = hondaMachine;
	}

	public String getHondaColor() {
		return hondaColor;
	}

	public void setHondaColor(String hondaColor) {
		this.hondaColor = hondaColor;
	}

	public void ShowInfoHonda() {
		System.out.println("Company: " + this.company + " Speed: " + this.speed + " Machine: " + this.hondaMachine + " Color: " + this.hondaColor);
	}

}
