 
package pkg064_min_path;

/*

Given a m x n grid filled with non-negative numbers, find a path from 
top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

  Tags       
Array Dynamic Programming
  Similar Problems 
(M) Unique Paths (H) Dungeon Game


 */
public class Main {

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length - 1, col = grid[0].length - 1;
        for (int i = row; i >= 0; i--) {
            for (int j = col; j >= 0; j--) {
                if (i < row && j < col) {
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                } else if (i < row) {
                    grid[i][j] += grid[i + 1][j];
                } else if (j < col) {
                    grid[i][j] += grid[i][j + 1];
                }
            }
        }
        return grid[0][0];
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] grid = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
        System.out.println(minPathSum(grid));
    }
    
}
