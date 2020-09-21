package com.ds.problems.sorting;

public class QuickSort extends Sort{

	@Override
	public int[] sort(int[] arr) {
		sortArray(arr, 0, arr.length-1);
		return arr;
	}

	private void sortArray(int arr[], int low, int high) {
		if(low < high) {
			int pivot = partition(arr, low, high);
			
			sortArray(arr, low, pivot-1);
			sortArray(arr, pivot+1, high);
		}
	}
	
	private int partition (int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low-1);
		for(int j=low; j< high; j++) {
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}
	
	public static void main(String args[]) {
		QuickSort i = new QuickSort();
		int arr[] = {4, 7, 1, 5, 12, 6, 3, 8};
		i.printArray(arr);
		i.printArray(i.sort(arr));
	}
}
