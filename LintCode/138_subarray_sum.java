/*
Subarray Sum

Given an integer array, find a subarray where the sum of numbers is zero. 
Your code should return the index of the first number and the index of the last number.

Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].

Tags 
Subarray Hash Table
*/


public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // to find sum of 0, the sum of array will show two same sum
        // -3  1  2  -3   1
        // -3 -2  0  -3  -2 the numbers after first -2 must adding to 0 to have second -2
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // -2 1 2 -3 4
            // -2 -1 1 -2 2
            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1);
                ans.add(i);
                break;
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
