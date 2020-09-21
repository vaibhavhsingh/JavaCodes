package com.ds.problems.bitwise;

public class CountSetBitsInNumber {

	public int countSetBits(int number) {
		int count = 0;
		while(number > 0) {
			//  20 => 1 0 1 0 0
			//   1 => 0 0 0 0 1
			// Doing & operation will convert it to 0. Then performing right shift number will be / 2 and iteratively doing & operation. For matching 1s it will return 1 and there by increasing count in the end total count of numbers will be found
			count += number&1;
			number >>= 1;
		}
		return count;
	}
	public static void main(String args[]) {
		int number = 20;
		System.out.println(new CountSetBitsInNumber().countSetBits(number));
		

		
	}
}
