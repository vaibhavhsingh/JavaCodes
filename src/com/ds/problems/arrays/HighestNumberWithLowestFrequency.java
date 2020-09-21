package com.ds.problems.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find highest number with lowest frequency in an array
 * 
 * [54,  6, 7, 5, 54, 6, 3, 2, 7]
 * Output 3
 * 
 * @author vaibhavsingh
 *
 */
public class HighestNumberWithLowestFrequency {

	public int findHighestNumberWithLowestFrequency(int arr[]) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> outputArray = new ArrayList<>();
		//int maxCount = 1;
		//int largestNumber = arr[0];
		for(int i : arr) {
			int count = map.getOrDefault(i, 0);
			map.put(i, count+1);
			outputArray.add(i);
			/*if(maxCount > count+1) {
				maxCount = count+1;
				largestNumber = i;
			} else if (maxCount == count+1 && largestNumber < i) {
				largestNumber = i;
			}*/
		}
		
		SortComparator comp = new SortComparator(map);
		Collections.sort(outputArray, comp);
		return outputArray.get(outputArray.size()-1);
	}
	
	
	public static void main(String args[]) {
		HighestNumberWithLowestFrequency h = new HighestNumberWithLowestFrequency();
		int array[] = {54,  6, 7, 5, 54, 6, 3, 2, 7};
		System.out.print("Largest Number with Lowest frequency = " + h.findHighestNumberWithLowestFrequency(array));
	}
}

class SortComparator implements Comparator<Integer> {

	private Map<Integer, Integer> map;
	int count = 0 ;
	SortComparator(Map<Integer, Integer> map) {
		this.map = map;
	}
	
	@Override
	public int compare(Integer o1, Integer o2) {
		System.out.println(++count);
		int freqCompare = map.get(o2).compareTo(map.get(o1));
		
		int valueCompare = o1.compareTo(o2);
		if(freqCompare == 0 ) {
			return valueCompare;
		} else {
			return freqCompare;
		}
	}	
}