/*
 * Copyright 2016 Yuanjie
 */
package pkg169_majority_element;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array of size n, find the majority element. 
The majority element is the element that appears more than [n/2] times.

You may assume that the array is non-empty and the majority element 
always exist in the array.


Array 
Divide and Conquer 
Bit Manipulation

Similar Problems (M) Majority Element II

 */


public class Main {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n / 2];
    }
    
    
    

    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {1,2,2,2,2,3,2,5,5};
        System.out.print(majorityElement(nums));
    }
    
}
