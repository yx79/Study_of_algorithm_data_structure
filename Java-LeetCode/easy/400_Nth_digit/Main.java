/*
 * Copyright 2016 Yuanjie
 */
package pkg400_nth_digit;

/*
400. Nth Digit

Find the nth digit of the infinite integer sequence 
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 
is a 0, which is part of the number 10.


 */
public class Main {

    public static int findNthDigit(int n) {
        // 1 2 3 4 5 6 7 8 9 = 9 * 1
        // 10 11 12 ... 98 99 = 90 * 2
        // 100 101...  998 999 = 900 * 3
        // 1000 ... 9999 = 9000 * 4
        // 10000 ... 99999 = 90000 * 5
        // 100000 ... 999999 = 900000 * 6 = 5400 000
        // 9 000 000 * 7 =     63 000 000
        // 90 000 000 * 8 =   720 000 000
        // 900 000 000 * 9 = 8100 000 000
        
        // 2^31 =            2147 483 648
        // so the number will be atmost 9 digits
        if (n < 10) {
            return n;
        }
        
        int[] count = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999};
        
        long[] numbers = new long[9];
        numbers[0] = 9;
        long nines = 90;
        long sum = 9;
        long curr = 0;
        for (int i = 1; i < 9; i++) {
            numbers[i] = sum + nines * (i + 1);
            sum = numbers[i];
            nines *= 10;
            if (n <= numbers[i]) {
                curr = (n - numbers[i - 1] - 1) / (i + 1) + count[i - 1] + 1;
                Long theInt = curr;
                String numStr = theInt.toString();
                
                //System.out.println("curr:" + curr  + " number[i] " + numbers[i] + ", n:" + n);
                
                int index = (int)(n - numbers[i-1] - 1) % (i + 1);
                
                //System.out.println("string " + numStr + " , index: " + index);
                return (numStr.charAt(index) - '0');
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(findNthDigit(2894)); // 1
        System.out.println(findNthDigit(195)); // 1
        System.out.println(findNthDigit(19)); // 4
    }
    
    
    
}


