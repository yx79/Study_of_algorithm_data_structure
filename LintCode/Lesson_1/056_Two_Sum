/*

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

 Notice

You may assume that each input would have exactly one solution

Have you met this question in a real interview? Yes
Example
numbers=[2, 7, 11, 15], target=9

return [1, 2]

Challenge 
Either of the following solutions are acceptable:

O(n) Space, O(nlogn) Time
O(n) Space, O(n) Time
Tags 
Sort Hash Table Airbnb Array Facebook Two Pointers
Related Problems 
Medium Two Sum II 35 %
Hard Triangle Count 36 %
Medium 3Sum Closest 31 %
Medium 4Sum 21 %
Medium 3Sum 20 %

*/


public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        //// HashMap method O(n) time O(n) space
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                ans[0] = map.get(target - numbers[i]);
                ans[1] = i + 1;
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return ans;
    }
}
