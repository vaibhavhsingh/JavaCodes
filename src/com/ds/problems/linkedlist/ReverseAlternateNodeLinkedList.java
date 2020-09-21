package com.ds.problems.linkedlist;

/**
 * https://www.geeksforgeeks.org/given-linked-list-reverse-alternate-nodes-append-end/?ref=rp
 * 
 * Given a linked list, reverse alternate nodes and append at the end
 * 
 * Input: 1->2->3->4->5->6
 * Output: 1->3->5->6->4->2
 * Explanation: Two lists are 1->3->5 and 2->4->6, 
 * reverse the 2nd list: 6->4->2. 
 * Merge the lists 
 * 
 * Input: 12->14->16->18->20
 * Output: 12->16->20->18->14
 * Explanation: Two lists are 12->16->20 and 14->18, 
 * reverse the 2nd list: 18->14. 
 * Merge the lists 
 * 
 * @author vaibhavsingh
 *
 */
public class ReverseAlternateNodeLinkedList {

	public Node reverseAlternateNodes(Node head) {
		if(head==null || head.next == null ||head.next.next == null) {
			return head;
		}
		
		Node node = head;
		Node evenListHead = head.next;
		Node evenNode = evenListHead;
		
		while(node!=null) {
			evenNode = node.next;
			node.next = node.next.next;
			node = node.next;
			//evenNode.next = 
		}
		printLinkedList(head);
		printLinkedList(evenListHead);
		return head;
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
		ReverseAlternateNodeLinkedList list = new ReverseAlternateNodeLinkedList();
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
		Node newHead = list.reverseAlternateNodes(head);
		list.printLinkedList(newHead);
		
	}
}
