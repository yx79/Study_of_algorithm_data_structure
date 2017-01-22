/*
 * Copyright 2016 Yuanjie
 */
package pkg349_intersection_of_two_array;

import java.util.HashSet;

/*
349 Intersection of Two Arrays

 Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

*/
public class Main {

    public static int[] interSection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet();
        HashSet<Integer> inter = new HashSet();
        
        // add numbers in nums1 to Hashset set
        for (int n : nums1) {
            if (!set.contains(n)) {
                set.add(n);
            }
        }
        
        // if set and nums2 have same number. add it to Hashset inter
        for (int n : nums2) {
            if (set.contains(n)) {
                inter.add(n);
            }
        }
        
        // numbers in inter to result array
        int[] result = new int[inter.size()];
        int index = 0;
        for (int n : inter) {
            result[index++] = n;
        }
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums1 = {1,2,3,4,5,5,5,5,5,3,23,2,4,5,3,4,5,7,7,77,77,777};
        int[] nums2 = {2,4,6,5,7,9};
        
        int[] inter = interSection(nums1, nums2);
        
        for (int n : inter) {
            System.out.print(n + " ");
        }
        
    }
    
}
