package com.ds.problems.trees;

/**
 * http://cslibrary.stanford.edu/110/BinaryTrees.html
 * 
 * @author vaibhavsingh
 *
 */
public class PrintPathRootToLeaves {

	static class BinaryTree {
		Node root;

		void printAllRootToLeavesPath(Node node, int arr[], int index) {
			if (node == null) {
				// stack.pop();
				return;
			}

			arr[index++] = node.data;
			if (node.left == null && node.right == null) {
				print(arr);
			} else {
				printAllRootToLeavesPath(node.left, arr, index);
				// stack.pop();
				printAllRootToLeavesPath(node.right, arr, index);
				// stack.pop();
			}
		}

		public void print(int arr[]) {
			for (int data : arr) {
				System.out.print(data + " ");
			}
			System.out.println("\n");
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

		tree.printAllRootToLeavesPath(tree.root, new int[10], 0);
	}
}
