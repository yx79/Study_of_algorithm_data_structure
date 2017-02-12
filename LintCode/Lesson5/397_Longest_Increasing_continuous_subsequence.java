/*
Give an integer array，find the longest increasing continuous subsequence in this array.

An increasing continuous subsequence:

Can be from right to left or from left to right.
Indices of the integers in the subsequence should be continuous.
 Notice

O(n) time and O(1) extra space.

Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.

Tags 
Enumeration Dynamic Programming Array

*/

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
         if (A == null || A.length == 0) {
             return 0;
         }
         int N = A.length;
         if (N == 1 || N == 2) {
             return N;
         }
         
         int max = 2, cnt = 1;
         
         // left to right
         for (int i = 0; i < N - 1; i++) {
             if (A[i] < A[i + 1]) {
                 cnt++;
                 max = Math.max(max, cnt);
             } else {
                 cnt = 1;
             }
         }
         
         cnt = 1;
         // right to left
         for (int i = N - 1; i > 0; i--) {
             if (A[i] < A[i - 1]) {
                 cnt++;
                 max = Math.max(max, cnt);
             } else {
                 cnt = 1;
             }
         }
         
         return max;
    }
    
}
