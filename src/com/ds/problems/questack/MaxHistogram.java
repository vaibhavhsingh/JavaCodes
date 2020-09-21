package com.ds.problems.questack;

import java.util.Stack;

/**
 * Given an array representing height of bar in bar graph, find max histogram
 * area in the bar graph. Max histogram will be max rectangular area in the
 * graph.
 * 
 * Maintain a stack
 * 
 * If stack is empty or value at index of stack is less than or equal to value at current 
 * index, push this into stack.
 * Otherwise keep removing values from stack till value at index at top of stack is 
 * less than value at current index.
 * While removing value from stack calculate area
 * if stack is empty 
 * it means that till this point value just removed has to be smallest element
 * so area = input[top] * i
 * if stack is not empty then this value at index top is less than or equal to 
 * everything from stack top + 1 till i. So area will
 * area = input[top] * (i - stack.peek() - 1);
 * Finally maxArea is area if area is greater than maxArea.
 * 
 * 
 * Time complexity is O(n)
 * Space complexity is O(n)
 * 
 * @author vaibhavsingh
 *
 */
public class MaxHistogram {
	public int findMaxHistogram(int arr[]) {
		Stack<Integer> stack  = new Stack<>();
		int n = arr.length;
		int area = 0;
		int maxArea = 0;
		int top=0;
		int i = 0;
		while(i < n) {
			if(stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.push(i++);
			} else {
				top = stack.peek();
				stack.pop();
				area = arr[top] * (stack.empty() ? i : i - stack.peek()-1);
				
				if(maxArea < area) {
					maxArea = area;
				}
			}
		}
		
		while(!stack.isEmpty()) {
			top = stack.peek();
			stack.pop();
			area = arr[top] * (stack.empty() ? i : i - stack.peek()-1);
			
			if(maxArea < area) {
				maxArea = area;
			}
		}
		return maxArea;
	}
	public static void main(String args[]) {
		MaxHistogram histogram = new MaxHistogram();
		int arr[] = {3, 0, 2, 4, 5, 9, 0, 1};
		System.out.println(histogram.findMaxHistogram(arr));
		
		int arr2[] = {2, 2, 2, 2, 2, 2, 2, 2};
		System.out.println(histogram.findMaxHistogram(arr2));
	}

}
