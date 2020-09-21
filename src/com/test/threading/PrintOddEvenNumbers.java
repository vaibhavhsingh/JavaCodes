package com.test.threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenNumbers {

	public static void main(String args[]) {
		ReentrantLock lock = new ReentrantLock();
		Condition oddCondition = lock.newCondition();
		Condition evenCondition = lock.newCondition();
		int arr[] = {};
		int index = 0;
	}
	
	private static class OddEvenNumberClass implements Runnable {

		private int arr[];
		private int index;
		private ReentrantLock lock;
		private Condition oddCondition;
		private Condition evenCondition;
		private String threadName;
		
		OddEvenNumberClass(int arr[], int index, ReentrantLock lock, Condition oddCondition, Condition evenCondition, String threadName){
			this.arr = arr;
			this.index = index;
			this.lock = lock;
			this.oddCondition = oddCondition;
			this.evenCondition = evenCondition;
			this.threadName = threadName;
		}
		@Override
		public void run() {
			for(;index < arr.length; index++) {
				try {
				lock.lock();
					if(arr[index]%2 == 0) {
						evenCondition.signal();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}
		
	}
}
