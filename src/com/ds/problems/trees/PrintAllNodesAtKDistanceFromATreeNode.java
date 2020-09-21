package com.ds.problems.trees;

/**
 * Given a binary tree, a target node in the binary tree, and an integer value k, print all the nodes that are at distance k from the given target node. No parent pointers are available.
 * 
 * 				20
 * 			  /	   \
 * 			8		22
 * 		   /  \	
 * 		 4	   12
 * 			 /    \
 * 		   10	   14
 * 
 * Consider the tree shown above
 *
 * Input: target = pointer to node with data 8.
 * root = pointer to node with data 20.
 * k = 2.
 * Output : 10 14 22
 *
 * If target is 14 and k is 3, then output
 * should be “4 20”
 * 
 * 
 * @author vaibhavsingh
 *
 */
public class PrintAllNodesAtKDistanceFromATreeNode {

	private Node root;
	
	public void printDownNodesAtKDistance(Node node, int distance) {
		if(node == null || distance < 0) {
			return;
		}
		
		if(distance == 0) {
			System.out.print(node.data + " ");
			return;
		}
		printDownNodesAtKDistance(node.left, distance-1);
		printDownNodesAtKDistance(node.right, distance-1);
	}
	
	public int printNodesAtKDistance(Node root, Node targetNode, int distance) {
	
		if(root == null || targetNode == null) {
			return -1;
		}
		
		if(root == targetNode) {
			printDownNodesAtKDistance(root, distance);
		}
		
		// Recur for left subtree 
        int dl = printNodesAtKDistance(root.left, targetNode, distance); 
   
        // Check if target node was found in left subtree 
        if (dl != -1) { 
               
            // If root is at distance k from target, print root 
            // Note that dl is Distance of root's left child from  
            // target 
            if (dl + 1 == distance) { 
                System.out.print(root.data + " "); 
            } 
               
            // Else go to right subtree and print all k-dl-2 distant nodes 
            // Note that the right child is 2 edges away from left child 
            else
            		printDownNodesAtKDistance(root.right, distance - dl - 2); 
   
            // Add 1 to the distance and return value for parent calls 
            return 1 + dl; 
        } 
   
        
     // Recur for right subtree 
        int dr = printNodesAtKDistance(root.right, targetNode, distance); 
   
        // Check if target node was found in left subtree 
        if (dr != -1) { 
               
            // If root is at distance k from target, print root 
            // Note that dl is Distance of root's left child from  
            // target 
            if (dr + 1 == distance) { 
                System.out.print(root.data + " "); 
            } 
               
            // Else go to right subtree and print all k-dl-2 distant nodes 
            // Note that the right child is 2 edges away from left child 
            else
            		printDownNodesAtKDistance(root.left, distance - dr - 2); 
   
            // Add 1 to the distance and return value for parent calls 
            return 1 + dr; 
        } 
   
		
		return -1;
	}
	
	public static void main(String args[]) {
		PrintAllNodesAtKDistanceFromATreeNode tree = new PrintAllNodesAtKDistanceFromATreeNode();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);

		Node target = tree.root.left.right; 
		
		tree.printNodesAtKDistance( tree.root, target, 2);
	}
}