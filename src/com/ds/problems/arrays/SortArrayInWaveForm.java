package com.ds.problems.arrays;

/**
 * Sort an array in wave form
 * 
 * Given an unsorted array of integers, sort the array into a wave like array. An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
 * Examples:
 * 
 * Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
 * Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
 *               {20, 5, 10, 2, 80, 6, 100, 3} OR
 *               any other array that is in wave form
 *
 * Input:  arr[] = {20, 10, 8, 6, 4, 2}
 * Output: arr[] = {20, 8, 10, 4, 6, 2} OR
 *                {10, 8, 20, 2, 6, 4} OR
 *               any other array that is in wave form
 *
 * Input:  arr[] = {2, 4, 6, 8, 10, 20}
 * Output: arr[] = {4, 2, 8, 6, 20, 10} OR
 *                any other array that is in wave form
 *
 * Input:  arr[] = {3, 6, 5, 10, 7, 20}
 * Output: arr[] = {6, 3, 10, 5, 20, 7} OR
 *              any other array that is in wave form
 *                
 * @author vaibhavsingh
 *
 */
public class SortArrayInWaveForm {

	public void sortArray(int arr[]) {
		int n = arr.length;
		System.out.print("Original Array=");
		print(arr);
		
		for(int i=1; i<n; ) {
			if(arr[i] > arr[i-1]) {
				swapElement(arr, i, i-1);
			}
			
			if(i+1 < n && arr[i] > arr[i+1]) {
				swapElement(arr, i, i+1);
			}
			i+=2;
		}
		System.out.print("Swapped Array=");
		print(arr);
	}
	
	private void swapElement(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public void print(int arr[]) {
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("\n");
	}
	public static void main(String args[]) {
		SortArrayInWaveForm waveSort = new SortArrayInWaveForm();
		
		int arr[] = {5,2,6,8,92,6,2,1};
		
		waveSort.sortArray(arr);
		
		int arr1[] = {10, 90, 49, 2, 1, 5, 23};
		waveSort.sortArray(arr1);
	}
}
