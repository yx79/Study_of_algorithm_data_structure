/*
Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the median of the element inside the window at each moving. (If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )

Have you met this question in a real interview? Yes
Example
For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]

At first the window is at the start of the array like this

[ | 1,2,7 | ,8,5] , return the median 2;

then the window move one step forward.

[1, | 2,7,8 | ,5], return the median 7;

then the window move one step forward again.

[1,2, | 7,8,5 | ], return the median 7;
*/



public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     * 
     * [1,2,7,7,2], 1: [1,2,7,7,2]
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        // corner case [], 0
        if (nums == null || nums.length < k || nums.length == 0) {
            return ans;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(1);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return (int) b - (int) a;
                }
            });
            
        int median = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                //corner case [1,2,7,7,2], 1
                if (nums[i] > median) {
                    minHeap.add(nums[i]);
                } else {
                    maxHeap.add(nums[i]);
                }
            }
            
            if (i >= k) {
                if (maxHeap.contains(nums[i - k])) {
                    maxHeap.remove(nums[i - k]);
                } else if (minHeap.contains(nums[i - k]))  {
                    minHeap.remove(nums[i - k]);
                } else {
                    if (maxHeap.size() > 0) {
                        median = maxHeap.poll();
                    } else if (minHeap.size() > 0) {
                        median = minHeap.poll();
                    }
                }
            }
            while (maxHeap.size() + 1 < minHeap.size()) {
                maxHeap.add(median);
                median = minHeap.poll();
            }
            while (maxHeap.size() > minHeap.size()) {
                minHeap.add(median);
                median = maxHeap.poll();
            }
            
            if (i + 1 >= k) {
                ans.add(median);
            }
        }
        return ans;
    }
}
