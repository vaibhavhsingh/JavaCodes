package com.ds.problems.greedyalgo;

import java.util.Arrays;
import java.util.Comparator;

public class MaximalDisjointInterval {

	public int maximalIntervals(int arr[][]) {
		int count = 1;
		sortArray(arr, 1);
		int high = arr[0][1];
		for(int i=0; i< arr.length; i++) {
			if(high < arr[i][0]) {
				count++;
				high = arr[i][1];
			}
		}
		return count;
	}
	
	private void sortArray(int arr[][], int col){
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int a[], int b[]) {
				return a[col] > b[col] ? 1 : -1;
			}
		});
	}
	
	public static void main (String args[]) {
		int arr[][] = 
			{ 
				{ 2, 3 }, 
                { 1, 4 },
                { 8, 9 },
                { 4, 6 } 
            };
		
		MaximalDisjointInterval maximal = new MaximalDisjointInterval();
		System.out.println(maximal.maximalIntervals(arr));
	}
}
