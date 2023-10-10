package HackBank;

import OOP.ClassB;

public class HackBank extends ClassB{
	
	ClassB cb = new ClassB();
	public void methodHackBank() {
		System.out.println("Hack Bank");
//		cb.methodB();

		
		
		
	}
	
	public static void main(String[] args) {
		HackBank hb1 = new HackBank();
		hb1.methodHackBank();
	}
}
