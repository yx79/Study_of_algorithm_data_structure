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
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        
        int count = 0;
        for (Point p : operators) {
            int x = p.x;
            int y = p.y;
            count++;
            if (island[x][y] == 0) {
                
                island[x][y] = 1;
                int indexCur = x * m + y + 1;

                for (int dir = 0; dir < 4; dir++) {
                    int sx = x + dx[dir];
                    int sy = y + dy[dir];
                    if (sx >= 0 && sx < n && sy >=0 && sy < m && island[sx][sy] == 1) {
                        int sur = sx * m + sy + 1;
                        int root_c = union.find(indexCur);
                        int root_s = union.find(sur);
                        // if surrending is not connect to cur yet, make connect and count--
                        if (root_c != root_s) {
                            count--;
                            union.connect(indexCur, sur);
                        } 
                    }
                }
            }
            ans.add(count);
            
        }
        return ans;
    }
}
