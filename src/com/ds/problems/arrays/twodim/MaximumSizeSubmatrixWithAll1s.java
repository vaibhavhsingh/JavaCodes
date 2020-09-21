package com.ds.problems.arrays.twodim;

/**
 * Maximum size square sub-matrix with all 1s
 * 
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 * e.g.
 * 
 * 0 1 1 0 1
 * 1 1 0 1 0
 * 0 1 1 1 0
 * 1 1 1 1 0
 * 1 1 1 1 1
 * 0 0 0 0 0
 * 
 * Above problem is similar to 
 * https://www.geeksforgeeks.org/largest-possible-square-submatrix-with-maximum-and-value/?ref=rp
 * 
 * @author vaibhavsingh
 *
 */
public class MaximumSizeSubmatrixWithAll1s {

	public int[][] maxSizeSubMatrixWithAll1(int arr[][]){
		int arrTemp[][] = new int[arr.length][arr[0].length];
		
		for(int i=0; i<arr.length;i++) {
			arrTemp[i][0] = arr[i][0]; 
		}
		
		for(int j=0; j<arr[0].length;j++) {
			arrTemp[0][j] = arr[0][j]; 
		}
		
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<arr[i].length;j++) {
				if(arr[i][j] == 1) {
					arrTemp[i][j] = Math.min(arrTemp[i-1][j-1], Math.min(arrTemp[i-1][j], arrTemp[i][j-1])) + 1;  
				} else {
					arrTemp[i][j] = 0;
				}
			}
		}
		print(arrTemp);
		int maxValue = 0; int x=0; int y=0;
		for(int i=0;i<arrTemp.length;i++) {
			for(int j=0;j<arrTemp[i].length;j++) {
				if(maxValue < arrTemp[i][j]) {
					maxValue = arrTemp[i][j];
					x = i;
					y = j;
				}
			}
		}
		
		int maxSubArrayWithAll1 [][] = new int[maxValue][maxValue];
		int a =0, b=0;
		for(int i=x-maxValue+1; i<=x; i++) {
			for(int j=y-maxValue+1; j<=y; j++) {
				maxSubArrayWithAll1[a][b] = arr[i][j];
				b++;
			}
			a++;
			b=0;
		}
		return maxSubArrayWithAll1;
	}
	
	public void print(int arr[][]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j] + " ");		
			}
			System.out.println();
		}
		System.out.println("\n");
	}
	public static void main(String[] args) { 
		MaximumSizeSubmatrixWithAll1s matrix = new MaximumSizeSubmatrixWithAll1s();
        int arr[][] = {{0, 1, 1, 0, 1},  
                    {1, 1, 0, 1, 0},  
                    {0, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 1}, 
                    {0, 0, 0, 0, 0}}; 
              
       // matrix.print(matrix.maxSizeSubMatrixWithAll1(arr)); 
        
        int arr1[][] = {
                      	  {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                    		  {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    		  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    		  {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                    		  {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                    		  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    		  {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                    		  {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                    		  {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                    		  {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
                    		  {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    		  {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    		  {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                    		  {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                    		  {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1}
                    		};
        matrix.print(matrix.maxSizeSubMatrixWithAll1(arr1)); 
        
    } 
}
