
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Trapping Rain Water

Have you met this question in a real interview? Yes
Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Challenge 
O(n) time and O(1) memory

O(n) time and O(n) memory is also acceptable.

Tags 
Two Pointers Forward-Backward Traversal Array
Related Problems 
Medium Container With Most Water 41 %
Hard Trapping Rain Water II 23 %


*/


public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        int left = 0, right = heights.length - 1;
        int res = 0;
        if (left >= right) {
            return res;
        }
        int leftHeight = heights[left];
        int rightHeight = heights[right];
        while (left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (leftHeight > heights[left]) {
                    res += leftHeight - heights[left];
                } else{
                    leftHeight = heights[left];
                }
            } else {
                right--;
                if (rightHeight > heights[right]) {
                    res += rightHeight - heights[right];
                } else {
                    rightHeight = heights[right];
                }
            }
        }
        return res;
    }
}
