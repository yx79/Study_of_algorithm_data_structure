/*
 * Copyright 2016 Yuanjie
 */
package pkg189_rotate_array;

/*
189

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?

 */
public class Main {
    
    // time O(n) space O(1)
    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        // 1234567 --> 4321567
        reverse(nums, 0, n - k -1);
        
        // 4321567 --> 4321765
        reverse(nums, n - k, n - 1);
        
        // 4321765 --> 5671234
        reverse(nums, 0, n - 1);
        
    }
    
    public static void reverse(int[] nums, int i, int j) {
        int temp;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 3;
        
        rotate1(nums, k);
        
        for (int n : nums) {
            System.out.print(n + " ");
        }
        
        
        
        
    }
    
}
