package com.ds.problems.arrays.twodim;

public class SpiralPrintMatrix {

	public void printSpiral(int endRowIndex, int endColIndex, int arr[][]) {

		int i = 0;
		int a = 0, b = 0;

		while (a < endRowIndex && b < endColIndex) {
			for (i = b; i < endColIndex; ++i) {
				System.out.print(arr[a][i] + " ");
			}
			a++;
			for (i = a; i < endRowIndex; ++i) {
				System.out.print(arr[i][endColIndex - 1] + " ");
			}
			endColIndex--;

			if (a < endRowIndex) {
				for (i = endColIndex - 1; i >= b; --i) {
					System.out.print(arr[endRowIndex - 1][i] + " ");
				}
				endRowIndex--;
			}

			if (b < endColIndex) {
				for (i = endRowIndex - 1; i >= a; --i) {
					System.out.print(arr[i][b] + " ");
				}
				b++;
			}
		}
	}

	public void printMatrix(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j=0; j < arr[i].length; j++ ) {
				System.out.print(arr[i][j]+" ");
			}
		}
	}
	
	public void printMatrixSpiral(int arr[][]) {
		int a = 0, b=0;
		int rowIndex = arr.length;
		int colIndex = arr[0].length;
		
		while(a < rowIndex && b < colIndex) {
			for (int i=b; i < colIndex; i++ ) {
				System.out.print(arr[a][i]+" ");
			}
			a++;
			
			for (int j=a; j < rowIndex; j++ ) {
				System.out.print(arr[j][colIndex-1]+" ");
			}
			colIndex--;
			
			if(a < rowIndex) {
				for (int k=colIndex-1; k >= b; k-- ) {
					System.out.print(arr[rowIndex-1][k]+" ");
				}
				rowIndex--;
			}
			
			
			if(b < colIndex) { 
				for (int l=rowIndex-1; l >= a; l-- ) {
					System.out.print(arr[l][b]+" ");
				}
				b++;
			}
			
		}
	}
	
	public static void main(String args[]) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		SpiralPrintMatrix print = new SpiralPrintMatrix();
		//print.printSpiral(3, 4, arr);
		print.printMatrix(arr);
		System.out.println("\n");
		print.printMatrixSpiral(arr);
		System.out.println("\n");
	}
}
