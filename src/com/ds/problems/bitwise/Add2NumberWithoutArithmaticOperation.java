package com.ds.problems.bitwise;

public class Add2NumberWithoutArithmaticOperation {

	public int addNumbers (int a, int b) {
		while(b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}
	
	public static void main(String args[]) {
		Add2NumberWithoutArithmaticOperation add = new Add2NumberWithoutArithmaticOperation();
		System.out.println(add.addNumbers(8, 9));
	}
}
