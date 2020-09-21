package com.ds.problems.linkedlist;

/**
 * 
 * @author vaibhavsingh
 *
 */
public class ReverseKElementsInLinkedList {

	public Node reverseKElements(Node head, int k) {
		Node previous = null;
		Node current = head;
		Node next = null;
		
		int i=0;
		while(i<k && current!=null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			i++;
		}
		
		Node newHead = previous;
		while(previous!=null && previous.next != null) {
			previous = previous.next;
			
		}
		
		previous.next = next;
		return newHead;
	}
	
	public void printLinkedList(Node head) {
		Node node = head;
		while(node!=null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println("\n");
	}
	
	public static void main(String args[]) {
		ReverseKElementsInLinkedList list = new ReverseKElementsInLinkedList();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = new Node(9);
		
		list.printLinkedList(head);
		Node newHead = list.reverseKElements(head, 19);
		list.printLinkedList(newHead);
	}
}
