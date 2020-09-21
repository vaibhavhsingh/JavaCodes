package com.ds.problems.arrays.twodim;

/**
 * Rotate a matrix by 90 degree without using any extra space | Set 2
 *
 * Given a square matrix, turn it by 90 degrees in anti-clockwise direction without using any extra space.
 * 
 * Input:
 * 1  2  3
 * 4  5  6
 * 7  8  9
 * 
 * Output:
 * 3  6  9 
 * 2  5  8 
 * 1  4  7
 * 
 * Input:
 * 1  2  3  4 
 * 5  6  7  8 
 * 9 10 11 12 
 * 13 14 15 16 
 * 
 * Output:
 * 4  8 12 16 
 * 3  7 11 15 
 * 2  6 10 14 
 * 1  5  9 13
 * 
 * 
 * Rotated the input matrix by
 * 90 degrees in anti-clockwise direction.
 * 
 * @author vaibhavsingh
 *
 */
public class RotateMatrixAt90 {

	public int[][] rotateBy90DegreesAntiClockWise(int arr[][]){
		return mirrorImageByRow(transposeOfMatrix(arr));
	}
	
	public int[][] mirrorImageByRow(int arr[][]) {
		int row = arr.length;
		for(int i=0;i<arr.length/2;i++) {
			for(int j=0;j<arr[i].length;j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[row-i-1][j];
				arr[row-i-1][j] = temp;
			}
		}
		return arr;
	}
	
	public int[][] transposeOfMatrix(int arr[][]){
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr[i].length;j++) {
				if(i!=j) {
					arr[i][j] = arr[i][j] + arr[j][i];
					arr[j][i] = arr[i][j] - arr[j][i];
					arr[i][j] = arr[i][j] - arr[j][i];
				}
			}
		}
		//printMatrix(arr);
		System.out.println("\n");
		return arr;
	}
	
	public void printMatrix(int arr[][]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String args[]) {
		RotateMatrixAt90 rotate = new RotateMatrixAt90();
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
		
		rotate.printMatrix(arr);
		System.out.println("\n");
		rotate.printMatrix(rotate.rotateBy90DegreesAntiClockWise(arr));
	}
}
