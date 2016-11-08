/*
 * Copyright 2016 Yuanjie
 */
package pkg235_lowestcommonancestorofbst;

/*
235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two 
given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is 
defined between two nodes v and w as the lowest node in T that has both v and 
was descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another 
example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of 
itself according to the LCA definition. 
*/

public class Main {

    public static TreeNode lowestCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null | q == null) {
            return null;
        }
        
        if (p.val < root.val && q.val < root.val) {
            return lowestCA(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCA(root.right, p, q);
        } else {
            return root;
        }
            
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        TreeNode rsubL = new TreeNode(5);
        TreeNode rsubR = new TreeNode(8);
        
        root.left = left;
        root.right = right;
        right.left = rsubL;
        right.right = rsubR;
        TreeNode result = lowestCA(root, rsubL, rsubR);
        System.out.println(result.val);
    }
    
}
