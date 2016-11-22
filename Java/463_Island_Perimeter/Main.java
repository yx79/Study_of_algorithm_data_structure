/*
 * Copyright 2016 Yuanjie
 */
package pkg463_island_perimeter;

/*
You are given a map in form of a two-dimensional integer grid where 1 
represents land and 0 represents water. Grid cells are connected 
horizontally/vertically (not diagonally). The grid is completely 
surrounded by water, and there is exactly one island (i.e., one or more 
connected land cells). The island doesn't have "lakes" (water inside that 
isn't connected to the water around the island). One cell is a square 
with side length 1. The grid is rectangular, width and height don't 
exceed 100. Determine the perimeter of the island.


[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below
 */
public class Main {

    public static int island(int[][] grid) {
        int peri = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                int sur = 0;
                if ((i - 1) >= 0 && grid[i - 1][j] == 1) {
                    sur++;
                }
                if ((j - 1) >= 0 && grid[i][j - 1] == 1) {
                    sur++;
                }
                if ((i + 1) < grid.length && grid[i + 1][j] == 1) {
                    sur++;
                }
                if ((j + 1) < grid[i].length && grid[i][j + 1] == 1) {
                    sur++;
                }
                switch (sur) {
                    case 0: peri += 4; break;
                    case 1: peri += 3; break;
                    case 2: peri += 2; break;
                    case 3: peri += 1; break;
                    case 4: break;
                    default: break;
                }
            }
        }
        
        return peri;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(island(grid));
    }
    
}
