/*
 * Copyright 2016 Yuanjie
 */
package pkg088_merge_sorted_array;

import java.util.Arrays;

/*
88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 
as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to
m + n) to hold additional elements from nums2. The number of elements 
initialized in nums1 and nums2 are m and n respectively.

*/
public class Main {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 456 123 -> 123456, 123 456 -> 123456, 135 246->   123456
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;
        
        while (p1 >= 0 && p2 >= 0) {
            if (nums2[p2] > nums1[p1]) {
                nums1[index--] = nums2[p2--]; 
            } else {
                nums1[index--] = nums1[p1--];
            }
        }
        while (p2 >= 0) {
            nums1[index--] = nums2[p2--];
        }
        
    }
     
    
    public static void main(String[] args) {
        // TODO code application logic here
        int m = 3;
        int n = 2;
        int[] nums1 = {1, 3, 5, 0, 0};
        int[] nums2 = {4, 6};
        
        merge(nums1, m, nums2, n);
         
        for (int number : nums1) {
            System.out.print(number + " ");
        }
        
    }
    
}
