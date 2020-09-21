package com.ds.problems.arrays;

/**
 * Find max sum of k consecutive elements of a an array
 * 
 * Input  : arr[] = {100, 200, 300, 400}
 *         k = 2
 * Output : 700
 *
 * Use Window Sliding Technique
 * 
 * @author vaibhavsingh
 *
 */
public class SlidingWindowMaxSumOfKConsecutiveElements {
	
	public int findMaxSumOfKConsecutiveElements(int arr[],  int k) {
		int windowSum = 0;
		for(int i=0; i<k; i++) {
			windowSum += arr[i];
		}
		
		int maxSum = windowSum;
		
		for(int i=k;i<arr.length;i++) {
			windowSum += arr[i] - arr[i-k];
			maxSum = Math.max(windowSum, maxSum);
		}
		
		return maxSum;
	}
	public static void main (String args[]) {
		SlidingWindowMaxSumOfKConsecutiveElements s = new SlidingWindowMaxSumOfKConsecutiveElements();
		int arr[] = {4, 1, 6, 0, 3, 12, 3};
		int k = 4;
		
		System.out.println(s.findMaxSumOfKConsecutiveElements(arr, k));
		
	}

}