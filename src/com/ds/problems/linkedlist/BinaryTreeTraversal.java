package com.ds.problems.linkedlist;

public class BinaryTreeTraversal {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class BinaryTree {

		Node root;

		BinaryTree() {
			this.root = null;
		}

		public void inOrderTraversal(Node node) {
			if (node == null) {
				return;
			}

			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}

		public void preOrderTraversal(Node node) {
			if (node == null) {
				return;
			}

			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}

		public void postOrderTraversal(Node node) {
			if (node == null) {
				return;
			}

			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);

		System.out.print("InOrder Traversal -> ");
		tree.inOrderTraversal(tree.root);
		System.out.print("\nPreOrder Traversal -> ");
		tree.preOrderTraversal(tree.root);
		System.out.print("\nPostOrder Traversal -> ");
		tree.postOrderTraversal(tree.root);
	}
}
