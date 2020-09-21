package com.ds.problems.sorting;

public abstract class Sort {

	public void printArray(int[] array) {
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
	
	public abstract int[] sort(int arr[]);
}
