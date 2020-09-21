package com.ds.problems.bitwise;

/**
 * Write a program to multiple a number with 3.5 and return the integer part of it
 * 
 * e.g. 
 * input = x
 * x = 2
 * Output = 7
 * 
 * x = 5
 * output = 17
 * You should not use %, /, * operators
 * 
 * @author vaibhavsingh
 *
 */
public class MultiplyBy3Point5 {

	public static int multiplyBy3point5(int number) {
		return (number << 1) + number + (number >> 1);
	}
	
	public static void main(String args[]) {
		System.out.println(multiplyBy3point5(2));
		System.out.println(multiplyBy3point5(5));
		System.out.println(multiplyBy3point5(6));
	}
}
