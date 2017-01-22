/*
 * Copyright 2016 Yuanjie
 */
package pkg200_number_of_island;

/**
 *
 * @author Pomme
 */
public class Main {

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count += island(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public static int island(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return 0;
        }
        if (grid[row][col] != '1') {
            return 0;
        } else {
            grid[row][col] = '.';
            island(grid, row + 1, col);
            island(grid, row - 1, col);
            island(grid, row, col + 1);
            island(grid, row, col - 1);
        }
        return 1;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        char[][] grid = {{'1', '1', '0', '0'}, {'1', '1', '0', '0'}, 
            {'0', '0', '0', '1'}, {'1', '1', '0', '0'}};
        System.out.println(numIslands(grid));
    }
    
}
