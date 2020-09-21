package com.ds.problems.arrays;

/**
 * Search an element in a sorted and rotated array
 * 
 * An element in a sorted array can be found in O(log n) time via binary search. 
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
 * Devise a way to find an element in the rotated array in O(log n) time.
 * 
 * @author vaibhavsingh
 *
 */
public class SearchInSortedRotatedArray {
	
	public int pivotedBinarySearch(int arr[], int key) {
		int start = 0;
		int end = arr.length;
		int pivot = findPivot(arr, start, end-1);
		
		if(pivot==-1) {
			return binarySearch(arr, 0, end-1, key);
		}
		
		if(arr[pivot] == key) {
			return pivot;
		}
		
		if(arr[0] <= key) {
			return binarySearch(arr, 0, pivot-1, key);
		}
		return binarySearch(arr, pivot+1, end-1, key);
	}
	
	private int binarySearch(int arr[], int start, int end, int key) {
		if(start > end) {
			return -1;
		}
		
		int mid = (start + end)/2;
		
		
		if(key == arr[mid]) {
			return mid;
		}
		
		if(key < arr[mid]) {
			return binarySearch(arr, start, mid-1, key);
		}
		return binarySearch(arr, mid+1, end-1, key);
	}
	private int findPivot(int []arr, int start, int end) {
		if(start > end) {
			return -1;
		}
		
		if(start==end) {
			return start;
		}
		
		int mid = (start+end)/2;
		if(mid < end && arr[mid] > arr[mid+1]) {
			return mid;
		}
		
		if(mid > start && arr[mid] < arr[mid-1]) {
			return mid-1;
		}
		
		if(arr[start] >= arr[mid]) {
			return findPivot(arr, start, mid-1);
		}
		return findPivot(arr, mid+1, end);
	}
	
	public static void main(String args[]) {
		SearchInSortedRotatedArray search = new SearchInSortedRotatedArray();
		int arr[] = {12,18, 19, 22, 29, 1,4, 6, 9, 11};
		
		System.out.println(search.pivotedBinarySearch(arr, 6));
	}

}
