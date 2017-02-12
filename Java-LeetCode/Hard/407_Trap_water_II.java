/*
Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map,
compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.


Google Twitter
Hide Tags Breadth-first Search Heap
Hide Similar Problems (H) Trapping Rain Water

*/


public class Solution {
    public class Block {
        int x, y, height;
        public Block(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        // at least 3x3 block maybe hold 1 block water
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) {
            return 0;
        }
        // first use a minHeap to store the outside wall block 
        PriorityQueue<Block> minHeap = new PriorityQueue<>(1, new Comparator<Block>(){
            @Override
            public int compare(Block a, Block b) {
                return a.height - b.height;
            }
        });
        int M = heightMap.length, N = heightMap[0].length;
        boolean[][] visit = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            visit[i][0] = true;
            minHeap.add(new Block(i, 0, heightMap[i][0]));
            visit[i][N - 1] = true;
            minHeap.add(new Block(i, N - 1, heightMap[i][N - 1]));
        }
        for (int j = 1; j < N - 1; j++) {
            visit[0][j] = true;
            minHeap.add(new Block(0, j, heightMap[0][j]));
            visit[M - 1][j] = true;
            minHeap.add(new Block(M - 1, j, heightMap[M - 1][j]));
        }
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int water = 0;
        while (!minHeap.isEmpty()) {
            Block edge = minHeap.poll();
            int x = edge.x;
            int y = edge.y;
            int h = edge.height;
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx <= 0 || ny <= 0 || nx >= M || ny >= N || visit[nx][ny] == true) {
                    continue;
                }
                visit[nx][ny] = true;
                int nh = heightMap[nx][ny];
                 
                minHeap.add(new Block(nx, ny, Math.max(h, nh)));
                water += Math.max(0, h - nh);
                
            }
            
        }
        
         
        
        return water;
    }
}
