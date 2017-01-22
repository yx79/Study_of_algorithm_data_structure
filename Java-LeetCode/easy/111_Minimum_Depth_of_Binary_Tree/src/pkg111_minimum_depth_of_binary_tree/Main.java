/*
 * Copyright 2016 Yuanjie
 */
package pkg111_minimum_depth_of_binary_tree;

/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the 
root node down to the nearest leaf node.


Tree Depth-first Search 
Breadth-first Search


Hide Similar Problems 
(E) Binary Tree Level Order Traversal 
(E) Maximum Depth of Binary Tree


 */
public class Main {
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        
    }
     
    public static void main(String[] args) {
        /*
            10
           /  \
          5    14
         / 
        2
        
        */
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(14);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(2);
        System.out.println("Min depth: " + minDepth(root));
        
        /*
            10
           /  
          8    
         / 
        2
        
        */
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(8);
        node.left.left = new TreeNode(2);
        System.out.println("Min depth: " + minDepth(node));
    }
    
}
