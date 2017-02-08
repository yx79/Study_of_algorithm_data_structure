/*
Given an integer array, heapify it into a min-heap array.

For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
Have you met this question in a real interview? Yes
Clarification
What is heap?

Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.

What is heapify?
Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

What if there is a lot of solutions?
Return any of them.
Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

Challenge 
O(n) time complexity


*/


public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     * 
     * [45,39,32,11]
     */
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public void siftdown(int [] A, int i) {
        while (i < A.length) {
            int small = i;
            if (2 * i + 1 < A.length && A[small] > A[2 * i + 1]) {
                small = 2 * i + 1;
            }
            if (2 * i + 2 < A.length && A[small] > A[2 * i + 2]) {
                small = 2 * i + 2;
            }
            if (small == i) {
                 break;
            }
            swap(A, small, i);
            i = small;
            
        }
        
    }
    
    
    public void heapify(int[] A) {
        // write your code here
        for (int i = A.length / 2; i >= 0; i--) {
            siftdown(A, i);
        }
        
    }
}
