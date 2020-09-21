package com.ds.problems.bitwise;

public class SubtractOneWithoutArithmatic {

	public int subtractOneWithoutArithmaticOperation(int number) {
		int m = 1;
		while(!((number & m) > 0)) {
			number = number ^ m;
			m = m << 1;
		}
		number = number ^ m;
		return number;
	}
	
	public static void main(String args[]) {
		int number = 8;
		SubtractOneWithoutArithmatic s = new SubtractOneWithoutArithmatic();
		System.out.println(s.subtractOneWithoutArithmaticOperation(number));
	}
}
