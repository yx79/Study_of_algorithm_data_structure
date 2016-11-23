/*
 * Copyright 2016 Yuanjie
 */
package pkg404_sum_of_leaves;

/*
Find the sum of all left leaves in a given binary tree.
Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 
respectively. Return 24.

*/
public class Main {

    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.value;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        
        return sum;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
                
        System.out.println(sumOfLeftLeaves(root));
    }
    
}
