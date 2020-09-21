package com.ds.problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public int height(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
	}
	
	public void printLevel(Node node, int level) {
		if(node == null) {
			return;
		} 
		
		if (level == 1) {
			System.out.print(node.data+ " ");
		} else if (level > 1){
			printLevel(node.left, level-1);
			printLevel(node.right, level-1);
		}
	}
	/*
	 * This approach have time complexity of O(n2) and space complexity of O9n)
	 */
	public void levelOrderRecursion(Node root) {
		if(root == null) {
			return;
		}
		
		int height = height(root);
		for(int i=1;i <=height ;i++) {
			printLevel(root, i);
		}
	}
	
	public void levelOrderIterative(Node root) {
		if(root == null ) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.data + " ");
			if(node.left!=null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
	}
	
	public static void main (String args[]) {
		LevelOrderTraversal tree = new LevelOrderTraversal();
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right.left = new Node(7);
		
		tree.levelOrderRecursion(root);
		System.out.println();
		tree.levelOrderIterative(root);
	}
}
