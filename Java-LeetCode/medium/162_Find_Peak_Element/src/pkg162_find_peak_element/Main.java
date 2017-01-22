package pkg162_find_peak_element;

/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return 
its index.

The array may contain multiple peaks, in that case return the index to any 
one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function 
should return the index number 2.
Note:
Your solution should be in logarithmic complexity.
 */
public class Main {

    public static int findPeak(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }
    
    public static int binarySearch(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        } 
        
        if (left + 1 == right) {
            return Math.min(nums[left], nums[right]);
        }
        
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]) {
            return binarySearch(nums, left, mid - 1);
        } else {
            return binarySearch(nums, mid, right);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeak(nums));
    }
    
}
