/*
Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). 
Originally, the 2D matrix is all 0 which means there is only sea in the matrix. 
The list pair has k operator and each operator has two integer A[i].x, A[i].y means that
you can change the grid matrix[A[i].x][A[i].y] from sea to island. Return how many island
are there in the matrix after each operator.

 Notice

0 is represented as the sea, 1 is represented as the island. 
If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Example
Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].

return [1,1,2,2].


*/



/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 




public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     * 
     * 1, 1, []
     * 2, 2, [[0,0],[1,1],[1,0],[0,1]]
     */
     
     
    class UnionFind {
        private int[] father = null;

        public UnionFind(int n) {
            father = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                father[i] = 0;
            }
        }    
        public int find(int x) {
            if (father[x] == 0) {
                return x;
            } 
            return father[x] = find(father[x]);
        }
    
        public void connect(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
               father[root_a] = root_b;
            }
        }
    } 

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        
        if (operators == null) {
            return ans;
        }
        UnionFind union = new UnionFind(n * m);
         
        int[][] island = new int[n][m];
       
        
        int count = 0;
        for (Point p : operators) {
            int x = p.x;
            int y = p.y;
            count++;
            if (island[x][y] == 0) {
                
                island[x][y] = 1;
                int indexCur = x * m + y + 1;


                if (x > 0 && island[x - 1][y] == 1) {
                    int sur = (x - 1) * m + y + 1;
                    int root_c = union.find(indexCur);
                    int root_s = union.find(sur);
                    if (root_c != root_s) {
                        // if surrending is not connect to cur yet, make connect and count--
                        union.connect(indexCur, sur);
                        count--;
                    }
                    
                }
                
                if (x < n - 1 && island[x + 1][y] == 1) {
                    int sur = (x + 1) * m + y + 1;
                    int root_c = union.find(indexCur);
                    int root_s = union.find(sur);
                    if (root_c != root_s) {
                        union.connect(indexCur, sur);
                        count--;
                    }
                }
                
                if (y > 0 && island[x][y - 1] == 1) {
                    int sur = x * m + y - 1 + 1;
                    int root_c = union.find(indexCur);
                    int root_s = union.find(sur);
                    if (root_c != root_s) {
                        union.connect(indexCur, sur);
                        count--;
                    }
                }
                
                if (y < m - 1 && island[x][y + 1] == 1) {
                    int sur = x * m + y + 1 + 1;
                    int root_c = union.find(indexCur);
                    int root_s = union.find(sur);
                    if (root_c != root_s) {
                        union.connect(indexCur, sur);
                        count--;
                    }
                }
            }
            ans.add(count);
            
        }
        return ans;
    }
}
