package com.ds.problems.arrays;

/**
 * 
 * @author vaibhavsingh
 *
 */
public class RotateArrayLeftOrRightByN {

	void rightRotate(int arr[], int d, int n) { 
		int count=0;
		// to use as left rotation 
		d = n - d; 
		d = d % n; 
		int i, j, k, temp; 
		int g_c_d = gcd(d, n); 
		for (i = 0; i < g_c_d; i++) { 
		   // move i-th values of blocks 
		   temp = arr[i]; 
		   j = i; 
		   while (true) {
			   count++;
		       k = j + d; 
		       if (k >= n) 
		           k = k - n; 
		       if (k == i) 
		           break; 
		       arr[j] = arr[k]; 
		       j = k; 
		   } 
		   arr[j] = temp; 
		} 
		
		System.out.println("Count="+count);
	} 
		
	int gcd(int a, int b) { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    } 
	
	void printArray(int arr[], int size) { 
		int i; 
		for (i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) { 
		RotateArrayLeftOrRightByN rotate = new RotateArrayLeftOrRightByN(); 
        int arr[] = { 1, 2, 3, 4, 5 }; 
        rotate.rightRotate(arr, 2, arr.length); 
        rotate.printArray(arr, arr.length); 
    } 
}
