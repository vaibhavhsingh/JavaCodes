package com.ds.problems.trees;

/**
 * Given a binary tree, write a program to count the number of Unival or Single Valued Subtrees. 
 * A unival or Single Valued Subtree is one in which all the nodes have same value. 
 * Expected time complexity is O(n).
 * 
 *     		  5
 *           / \
 *          1   5
 *         / \   \
 *        5   5   5
 *        
 * Output = 4
 *        
 * @author vaibhavsingh
 *
 */
public class CountUnivalTrees {

	public boolean countUnival(Node root, Counter ct) {
		if(root == null) {
			return true;
		}
		
		boolean left = countUnival(root.left, ct);
		boolean right = countUnival(root.right, ct);
		
		if(!left || !right) {
			return false;
		}
		
		if(root.left!=null && root.data != root.left.data) {
			return false;
		}
		
		if(root.right!=null && root.data != root.right.data) {
			return false;
		}
		
		ct.count++;
		return true;
	}
	
	public int count(Node root) {
		Counter ct = new Counter();
		countUnival(root, ct);
		return ct.count;
	}
	
	public static void main(String args[]) {
		CountUnivalTrees univalTree = new CountUnivalTrees();
		Node root = new Node(5);
		root.left = new Node(1);
		root.left.left = new Node(5);
		root.left.right = new Node(5);
		root.right = new Node(5);
		root.right.right = new Node(5);
		root.right.right.right = new Node(1);
		
		System.out.println(univalTree.count(root));
	}
}

class Counter {
	int count;
}

