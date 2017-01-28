/*

46. Permutations    

Difficulty: Medium

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 

*/



public class Solution {
    // backtracking
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        permuteHelper(nums, ans, list);
        return ans;
    }
    /*
    All possible permutatons DFS
    Backtracking
                                              () [1, 2, 3]
                                              
            (1) [2, 3]                         (2) [1, 3]                          (3) [1, 2]
            
    (1,2) [3]      (1,3)[2]              (2,1) [3]      (2,3)[1]             (3,1) [2]      (3,2)[1]       
    
    (1,2,3)[]       (1,3,2)[]           (2,1,3)[]       (2,3,1)[]           (3,1,2)[]       (3,2,1)[]
    */
    public void permuteHelper(int[] nums, List<List<Integer>> ans, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // Backtracking
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                permuteHelper(nums, ans, list);
                // remove the last element added.
                list.remove((Integer)nums[i]);
            }
            
        }
    }
}
