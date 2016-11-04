/*
 * Copyright 2016 Yuanjie
 */
package pkg172_factorial_tailing_Zeroes;

/*
 
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.


n! = 1 * 2 * 3 ... * n;

10 = 2 * 5

so is how many 5 in n! decide how many 0 in n!

so return n / 5 + n / 25 + n / 125 ...

 */
public class Main {

    public static int tailZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int sum = 0;
        while (n > 0) {
            sum += n / 5;
            n = n / 5;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Expected : 452137076, result : " + tailZeroes(1808548329));
    }
    
}
