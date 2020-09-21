package com.ds.problems.arrays;

/**
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * 
 * https://www.geeksforgeeks.org/java-program-to-print-distinct-permutations-of-a-string/?ref=rp
 * 
 * @author vaibhavsingh
 *
 */
public class PrintPermutationsOfAString {
	
	public void permute(String str, int start, int end) {
		if(start == end) {
			System.out.println(str);
		} else {
			for(int i=start;i<=end;i++) {
				str = swap(str, start, i);
				permute(str, start+1, end);
				str = swap(str, start, i); // this call is for backtracking
			}
		}
	}
	
	public String swap(String str, int i, int j) {
		char arr[] = str.toCharArray();
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
		return String.valueOf(arr);
	}
	
	public static void main (String args[]) {
		PrintPermutationsOfAString p = new PrintPermutationsOfAString();
		String str = "ABC";
		
		p.permute(str, 0, str.length()-1);
	}
}
