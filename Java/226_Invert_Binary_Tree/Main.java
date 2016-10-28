/*
 * Copyright 2016 Yuanjie
 */
package pkg226_invert_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Pomme
 */
public class Main {
    public static void levelOrdertraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);
        levelOrdertraversal(root);
        System.out.print("\nInverted: \n");
        TreeNode inverted = invertTree(root);
        levelOrdertraversal(inverted);
    }
    
}
