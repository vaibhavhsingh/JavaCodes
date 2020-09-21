package com.ds.problems.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This is also known as Kadane's algorithm
 * 
 * @author vaibhavsingh
 *
 */
public class MaximumContiguousSumOfSubArray {

	public int maxContiguousSumOfSubArray(int arr[]) {
		int maxValue = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
			
			if(maxValue < sum) {
				maxValue = sum;
			}
			
			if(sum < 0) {
				sum=0;
			}
		}
		return maxValue;
	}
	public static void main(String args[]) {
		MaximumContiguousSumOfSubArray m = new MaximumContiguousSumOfSubArray();
		int arr[] = {5, -6, 4, 6, -3, 6, 9, 0};
		System.out.println(m.maxContiguousSumOfSubArray(arr));
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		System.out.println(m.maxContiguousSumOfSubArray(a));
		
		Map<Integer, Integer> map = new HashMap<>();
		for(Entry<Integer,Integer> entry : map.entrySet()) {
			
		}
	}
}
