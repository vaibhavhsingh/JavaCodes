package com.ds.problems.strings;

public class LongestCommonSubsequenceProblem {

	public int lcs(char[] s1, char[] s2, int m, int n) {
		if(m==0 || n==0) {
			return 0;
		}
		
		if(s1[m-1] == s2[n-1]) {
			return 1 + lcs (s1, s2, m-1, n-1);
		}
		return Math.max(lcs(s1, s2, m-1, n), lcs(s1, s2, m, n-1));
	}
	
	public static void main(String args[]) {
		LongestCommonSubsequenceProblem l = new LongestCommonSubsequenceProblem();
		
		String s1 = "ACGTHBM";
		String s2 = "CGBM";
		
		char []arr1 = s1.toCharArray();
		char []arr2 = s2.toCharArray();
		
		System.out.println(l.lcs(arr1, arr2, arr1.length, arr2.length));
		
	}
}
