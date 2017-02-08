/*

Numbers keep coming, return the median of numbers at every time a new number added.

Have you met this question in a real interview? Yes
Clarification
What's the definition of Median?
- Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].


*/



public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return nums;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(1);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, new Comparator<Integer>() {
                @Override 
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });
        int median = nums[0];
        list.add(median);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > median) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
            while (minHeap.size() < maxHeap.size()) {
                minHeap.add(median);
                median = maxHeap.poll();
            }
            while (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(median);
                median = minHeap.poll();
            }
            list.add(median);
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            ans[index++] = (int) i;
        }
        return ans;
    }
}
