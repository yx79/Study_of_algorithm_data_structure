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
    public class Tuple{
        public int i, j, val;
        public Tuple (int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // [],[],0 corner case
        if (nums1 == null || nums2 == null || k == 0 || nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<>();
        }
        int N = nums1.length, M = nums2.length, max = N * M;
        
        // special case  [1,1,2], [1,2,3] k == 10
        if (k > max) {
            k = max;
        }
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>(N, new Comparator<Tuple>(){
                @Override
                public int compare(Tuple a, Tuple b) {
                    return a.val - b.val;
                }
            });
        for (int i = 0; i < N; i++) {
            queue.add(new Tuple(i, 0, nums1[i] + nums2[0]));
        }
        
        List<int[]> ans = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            int[] list = new int[2];
            Tuple temp = queue.poll();
            list[0] = nums1[temp.i];
            list[1] = nums2[temp.j];
            ans.add(list);
            if (temp.j + 1 == M) {
                continue;
            }
            queue.add(new Tuple(temp.i, temp.j + 1, nums1[temp.i] + nums2[temp.j + 1]));
        }
        return ans;
    }
}
