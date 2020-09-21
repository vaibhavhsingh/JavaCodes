package com.ds.problems;

import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * Input: arr[] = {2, 0, 2} Output: 2 Explanation: The structure is like below 
 * |  | 
 * |  | 
 * --------
 * 
 * Input: arr[] = {3, 0, 2, 0, 4} Output: 7 Explanation: The structure is like
 * below
 * 
 *       | 
 * |     | 
 * |  |  | 
 * |  |  | 
 * -------
 * 
 * @author vaibhavsingh
 *
 */
public class TrapingWaterProblem {

	public int findTrappedWater(int arr[]) {
		int size = arr.length;
		int left[] = new int[size];
		int right[] = new int[size];
		int waterSize = 0;
		
		// Fill left array 
		left[0] = arr[0];
		for(int i=1; i<size; i++) {
			left[i] = Math.max(left[i-1], arr[i]);
		}
		
		// Fill right array 
		right[size-1] = arr[size-1];
		for(int i=size-2; i>=0; i--) {
			right[i] = Math.max(right[i+1], arr[i]);
		}
		
		// Calculate the accumulated water element by element 
        // consider the amount of water on i'th bar, the 
        // amount of water accumulated on this particular 
        // bar will be equal to min(left[i], right[i]) - arr[i]
		for(int i=0;i<size;i++) {
			waterSize += Math.min(left[i], right[i]) - arr[i];
		}
		return waterSize;
	}

	public static void main(String args[]) {
		TrapingWaterProblem t = new TrapingWaterProblem();
		int arr[] = {3, 0, 2, 0, 4};
		System.out.println(Arrays.asList(arr));
		System.out.println("Water Trapped = "+t.findTrappedWater(arr));
	}

}
