/*
47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/


public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // create a boolean[] array to track if the element is used or not
        helper(nums, list, ans, new boolean[nums.length]);
        return ans;
    }
    
    public void helper(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // to avoid dupliates 
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                continue;
            }
            // add not used number
            if (used[i] == false) {
                used[i] = true;
                list.add(nums[i]);
                helper(nums, list, ans, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
            
            
        }
    }
}


