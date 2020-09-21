package com.test.threading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLocks {

	public static void main(String args[]) {
		Queue<Integer> queue = new LinkedList<>();
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		ProducerConsumerWithLocks.Producer producer = new Producer(queue, lock, condition, 10);
		ProducerConsumerWithLocks.Consumer consumer = new Consumer(queue, lock, condition);
		
		Thread producerThread = new Thread(producer);
		producerThread.setName("PRODUCER");
		Thread consumerThread = new Thread(consumer);
		consumerThread.setName("CONSUMER");
		
		producerThread.start();
		consumerThread.start();
	}
	
	private static class Producer implements Runnable{

		Queue<Integer> queue ;
		ReentrantLock lock;
		Condition condition;
		int maxCapacity;
		Random random = new Random();
		Producer(Queue<Integer> queue, ReentrantLock lock, Condition condition, int maxCapacity){
			this.queue = queue;
			this.lock = lock;
			//this.condition = lock.newCondition();
			this.condition = condition;
			this.maxCapacity = maxCapacity;
		}
		
		@Override
		public void run() {
			while(true) {
				lock.lock();
				try {
					if(queue.size() == maxCapacity) {
						System.out.println(Thread.currentThread().getName()+", Queue is full");
						condition.await();
					}
					int item = random.nextInt();
					boolean isAdded = queue.offer(item);
					if(isAdded) {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+", added integer "+item+" to the queue");
						condition.signalAll();
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}
	}
	
	private static class Consumer implements Runnable{

		Queue<Integer> queue ;
		ReentrantLock lock;
		Condition condition;
		Consumer(Queue<Integer> queue, ReentrantLock lock, Condition condition){
			this.queue = queue;
			this.lock = lock;
			this.condition = condition;
		}
		
		@Override
		public void run() {
			while(true) {
				lock.lock();
				try {
					if(queue.size() == 0) {
						System.out.println(Thread.currentThread().getName()+", Queue is empty");
						condition.await();
					}
					Integer item = queue.poll();
					if(item != null) {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+", fetched integer "+item+" from the queue");
						condition.signalAll();
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}
	}
}
