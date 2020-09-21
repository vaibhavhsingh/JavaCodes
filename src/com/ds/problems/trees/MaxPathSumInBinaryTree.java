package com.ds.problems.trees;

/**
 * Maximum Path Sum in a Binary Tree
 * 
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
 * 
 * Input: Root of below tree
 *       	10
 *     	   /   \
 *    	 2   	 10
 *      /  \		/  \
 *    20    1	    -25
 *    			    /  \
 *    			   3	    4
 *    
 * Output: 42 (20+2+10+10)
 *
 * @author vaibhavsingh
 *
 */
public class MaxPathSumInBinaryTree {

	private int findMaxSumRec(Node root, ResultClass result) {
		if(root == null) {
			return 0;
		}
		
		int leftSum = findMaxSumRec(root.left, result);
		int rightSum = findMaxSumRec(root.right, result);
		
		int maxSingle = Math.max(Math.max(leftSum, rightSum) + root.data, root.data);
		
		int maxRoot = Math.max(maxSingle, leftSum + rightSum + root.data);
		
		result.value = Math.max(maxRoot, result.value);
		return maxSingle;
	}
	
	public int findMaxSum(Node root) {
		ResultClass result = new ResultClass();
		result.value = Integer.MIN_VALUE;
		findMaxSumRec(root, result);
		return result.value;
	}
	
	public static void main (String args[]) {
		MaxPathSumInBinaryTree tree = new MaxPathSumInBinaryTree();
		Node root = new Node(10); 
        root.left = new Node(2); 
        root.right = new Node(10); 
        root.left.left = new Node(20); 
        root.left.right = new Node(1); 
        root.right.right = new Node(-25); 
        root.right.right.left = new Node(3); 
        root.right.right.right = new Node(4);
        System.out.println("Maximum path sum :"+tree.findMaxSum(root));
	}
}

class ResultClass {
	int value;
}