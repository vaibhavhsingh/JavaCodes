package com.ds.problems.strings;

public class FindPalindrome {

	public boolean isPalindrome(int n) {
		int temp = n;
		int d = 0;
		int s = 0;

		while (n > 0) {
			d = n % 10;
			s = s * 10 + d;
			n = n / 10;
		}

		return temp == s;
	}

	public static void main(String args[]) {
		FindPalindrome f = new FindPalindrome();
		System.out.println("7=" + f.isPalindrome(7));
		System.out.println("107=" + f.isPalindrome(107));
		System.out.println("171=" + f.isPalindrome(171));
		System.out.println("23355332=" + f.isPalindrome(23355332));

	}
}
