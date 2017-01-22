
package pkg108_convert_sorted_array_bst;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

Company 
    Tags Airbnb
Tree 
    Depth-first Search

Similar Problems 
    (M) Convert Sorted List to Binary Search Tree


 */
public class Main {

    // recursive method
    public static TreeNode sortedArrayToBST(int[] nums) {
        //if (nums == null) { return null; }
        TreeNode root = bst(nums, 0, nums.length - 1);
        return root;
    }
    
    public static TreeNode bst(int[] nums, int left, int right) {
        if (left > right) { return null; }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bst(nums, left, mid - 1);
        root.right = bst(nums, mid + 1, right);
        return root;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 7, 8, 9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
    
}
