/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

*/





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Iterative method using stack

public class Solution {
   public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      TreeNode curr = root;
      while (curr != null || !stack.isEmpty()) {
         while (curr != null) {
            stack.push(curr);
            curr = curr.left;
         }
         curr = stack.pop();
         ans.add(curr.val);
         curr = curr.right;
      }
      return ans;
   }
}





// DFS method
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrderHelper(ans, root);
        return ans;
    }
    
    public void inOrderHelper(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderHelper(ans, root.left);
        ans.add(root.val);
        inOrderHelper(ans, root.right);
    }
    
    
}
