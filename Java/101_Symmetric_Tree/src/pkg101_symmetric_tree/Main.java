/*
 * Copyright 2016 Yuanjie
 */
package pkg101_symmetric_tree;

/**
 *
 * @author Pomme
 */
public class Main {

    public static boolean isSymRecursive(TreeNode root) {
        // empty tree is sym, otherwise check the left and right child is sym or not
        return root == null || isSymHelper(root.left, root.right);
    }
    public static boolean isSymHelper(TreeNode left, TreeNode right) {
        // if left and right both == null, return true, otherwise false;
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        else return isSymHelper(left.left, right.right) && isSymHelper(left.right, right.left);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        //right.left = new TreeNode(5);
        root.left = left;
        root.right = right;
        System.out.println(isSymRecursive(root));
    }
    
}
