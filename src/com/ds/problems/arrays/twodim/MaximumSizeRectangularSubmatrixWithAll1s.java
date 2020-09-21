package com.ds.problems.arrays.twodim;

import com.ds.problems.questack.MaxHistogram;

public class MaximumSizeRectangularSubmatrixWithAll1s {

	public int findMaximumSizeRectangularSubmatrixWithAll1(int arr[][]) {
		int temp[] = new int[arr[0].length];
		int maxArea = 0;
		int area = 0;
		
		MaxHistogram histogram = new MaxHistogram();
		for (int i=0;i<arr.length; i++) {
			for (int j=0;j<temp.length;j++) {
				if(arr[i][j] == 0) {
					temp[j] =  0;
				} else {
					temp[j] += arr[i][j];
				}
			}
			area = histogram.findMaxHistogram(temp);
			
			if(maxArea < area) {
				maxArea = area;
			}
		}
		return maxArea;
	}
	
	public static void main(String args[]) {
		int arr[][] = {
				{ 1, 1, 1 },
				{ 0, 1, 1 },
		        { 1, 0, 0 }
				};
		MaximumSizeRectangularSubmatrixWithAll1s maxSizeRectangle = new MaximumSizeRectangularSubmatrixWithAll1s();
		System.out.println(maxSizeRectangle.findMaximumSizeRectangularSubmatrixWithAll1(arr));
	}
}
