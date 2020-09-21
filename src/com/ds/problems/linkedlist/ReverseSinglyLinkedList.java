package com.ds.problems.linkedlist;

public class ReverseSinglyLinkedList {

	public void printLinkedList(Node head) {
		Node node = head;
		while(node != null ) {
			System.out.print(node.data +"->");
			node = node.next;
		}
	}
	
	public Node reverseLinkedListIterative(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node previous = null;
		Node current = head;
		Node next = null;
		
		while(current!=null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		return previous;
	}
	
	public Node reverseLinkedListRecursive(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node node = reverseLinkedListRecursive(head.next);
		head.next.next = head;
		
		head.next = null;
		return node;
	}
	
	public static void main (String args []) {
		ReverseSinglyLinkedList linkedList = new ReverseSinglyLinkedList();
		
		Node head = new Node(2);
		head.next = new Node(3);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(6);
		head.next.next.next.next.next = new Node(7);
		
		linkedList.printLinkedList(head);
		System.out.println("\n");
		head = linkedList.reverseLinkedListIterative(head);
		linkedList.printLinkedList(head);
		System.out.println("\n");
		head = linkedList.reverseLinkedListRecursive(head);
		linkedList.printLinkedList(head);
	}
	
}
