/*
 * Copyright 2016 Yuanjie
 */
package pkg283_move_zeros;

/*
Given an array nums, write a function to move all 0's to the end of it 
while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.



*/

public class Main {

    
    public static void moveZeros(int[] nums) {
        int pos = 0;
        int size = nums.length;
        for(int i = 0; i < size; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        for (int i = pos; i < size; i++) {
            nums[i] = 0;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,13,4,0,0,3,0};
        moveZeros(nums);
        
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
    
}
