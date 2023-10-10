package OOP;

public class Rectangle {

	// I. Properties
	double length;
	double width;

	// II. Actions - method
	public double P() {
		double p = (length + width) * 2;
		return p;
	}

	public double S() {
		double s = length * width;
		return s;
	}

	// III. Constructor - hàm khởi tạo - giúp khởi tạo đối tượng
	// 	1.1 Ko có kiểu trả về
	//  1.2 Tên hàm (tên method) == Tên class 
	
	// Constructor mặc định - Constructor ko có tham số
	public Rectangle() {

	}
	
	// Constructor có tham số
	public Rectangle(int a, int b) {
		length = a;
		width = b;
	}
	
	public Rectangle(int a) {
		length = a;
	}
	
	// IV. Setter / Getter
	
	public void setLength(double a) {
		if(a > 0) {
			length = a;
		}
	}
	
	public void setWidth(double a) {
		if(a > 0) {
			width = 0;
		}
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle();

//		rec1.length = -5;
//		rec1.width = -2;
		
		rec1.setLength(-5);
		rec1.setWidth(-2);
		
//		System.out.println("Rec1.length: " + rec1.length);
//		System.out.println("Rec1.width: " + rec1.width);

		System.out.println("Rec1.length: " + rec1.getLength());
		System.out.println("Rec1.width: " + rec1.getWidth());
		
		double p1 = rec1.P();
		double s1 = rec1.S();

		System.out.println("P1 = " + p1);
		System.out.println("S1 = " + s1);
		
//		Rectangle rec2 = new Rectangle(-1,-3);
//		
//		System.out.println("Rec2.length = " + rec2.length);
//		System.out.println("Rec2.width = " + rec2.width);
//		
//		double p2 = rec2.P();
//		double s2 = rec2.S();
//		
//		System.out.println("P2 = " + p2);
//		System.out.println("S2 = " + s2);

		
	}

//	public static void main(String[] args) {
//		int dai;
//		int rong;
//		int dienTich;
//		Rectangle rec1 = new Rectangle();
//		Rectangle rec2 = new Rectangle();
//	}
}
