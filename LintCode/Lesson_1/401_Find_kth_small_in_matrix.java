/*

401_Find the kth smallest number in at row and column sorted matrix.

Have you met this question in a real interview? Yes
Example
Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]
return 5

Challenge 
Solve it in O(k log n) time where n is the bigger one between row size and column size.

Tags 
Heap Priority Queue Matrix
Related Problems 
Hard Kth Smallest Sum In Two Sorted Arrays 24 %
Medium Kth Largest Element


*/


public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
     
    public class Tuple {
        public int row, col, val;
        public Tuple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // 
        int n = matrix.length;
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>(n, new Comparator<Tuple>() {
                @Override
                public int compare(Tuple a, Tuple b) {
                    return Integer.compare(a.val, b.val);
                }
            });
        for (int i = 0; i < n; i++) {
            queue.add(new Tuple(i, 0, matrix[i][0]));
        }   
        for (int j = 0; j < k - 1; j++) {
            Tuple small = queue.poll();
            int row = small.row;
            int col = small.col;
            
            if (col + 1 == matrix[0].length) {
                // reach end of row
                continue;
            }
            int val = matrix[row][col + 1];
            queue.add(new Tuple(row, col + 1, val));
        }
        return queue.poll().val;
        
    }
}
