package OOP;

public class ClassA{
	int a;
	
	ClassB cb = new ClassB();
	
	public void methodA() {
		System.out.println("Method A");
		
		
		cb.methodB();
	}
	
	public int Sum(int num) {
		int result = this.a + num;
		return result;
	}
	
	public static void main(String[] args) {
		ClassA ca = new ClassA();
		ca.methodA();
	}
}
