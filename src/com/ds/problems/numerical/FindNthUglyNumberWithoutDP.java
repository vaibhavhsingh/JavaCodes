package com.ds.problems.numerical;

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
 * Given a number n, the task is to find n’th Ugly number.
 * 
 * Examples:
 * Input  : n = 7
 * Output : 8
 * 
 * Input  : n = 10
 * Output : 12
 * 
 * Input  : n = 15
 * Output : 24
 * 
 * Input  : n = 150
 * Output : 5832
 * 
 * @author vaibhavsingh
 *
 */
public class FindNthUglyNumberWithoutDP {

	private int maxDivide(int number, int divisor) {
		while(number % divisor == 0) {
			number /= divisor;
		}
		return number;
	}
	
	private boolean isUgly(int number) {
		number = maxDivide(number, 2);
		number = maxDivide(number, 3);
		number = maxDivide(number, 5);
		
		return number == 1 ? true : false;
	}
	
	public int getNthUglyNumber(int n) {
		int i=1;
		int number = 1;
		while(i < n) {
			number++;
			if(isUgly(number)) {
				i++;
			}
		}
		return number;
	}
	
	public static void main(String args[]) {
		FindNthUglyNumberWithoutDP ugly = new FindNthUglyNumberWithoutDP();
		System.out.println("2nd Ugly No is "+ugly.getNthUglyNumber(2));
		System.out.println("3rd Ugly No is "+ugly.getNthUglyNumber(3));
		System.out.println("4th Ugly No is "+ugly.getNthUglyNumber(4));
		System.out.println("10th Ugly No is "+ugly.getNthUglyNumber(10));
	}
}
