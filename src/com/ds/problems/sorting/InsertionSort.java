package com.ds.problems.sorting;

public class InsertionSort extends Sort{

	public int[] sort(int arr[]) {
		for (int i=1; i<arr.length; i++) {
			int j = i-1;
			int key = arr[i];
			
			while(j>=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
		return arr;
	}
	
	public static void main(String args[]) {
		InsertionSort i = new InsertionSort();
		int arr[] = {4, 7, 1, 5, 12, 6, 3, 8};
		i.printArray(arr);
		i.printArray(i.sort(arr));
	}
}
