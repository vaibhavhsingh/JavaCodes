package com.test.threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {

	public static void main(String args[]) {
		ReentrantLock lock = new ReentrantLock();
		Condition firstCondition = lock.newCondition();
		Condition secondCondition = lock.newCondition();
		Condition thirdCondition = lock.newCondition();
		
		PrintNumber one = new PrintInOrder.PrintNumber(1, lock, firstCondition, secondCondition, "One");
		PrintNumber two = new PrintInOrder.PrintNumber(2, lock, secondCondition, thirdCondition, "Two");
		PrintNumber three = new PrintInOrder.PrintNumber(3, lock, thirdCondition, firstCondition, "Three");
		
		Thread threadOne = new Thread(one);
		Thread threadTwo = new Thread(two);
		Thread threadThree = new Thread(three);
		
		threadOne.start();
		threadTwo.start();
		threadThree.start();
	}
	
	private static class PrintNumber implements Runnable{

		private int number;
		private ReentrantLock lock;
		private Condition condition;
		private Condition signalCondition;
		private String threadName;
		
		PrintNumber(int number, ReentrantLock lock, Condition condition, Condition signalCondition, String threadName){
			this.number = number;
			this.lock = lock;
			this.condition = condition;
			this.signalCondition = signalCondition;
			this.threadName = threadName;
		}
		
		@Override
		public void run() {
			while(true) {
				lock.lock();
				try {
					System.out.println(threadName + " - " + number);
					Thread.sleep(1000);
					signalCondition.signal();
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}
		
	}
}
