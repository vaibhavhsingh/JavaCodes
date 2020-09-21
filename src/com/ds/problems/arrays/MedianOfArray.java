package com.ds.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfArray {

	public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        List<Integer> mergedList = new ArrayList<Integer>();
        
        int i=0;
        int j=0;
        while(i<a.size() && j<b.size()){
            if(a.get(i) < b.get(j)) {
                mergedList.add(a.get(i));
                i++;
            } else if(a.get(i) > b.get(j)) {
                mergedList.add(b.get(j));
                j++;
            } else {
                mergedList.add(a.get(i));
                mergedList.add(b.get(j));
                i++;
                j++;
            }
        }
        while (i<a.size()) {
            mergedList.add(a.get(i));
            i++;
        }
        while (j<b.size()) {
            mergedList.add(b.get(j));
            j++;
        }
        int s = mergedList.size();
        
        if(s==1){
            return mergedList.get(0);
        }
        return s%2==0 ? ((double)mergedList.get(s/2-1) + (double) mergedList.get(s/2))/2 : mergedList.get(s/2);
    }
	
	public static void main(String args[]) {
		List<Integer> list1 = Arrays.asList(-37, -9, 10, 19 );
		List<Integer> list2 = Arrays.asList( -29, 18, 46 );
		System.out.println(findMedianSortedArrays(list1, list2));
	}
}
