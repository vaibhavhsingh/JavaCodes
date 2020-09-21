package com.test.java8;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

	public static int[][] convert(List<List<Integer>> masterList){
		Integer arr[][] = new Integer[masterList.size()][];
		for(int i=0; i<masterList.size();i++) {
			List<Integer> lst = masterList.get(i);
			Integer row[] = new Integer[lst.size()];
			arr[i] = lst.toArray(row); 
		}
		return null;
	}
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		
		
		List<List<Integer>> masterList = new ArrayList<>();
		masterList.add(list);
		masterList.add(list2);
		
		convert(masterList);
	}
}
