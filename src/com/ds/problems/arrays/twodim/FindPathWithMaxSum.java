package com.ds.problems.arrays.twodim;

import java.util.Stack;

/**
 * Given a 2 dimensional array of numbers. You need to traverse from bottom left corner to top right corner and find out the path which will lead to maximum sum
 * 
 * e.g.
 * int arr[][] = {
 * 					{0, 0, 4, 2, 7},
 *  					{0, 0, 1, 5, 9},
 *  					{0, 0, 4, 6, 0},
 *  					{0, 1, 3, 5, 8}
 * 				 } 
 * 	MaxPathSum = 34(0+1+3+5+8+0+9+7)
 * @author vaibhavsingh
 *
 */
public class FindPathWithMaxSum {

	public int findMaxSum(int arr[][]) {
		int row = arr.length;
		int col = arr[0].length;
		int sum = arr[row-1][0];
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[row-1][0]);
		/*for(int i=row-1; i>=0; i--) {
			for(int j=0; j<col;) {
				if(i==0 && j<col-1) {
					stack.push(arr[i][j+1]);
					sum += arr[i][j+1];
					j++;
				}
				if(j==col-1 && i>0) {
					stack.push(arr[i-1][j]);
					sum += arr[i-1][j];
					i--;
				}
				if(j<col-1 && i>0) {
					if(arr[i-1][j] < arr[i][j+1]) {
						stack.push(arr[i][j+1]);
						sum+=arr[i][j+1];
						j++;
					} else if(arr[i-1][j] > arr[i][j+1]) {
						stack.push(arr[i-1][j]);
						sum+=arr[i-1][j];
						i--;
					}
				}
			}*/
		int i = row-1;
		int j = 0;
		while(i>0 || j < col-1) {
			if(i==0 && j<col-1) {
				stack.push(arr[i][j+1]);
				sum += arr[i][j+1];
				j++;
			}
			if(j==col-1 && i>0) {
				stack.push(arr[i-1][j]);
				sum += arr[i-1][j];
				i--;
			}
			if(j<col-1 && i>0) {
				if(arr[i-1][j] < arr[i][j+1]) {
					stack.push(arr[i][j+1]);
					sum+=arr[i][j+1];
					j++;
				} else if(arr[i-1][j] > arr[i][j+1]) {
					stack.push(arr[i-1][j]);
					sum+=arr[i-1][j];
					i--;
				}
			}
		}
		return sum;
	}
	
	public static void main(String args[]) {
		FindPathWithMaxSum pathSum = new FindPathWithMaxSum();
		
		int arr[][] = {
	  					{0, 0, 4, 2, 7},
	   					{0, 0, 1, 5, 9},
	   					{0, 0, 4, 6, 0},
	   					{0, 1, 3, 5, 8}
	  				 }; 
		System.out.println(pathSum.findMaxSum(arr));
	}
}
