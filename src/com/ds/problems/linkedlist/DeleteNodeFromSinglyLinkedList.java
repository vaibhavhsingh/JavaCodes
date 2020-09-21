package com.ds.problems.linkedlist;

/**
 * Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?
 * 
 * Given a pointer to a node to be deleted, delete the node. Note that we don’t have pointer to head node.
 * 
 * @author vaibhavsingh
 *
 */
public class DeleteNodeFromSinglyLinkedList {

	private Node head;
	
	class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	public void addNode(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
		} else {
			head.next = node;
		}
	}
	
	public void deleteNode(Node node) {
		Node temp = node.next;
		node.value=temp.value;
		node.next = temp.next;
	}
	
	public void printLinkedList() {
		Node node = head;
		while(node.next!=null) {
			System.out.print(node.value+"->");
			node = node.next;
		}
	}
	
	public static void main(String args[]) {
		DeleteNodeFromSinglyLinkedList list = new DeleteNodeFromSinglyLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		
		list.printLinkedList();
	}
}
