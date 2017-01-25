/*

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle 
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Hide Tags Array Dynamic Programming

*/

public class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        
        // DFS
        int[][] hash = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return dfs(hash, triangle, 0, 0);

    }
    
    public int dfs(int[][] hash, List<List<Integer>> triangle, int row, int col) {
        if (row == hash.length) {
            return 0;
        }
        if (col == triangle.get(row).size()) {
            return 0;
        }
        // the hashtable is default as 0
        if (hash[row][col] == 0) {
            hash[row][col] = Math.min(dfs(hash, triangle, row + 1, col), dfs(hash, triangle, row + 1, col + 1)) + triangle.get(row).get(col);
        }
        // return the meoriation hash result when not
        return hash[row][col];
    }
    
    
    public int minimumTotalBtmUp(List<List<Integer>> triangle) {
        
        // bottom up method O(1) space
        int size = triangle.size(), len = triangle.get(size - 1).size();
        int[] dp = new int[len];
        // initialize the bottom 
        for (int j = 0; j < len; j++) {
            dp[j] = triangle.get(size - 1).get(j);
        }
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = Math.min(dp[j], dp[j + 1]);
                dp[j] = triangle.get(i).get(j) + min;
            }
        }
        return dp[0];
    }
    
    
    public int minimumTotalTopDown(List<List<Integer>> triangle) {
        // top down method
        int size = triangle.size(), len = triangle.get(size - 1).size();
        int[] dp = new int[len];
        // initialize the top
        dp[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < size; i++) {
            // loop from right to left to not change dp[j], as dp[j] = min(dp[j], dp[j - 1]) + T[i][j]
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int pre = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    pre = Math.min(dp[j - 1], pre);
                }
                if (j < triangle.get(i).size() - 1) {
                    pre = Math.min(dp[j], pre);
                }
                dp[j] = triangle.get(i).get(j) + pre;
            }
        }
        // bottom dp to choose the min
        int min = dp[0];
        for (int j = 1; j < len; j++) {
            min = Math.min(min, dp[j]);
        }
        
        return min;
    }
}
