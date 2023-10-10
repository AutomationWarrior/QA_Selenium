package OOP;

public class Bank {

	public double money;

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	
	public static void main(String[] args) {
		Bank b = new Bank();
		b.money = 1000;
	}
	


}
