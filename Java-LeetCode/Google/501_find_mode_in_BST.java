/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).


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
 
 // use hashmap to count the mode
public class Solution {
    int mode;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        
        mode = 1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        traverse(root, map);
        
        List<Integer> ans = new ArrayList<>();
        
        for (Integer key : map.keySet()) {
            if (mode == map.get(key)) {
                ans.add(key);
            }
        }
        
        int[] list = new int[ans.size()];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) ans.get(i);
        }
        return list;
        
    }
    public void traverse(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (!map.containsKey(val)) {
            map.put(val, 1);
        } else {
            int count = map.get(val) + 1;
            mode = Math.max(count, mode);
            map.put(val, count);
        }
        traverse(root.left, map);
        traverse(root.right, map);
    }
}
