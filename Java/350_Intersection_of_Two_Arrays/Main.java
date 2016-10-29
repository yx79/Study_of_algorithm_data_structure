/*
 * Copyright 2016 Yuanjie
 */
package pkg350_intersection_of_two_arrays;

import java.util.ArrayList;
import java.util.HashMap;

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that 
you cannot load all elements into the memory at once?

 */
public class Main {

    public static int[] interSection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        
        HashMap<Integer, Integer> map = new HashMap();
        // put number from nums1[] as key and the value is  times showing up
        for (int n : nums1) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        ArrayList<Integer> list = new ArrayList();
        for (int n : nums2) {
            if (map.containsKey(n)) {
                list.add(n);
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    map.remove(n);
                }
            }
        }
        
        int index = 0;
        int[] result = new int[list.size()];
        for (int n : list) {
            result[index++] = n;
        }
        return result;
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums1 = {1,2,3,4,5,5,5,5,5,3,23,2,4,5,3,4,5,7,7,77,77,777};
        int[] nums2 = {2,4,6,5,5,5,5,7,9};
        
        int[] inter = interSection(nums1, nums2);
        
        for (int n : inter) {
            System.out.print(n + " ");
        }
    }
    
}
