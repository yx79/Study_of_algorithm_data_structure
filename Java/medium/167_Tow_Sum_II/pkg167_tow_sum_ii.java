/*
 * Copyright 2016 Yuanjie
 */
package pkg167_tow_sum_ii;

/*

Given an array of integers that is already sorted in ascending order, 
find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that 
they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) 
are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2




 */
public class Main {

    
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                    return ans;
                }
                // case: 0 0 0 0 0 0 1 2 3 ... i++ can save time
                if (numbers[i] == numbers[j]) {
                    i++;
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] numbers = {1,2,3,4,5,6,7,8,9,11,12,13,21,32};
        int target = 25;
        int[] ans = twoSum(numbers, target);
        
        for (int n : ans) {
            System.out.println(n);
        }
        
    }
    
}
