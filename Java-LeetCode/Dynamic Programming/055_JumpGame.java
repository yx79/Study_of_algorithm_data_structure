/*

55_JumpGame

Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
For example: A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.

Hide Company Tags Microsoft
Hide Tags Array Greedy

* Total Submissions: 366543
* Difficulty: Medium
* Contributors: Admin


*/


public class Solution {
    public boolean canJump(int[] nums) {
        // dynamic programing
        int len = nums.length;
        // state: f[i] means jump to No.i position
        boolean[] f = new boolean[len];
        // initialize
        f[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // function
                // j is infront of i, and if f[j] is true and nums[j] + j >= i, then f[i] is true;
                if (f[j] == true && nums[j] + j >= i) {
                    f[i] = true;
                    break;
                }
            }
        }
        // answer
        return f[len - 1];
    }
}
