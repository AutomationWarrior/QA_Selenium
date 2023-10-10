package OOP;

import java.security.PKCS12Attribute;
import java.util.Scanner;

public class PhanSo {
	// Properties
	int tuSo;
	int mauSo;
	
	// Constructor
	public PhanSo() {
		
	}
	
	public PhanSo(int tuSo, int mauSo) {
		this.tuSo = tuSo;
		this.mauSo = mauSo;
	}
	
	// Getter, Setter
	
		// Setter
	public void setTuSo(int tuSo) {
		// Gán giá trị từ tham số input cho biến instance
		this.tuSo = tuSo;
	}
	
	public void setMauSo(int mauSo) {
		this.mauSo = mauSo;
	}
	
		// Getter
	public int getTuSo(){
		return this.tuSo;
	}
	
	public int getMauSo() {
		return this.mauSo;
	}
	
	// Actions
	public void NhapPhanSo() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhap tu so: ");
		this.tuSo = scanner.nextInt();

		System.out.println("Nhap mau so: ");
		this.mauSo = scanner.nextInt();
	}
	
	public void InPhanSo() {
		System.out.println(this.tuSo +  "/" + this.mauSo);
	}
	
	public PhanSo CongPhanSo(PhanSo ps) {
//		PhanSo ketqua = new PhanSo();
//		ketqua.tuSo = this.tuSo * ps.mauSo + ps.tuSo * this.mauSo;
//		ketqua.mauSo = this.mauSo * ps.mauSo;
//		
//		int ucln = UCLN(ketqua.tuSo, ketqua.mauSo);
//		
//		ketqua.tuSo =  ketqua.tuSo / ucln;
//		ketqua.mauSo =  ketqua.mauSo / ucln;
//		
//		return ketqua;
		
		PhanSo result = new PhanSo();
		
		result.tuSo = (this.tuSo * ps.mauSo) + (this.mauSo * ps.tuSo);
		result.mauSo = this.mauSo * ps.mauSo;
		
		int ucln = UCLN(result.tuSo ,result.mauSo);
		
		result.tuSo = result.tuSo /ucln;
		result.mauSo = result.mauSo / ucln;
		
		return result;

	}
	
	public int UCLN(int a, int b) {
		int ucln = 1;
		for(int i = 1; i <= a && i <= b; i++) {
			if(a % i == 0 && b % i == 0) {
				ucln = i;
			}
		}
		return ucln;
	}
	
	public static void main(String[] args) {
		PhanSo ps1 = new PhanSo();
		PhanSo ps2 = new PhanSo();
		PhanSo ps3 = new PhanSo();
		PhanSo ps4 = new PhanSo(5, 6);
		
		
		System.out.println("Nhap phan so 1: ");
		ps1.NhapPhanSo();
		
		System.out.println("Nhap phan so 2: ");
		ps2.NhapPhanSo();
		
		System.out.println("Phan so 1: ");
		ps1.InPhanSo();

		System.out.println("Phan so 2: ");
		ps2.InPhanSo();
		
		
		ps3 = ps1.CongPhanSo(ps2);
		
		System.out.println("Ket qua la: ");
		ps3.InPhanSo();
	}
}
