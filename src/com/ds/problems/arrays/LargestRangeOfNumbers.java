package com.ds.problems.arrays;

import java.util.Arrays;

public class LargestRangeOfNumbers {

	public static int[] largestRange(int[] array) {
	    // Write your code here.
			Arrays.sort(array);
			int maxRange[] = new int[2];
			int range[] = new int[2];
			int maxRangeCount = 0;
			int rangeCount = 0;
			
			range[0] = array[0];
			for(int i=1; i<array.length; i++) {
				if((array[i] - array[i-1]) == 0 ) {
					range[1] = array[i];
					continue;
				}
				if((array[i] - array[i-1]) == 1) {
					range[1] = array[i];
					rangeCount++;
				} else {
					//map.put(range, maxRange);
					if(rangeCount > maxRangeCount) {
						maxRange[0] = range[0];
						maxRange[1] = range[1];
						maxRangeCount = rangeCount;
					}
					range[0] = array[i];	
					range[1] = array[i];
					rangeCount = 0;
				}
			}
			if(rangeCount > maxRangeCount) {
				maxRange[0] = range[0];
				maxRange[1] = range[1];
				maxRangeCount = rangeCount;
			}
	    return maxRange;
	}
	
	public static void main(String args[]) {
		int arr[] = {-7,
			    -7,
			    -7,
			    -7,
			    8,
			    -8,
			    0,
			    9,
			    19,
			    -1,
			    -3,
			    18,
			    17,
			    2,
			    10,
			    3,
			    12,
			    5,
			    16,
			    4,
			    11,
			    -6,
			    8,
			    7,
			    6,
			    15,
			    12,
			    12,
			    -5,
			    2,
			    1,
			    6,
			    13,
			    14,
			    -4,
			    -2 };
		largestRange(arr);
	}
}
