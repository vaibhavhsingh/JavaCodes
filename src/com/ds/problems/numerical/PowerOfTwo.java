package com.ds.problems.numerical;

import com.ds.problems.bitwise.CountSetBitsInNumber;

/**
 * Program to find whether a no is power of two
 * 
 * Given a positive integer, write a function to find if it is a power of two or
 * not.
 * 
 * @author vaibhavsingh
 *
 */
public class PowerOfTwo {
	/*
	 * This approach is valid for positive integers
	 */
	public boolean validateIsPowerOf2Approach1(int number) {
		int count = new CountSetBitsInNumber().countSetBits(number);
		// Above method counts the number of bits that are set to 1.
		// For any number which is power of 2 its binary representation will have only
		// single bit set to 1
		// e.g. 8 ==> 1000, 16 ==> 10000 etc
		return count == 1 ? true : false;
	}

	public boolean validateIsPowerOf2Approach2(int number) {
		// Here the approach is number -1 will have all the bits set to 1. Doing &
		// operation with original number will turn it to 0
		return number != 0 && ((number & (number - 1)) == 0);
	}

	public static void main(String args[]) {
		PowerOfTwo power = new PowerOfTwo();
		System.out.println("200=" + power.validateIsPowerOf2Approach1(200));
		System.out.println("200=" + power.validateIsPowerOf2Approach2(200));
		System.out.println("16=" + power.validateIsPowerOf2Approach2(16));
		System.out.println("-8=" + power.validateIsPowerOf2Approach2(-8));
	}

}
