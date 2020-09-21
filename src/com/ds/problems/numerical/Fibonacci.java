package com.ds.problems.numerical;

public class Fibonacci {

	public static int getNthFib(int n) {
	    // Write your code here.
			int t1 = 0;
			int t2 = 1;
			if(n == 1 ) {
				return t1;
			} else if(n == 2) {
				return t2;
			} else {
				int i = 3;
				int number = 0;
				while(i <= n) {
					number = t1 + t2;
					t1 = t2;
					t2 = number;
					i++;
				}
				return number;
			}
	  }
	
	public static void main(String args[]) {
		System.out.println("5->"+getNthFib(5));
		System.out.println("1->"+getNthFib(1));
		System.out.println("2->"+getNthFib(2));
		System.out.println("15->"+getNthFib(15));
	}
}
