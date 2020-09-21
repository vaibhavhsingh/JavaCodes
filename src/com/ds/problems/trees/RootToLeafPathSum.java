package com.ds.problems.trees;

/**
 * Given a binary tree and a number, return true if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals the given
 * number. Return false if no such path can be found. 10 / \ 8 2 / \ / 3 5 2
 * 
 * 21 -> 10 + 8 + 3 23 -> 10 + 8 + 3 14 -> 10 + 2 + 2
 * 
 * http://cslibrary.stanford.edu/110/BinaryTrees.html
 * 
 * @author vaibhavsingh
 *
 */
public class RootToLeafPathSum {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static class BinaryTree {
		Node root;

		public boolean hasPathSum(Node node, int value) {
			if (node == null) {
				return value == 0;
			} else {
				int sum = value - node.data;
				/*
				 * boolean flag = false; int sum = value - node.data; if (sum == 0 && node.left
				 * == null & node.right == null) { return true; } else if (node.left != null) {
				 * flag = flag || hasPathSum(node.left, sum); } else if (node.right != null) {
				 * flag = flag || hasPathSum(node.right, sum); }
				 */
				return hasPathSum(node.left, sum) || hasPathSum(node.right, sum);
			}
		}
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);

		System.out.println(tree.hasPathSum(tree.root, 22));
	}
}
