/*

Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Have you met this question in a real interview? Yes
Clarification
What's the definition of longest increasing subsequence?

The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

https://en.wikipedia.org/wiki/Longest_increasing_subsequence

Example
For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4


*/


public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
     
    /*
    
    [88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27] 7 is in between
     1  1  2  3 4  1 3  4  4  2 2  3 4  5  6  7  6  5  

    */
    
    public int longestIncreasingSubsequence(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        // f[i] = min(f[i], f[j] + 1) if(f[j] < f[i])
        int[] f = new int[N];
        for (int i = 0; i < N; i++) {
            f[i] = 1;
        }
        for (int i = 1; i < N; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[j] + 1, f[i]);
                }
                j--;
            }
        }
        int max = 0;
        for (int i : f) {
            max = Math.max(i, max);
        }
        return max;
    }
}
