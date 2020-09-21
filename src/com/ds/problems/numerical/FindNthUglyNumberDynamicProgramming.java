package com.ds.problems.numerical;

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
 * Given a number n, the task is to find n’th Ugly number.
 * 
 * Examples:
 * Input  : n = 7
 * Output : 8
 * 
 * Input  : n = 10
 * Output : 12
 * 
 * Input  : n = 15
 * Output : 24
 * 
 * Input  : n = 150
 * Output : 5832
 * 
 * @author vaibhavsingh
 *
 */
public class FindNthUglyNumberDynamicProgramming {

	public int getNthUglyNumber(int n) {
		int arr[] = new int[n];
		int i2=0;
		int i3=0;
		int i5=0;
		
		int nextMultipleOf2 = 2;
		int nextMultipleOf3 = 3;
		int nextMultipleOf5 = 5;
		
		int nextUglyNo = 1;
		arr[0] = 1;
		
		for(int i=1; i<n; i++) {
			nextUglyNo = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
			arr[i] = nextUglyNo;
			if(nextUglyNo == nextMultipleOf2) {
				i2++;
				nextMultipleOf2 = arr[i2] * 2; 
			}
			if(nextUglyNo == nextMultipleOf3) {
				i3++;
				nextMultipleOf3 = arr[i3] * 3;
			}
			if(nextUglyNo == nextMultipleOf5) {
				i5++;
				nextMultipleOf5 = arr[i5] * 5;
			}
		}
		printArray(arr);
		return arr[n-1];
	}
	
	private void printArray(int arr[]) {
		for(int i : arr) {
			System.out.print(i+", ");
		}
		System.out.print("\n");
	}
	
	public static void main(String args[]) {
		FindNthUglyNumberDynamicProgramming ugly = new FindNthUglyNumberDynamicProgramming();
		System.out.println("2nd Ugly No is "+ugly.getNthUglyNumber(2));
		System.out.println("3rd Ugly No is "+ugly.getNthUglyNumber(3));
		System.out.println("4th Ugly No is "+ugly.getNthUglyNumber(4));
		System.out.println("10th Ugly No is "+ugly.getNthUglyNumber(10));
	}
	
}

