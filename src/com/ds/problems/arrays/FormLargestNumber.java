package com.ds.problems.arrays;

import java.util.Arrays;

/**
 * Given an integer array of positive integers arrange them to form the largest number
 * 
 * e.g. [3, 30, 34, 5, 9]
 * Largest Number = 9534330
 * 
 * @author vaibhavsingh
 *
 */
public class FormLargestNumber {

	public String largestNumber(int[] arr) {
		if(validateAllZeros(arr)) {
			return "0";
		}
		Number[] numArr = new Number[arr.length];
		for(int i=0;i<arr.length;i++) {
			numArr[i] = new Number(arr[i]);
		}
		
		Arrays.sort(numArr);
		
		StringBuilder sb = new StringBuilder();
		for(Number num : numArr) {
			sb.append(num.num);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	private boolean validateAllZeros(int arr[]){
        boolean flag = true;
        for(int num : arr) {
            if(num==0) {
                flag &=true;
            } else {
                flag &=false;
            }
        }
        return flag;
    }
	
	public static void main(String args[]) {
		FormLargestNumber largestNum = new FormLargestNumber();
		int arr[] = {3, 30, 34, 5, 9};
		System.out.println(largestNum.largestNumber(arr));
		
		int arr1[] = {0, 0, 0, 0, 0};
		System.out.println(largestNum.largestNumber(arr1));
	}
}

class Number implements Comparable<Number> {

	String num;
	Number (Integer num) {
		this.num = String.valueOf(num);
	}
	@Override
	public int compareTo(Number o) {
		String first = this.num + o.num;
		String second = o.num + this.num;
		
		return second.compareTo(first);
	}
	
}
