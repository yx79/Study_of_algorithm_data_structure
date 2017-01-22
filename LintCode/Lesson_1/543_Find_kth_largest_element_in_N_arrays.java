/*
543 Find K-th largest element in N arrays.

 Notice

You can swap elements in the array

Have you met this question in a real interview? Yes
Example
In n=2 arrays [[9,3,2,4,7],[1,2,3,4,8]], the 3rd largest element is 7.

In n=2 arrays [[9,3,2,4,8],[1,2,3,4,2]], the 1st largest element is 9, 2nd largest element is 8, 3rd largest element is 7 and etc.

Tags 
Heap
Related Problems 
Medium Largest Number
*/




import java.util.*;

public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public class Tuple {
        public int row, col, val;
        public Tuple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        int N = arrays.length, M = arrays[0].length;
        for (int[] arr : arrays) {
            // int[] is primitive cannot use Collections.reverseOrder()
            Arrays.sort(arr);
        }
        
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>(N, new Comparator<Tuple>() {
                @Override
                public int compare(Tuple a, Tuple b) {
                    // reverse compare
                    return b.val - a.val;
                }
            }); 
        for (int i = 0; i < N; i++) {
            // corner case! [] empty array!
            if (arrays[i] != null && arrays[i].length > 0) {
                queue.offer(new Tuple(i, arrays[i].length - 1, arrays[i][arrays[i].length - 1]));
            }
        }    
        for (int j = 0; j < k - 1; j++) {
            Tuple cur = queue.poll();
            int row = cur.row;
            int col = cur.col;
            // think about corner case, like [1] one element
            if (col <= 0) {
                continue;
            }
            queue.offer(new Tuple(row, col - 1, arrays[row][col - 1]));
        }
        return queue.poll().val;
            
        
    }
    
}
