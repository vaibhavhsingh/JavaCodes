package com.ds.problems.linkedlist;

public class DetectAndRemoveLoopLinkedList {

	Node startNode;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public int detectAndRemoveLoop(Node head) {
		Node slow = head, fast = head;
		Node prev = slow;
		while (slow != null && fast != null && fast.next != null) {
			prev = fast;
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				System.out.println("Loop Detected");
				removeLoop(slow, head);
				return 1;
			}
		}
		return 0;
	}

	public void removeLoop(Node fast, Node head) {
		Node slow = head;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}

		fast.next = null;
		// prev.next.next.next = null;
	}

	public void printList(Node node) {
		Node curr = node;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}

	public static void main(String args[]) {
		DetectAndRemoveLoopLinkedList app = new DetectAndRemoveLoopLinkedList();
		app.startNode = new Node(1);
		app.startNode.next = new Node(2);
		app.startNode.next.next = new Node(3);
		app.startNode.next.next.next = new Node(4);
		app.startNode.next.next.next.next = new Node(5);
		app.startNode.next.next.next.next.next = app.startNode.next;

		app.detectAndRemoveLoop(app.startNode);
		app.printList(app.startNode);
	}
}
