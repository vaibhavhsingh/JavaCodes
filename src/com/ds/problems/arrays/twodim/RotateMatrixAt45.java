package com.ds.problems.arrays.twodim;

/**
 * Given a matrix mat[][] of size N*N, the task is to rotate the matrix by 45 degrees and print the matrix.
 * 
 * E.g. Input: N = 6,
 *	mat[][] = {{3, 4, 5, 1, 5, 9, 5},
 *              {6, 9, 8, 7, 2, 5, 2},  
 *              {1, 5, 9, 7, 5, 3, 2},
 *              {4, 7, 8, 9, 3, 5, 2},
 *              {4, 5, 2, 9, 5, 6, 2},
 *              {4, 5, 7, 2, 9, 8, 3}}
 *              
 *  Output:
 *       3
 *      6 4
 *     1 9 5
 *	  4 5 8 1
 *	 4 7 9 7 5
 *	4 5 8 7 2 9
 * 	 5 2 9 5 5
 *    7 9 3 3
 *     2 5 5
 *      9 6
 *       8
 *       
 *       
 *       
 *  Input: N = 4,
 *	mat[][] = {{2, 5, 7, 2},
 *               {9, 1, 4, 3},
 *               {5, 8, 2, 3},
 *               {6, 4, 6, 3}}
 *
 * Output:
 *    2
 *   9 5
 *  5 1 7
 * 6 8 4 2
 *  4 2 3
 *   6 3
 *    3 
 *  
 * @author vaibhavsingh
 *
 */
public class RotateMatrixAt45 {

	public void rotateAt45(int arr[][]) {
		int row = arr.length;
		int column = row;
		int rowTemp = 0;
		int colTemp = 1;
		for(int i = 0; i < (2*row-1); i++) {
			rowTemp = i;
			for(int x=0;x<Math.abs(row-i-1);x++) {
				System.out.print(" ");
			} 
			if(i>=row) {
				rowTemp = row-1;
				for(int j = colTemp; j < column;j++) {
					System.out.print(arr[rowTemp][j] + " ");
					rowTemp--;
				}
				colTemp++;
			} else {
				for(int j = 0; j < i+1;j++) {
					System.out.print(arr[rowTemp][j] + " ");
					rowTemp--;
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		int arr[][] =  {
						{4, 5, 6, 9, 8, 7, 1, 4},
						{1, 5, 9, 7, 5, 3, 1, 6},
						{7, 5, 3, 1, 5, 9, 8, 0},
						{6, 5, 4, 7, 8, 9, 3, 7},
						{3, 5, 6, 4, 8, 9, 2, 1},
						{3, 1, 6, 4, 7, 9, 5, 0},
						{8, 0, 7, 2, 3, 1, 0, 8},
						{7, 5, 3, 1, 5, 9, 8, 5}
					   } ;
		
		new RotateMatrixAt45().rotateAt45(arr);
	}
}
