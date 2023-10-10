package OOP;

public class CarProgram {
	public static void main(String[] args) {
		Car car = new Car();
		HondaCar hondaCar = new HondaCar();
		JeepCar jeepCar = new JeepCar();
		
		
		hondaCar.setCompany("Honda");
		hondaCar.setSpeed(60);
		hondaCar.setHondaMachine("Machine-Honda-1");
		hondaCar.setHondaColor("Red");
		
		hondaCar.ShowInfoHonda();
		
	}
}
