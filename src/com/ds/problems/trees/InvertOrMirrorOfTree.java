package com.ds.problems.trees;

import java.util.Stack;

public class InvertOrMirrorOfTree{
	
	public void displayTree(Node root) {
	
		if(root == null) {
			return;
		}
		displayTree(root.left);
		System.out.print(root.data+" ");
		displayTree(root.right);
		
	}
	
	public void mirrorWithRecursion(Node root) {
		if(root == null) {
			return;
		}
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		mirrorWithRecursion(root.left);
		mirrorWithRecursion(root.right);
	}
	
	public void mirrorWithoutRecursion(Node root) {
		if(root == null) {
			return;
		}
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.peek();
			
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			stack.pop();
			
			if(node.left!=null) {
				stack.push(node.left);
			}
			
			if(node.right != null) {
				stack.push(node.right);
			}
		}
	}
	
	public static void main (String args[]) {
		InvertOrMirrorOfTree tree = new InvertOrMirrorOfTree();
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right.left = new Node(7);
		
		tree.displayTree(root);
		
		tree.mirrorWithoutRecursion(root);
		System.out.println("\n");
		tree.displayTree(root);
	}
}
