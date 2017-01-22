package pkg268_missing_number;

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement 
it using only constant extra space complexity?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating 
all test cases.

Hide Company Tags Microsoft Bloomberg
Hide Tags Array Math Bit Manipulation
Hide Similar Problems (H) First Missing Positive (E) Single Number (H) Find 
the Duplicate Number

 */
public class Main {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i : nums) {
            sum -= i;
        }
        return sum;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {0, 1, 2, 3, 5};
        System.out.println(missingNumber(nums));
    }
    
}
