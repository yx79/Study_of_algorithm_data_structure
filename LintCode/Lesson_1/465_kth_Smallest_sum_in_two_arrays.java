/*

373. Find K Pairs with Smallest Sums   
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

company : Google Uber

Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.

Have you met this question in a real interview? Yes
Example
Given [1, 7, 11] and [2, 4, 6].

For k = 3, return 7.

For k = 4, return 9.

For k = 8, return 15.

Challenge 
Do it in either of the following time complexity:

O(k log min(n, m, k)). where n is the size of A, and m is the size of B.
O( (m + n) log maxValue). where maxValue is the max number in A and B.
Tags 
Heap Priority Queue Sorted Matrix
Related Problems 
Medium Kth Smallest Number in Sorted Matrix 22 %
Medium Search a 2D Matrix II
*/

public class Solution {
    public class Tuple {
        public int i, j, val;
        public Tuple (int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // null corner case
        if (A == null || B == null || k == 0 || A.length == 0 || B.length == 0) {
            return 0;
        }
        int M = A.length, N = B.length;
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>(M, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple a, Tuple b) {
                return a.val - b.val;
            }
        });
        for (int i = 0; i < M; i++) {
            queue.add(new Tuple(i, 0, A[i] + B[0]));
        }
        for (int j = 0; j < k - 1; j++) {
            Tuple temp = queue.poll();
            int a = temp.i;
            int b = temp.j;
            if (b == N - 1) {
                continue;
            }
            queue.add(new Tuple(a, b + 1, A[a] + B[b + 1]));
        }
        return queue.poll().val;
        
    }
}
