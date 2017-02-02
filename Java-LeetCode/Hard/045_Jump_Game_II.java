/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.


*/

public class Solution {
   
    // Greedy method
    // track the end point of each jump, and update the farthest point
    public int jump(int[] nums) {
        int count = 0, farthest = 0, end = 0;
        // 2 3 1 1 4
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == end) {
                end = farthest;
                count++;
            }
        }
        return count;
    }
   
   
   
    // DP method
    // f[i] is the min step from 0 to i.
    public int jumpDp(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        for (int i = 0; i < len; i++) {
            f[i] = i;
        }
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[len - 1];
    }
}

