/*
 * Copyright 2016 Yuanjie
 */
package pkg453_min_move_to_equal_number;

/*
453. Minimum Moves to Equal Array Elements

Given a non-empty integer array of size n, find the minimum number of moves
required to make all array elements equal, where a move is incrementing
n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

 */
public class Main {

    
    public static int minMoves(int[] nums) {
        if (nums.length == 1) return 0;
        int min = nums[0]; // init with first number in array
        for (int n : nums) {
            min = Math.min(min, n);
        }
        int sum = 0;
        // increase by 1 to get equal number, is same as decrease others by 1 to the min number
        
        for (int n : nums) {
            sum = sum + n - min;
        }
        
        return sum;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {1, 2, 3};
        System.out.println(minMoves(nums));
    }
    
}
