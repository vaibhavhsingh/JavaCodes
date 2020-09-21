package com.ds.problems.questack;

import java.util.Stack;

public class QueueFromStack {

	private Stack<Integer> s1;
	private Stack<Integer> s2;

	public QueueFromStack() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	public void enqueue(Integer item) {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}

		s1.push(item);

		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

	public Integer dequeue() {
		if (s1.isEmpty()) {
			System.out.println("Queue is empty");
			System.exit(0);
		}

		return s1.pop();
	}

	public static void main(String args[]) {
		QueueFromStack queue = new QueueFromStack();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		System.out.println(queue.dequeue());
		queue.enqueue(4);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		queue.enqueue(5);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}
}
