/*

373. Find K Pairs with Smallest Sums   
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

company : Google Uber
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]

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
