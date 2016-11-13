/*
 * Copyright 2016 Yuanjie
 */
package pkg447_number_of_bomerangs;

import java.util.HashMap;

/*



Given n points in the plane that are all pairwise distinct, a "boomerang" is 
a tuple of points (i, j, k) such that the distance between i and j equals the 
distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and 
coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]


 */
public class Main {

    public static int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }
        
        Integer count = 0;
        
        for (Integer i = 0; i < points.length; i++) {
            HashMap map = new HashMap();
            for (Integer j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int disSquare = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])  + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (!map.containsKey(disSquare)) {
                    map.put(disSquare, 1);
                } else {
                    count = count + (int) map.get(disSquare) * 2;
                    map.put(disSquare, (int) map.get(disSquare) + 1);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        //[[0,0],[1,0],[-1,0],[0,1],[0,-1]]
        int[][] points = {{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}};
        int[][] p2 = {{0,0}, {1,0}, {-1,0}, {0,1}, {0,-1}};
        System.out.println(numberOfBoomerangs(points));
        System.out.println(numberOfBoomerangs(p2));
        
    }
    
}
